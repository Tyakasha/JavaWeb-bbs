package ncu.ie.webdesign.service.impl;

import ncu.ie.webdesign.dao.impl.UerDAOImpl;
import ncu.ie.webdesign.dto.UserAccInfoDTO;
import ncu.ie.webdesign.entity.Account;
import ncu.ie.webdesign.entity.UserInfo;
import ncu.ie.webdesign.service.UserService;

/**
 * @author by Wan HaoDong
 * @date 2019-12-12  16:36
 * @description 用户服务实现类
 **/
public class UserServiceImpl implements UserService {
    @Override
    public Boolean loginCheck(String loginAcc, String password) {
        UerDAOImpl uerDAO=new UerDAOImpl();
        /*根据登录账号获取账号信息*/
        Account userAcc=uerDAO.queryAccByLoginAcc(loginAcc);
        if(userAcc==null){
            return false;
        }else {
            return userAcc.getPassword().equals(password);
        }
    }

    @Override
    public Account getUserAccByLoginAcc(String loginAcc) {
        UerDAOImpl uerDAO=new UerDAOImpl();
        return uerDAO.queryAccByLoginAcc(loginAcc);
    }

    @Override
    public UserInfo getUserInfoByLoginAcc(String loginAcc) {
        UerDAOImpl uerDAO=new UerDAOImpl();
        return uerDAO.queryUserInfoByLoginAcc(loginAcc);
    }

    @Override
    public UserAccInfoDTO getUserAccInfoDTOByLoginAcc(String loginAcc) {
        UerDAOImpl userDAO=new UerDAOImpl();
        /*
        * 获取用户信息及账户信息
        * */
        UserInfo userInfo=userDAO.queryUserInfoByLoginAcc(loginAcc);
        Account userAcc=userDAO.queryAccByLoginAcc(loginAcc);
        /*
        * 封装两者的数据传输对象
        * */
        UserAccInfoDTO userAccInfoDTO=new UserAccInfoDTO(
                userInfo.getUserName(),userInfo.getEmail(),
                userInfo.getJobCategory(),userInfo.getPhoneNum(),
                userAcc.getPassword(),userAcc.getAccType(),
                userAcc.getPoints(), userAcc.getRegisterDate()
        );
        return userAccInfoDTO;
    }

    @Override
    public String userRegister(UserAccInfoDTO userAccInfoDTO) {
        UerDAOImpl userDAO=new UerDAOImpl();
        String userName=userAccInfoDTO.getUserName();
        String email=userAccInfoDTO.getEmail();
        /*
        * 先进行唯一验证
        * 唯一验证通过即用户名和邮箱都不重复时
        * 才允许最终的注册
        * */
        if(userDAO.queryUserInfoByCondition("user_name", userName)!=null){
            return "existing-userName";
        }else if(userDAO.queryUserInfoByCondition("email", email)!=null){
            return "existing-email";
        } else {
            UserInfo userInfo=new UserInfo(userName,email,userAccInfoDTO.getJobCategory(),userAccInfoDTO.getPhoneNum());
            Account account=new Account();
            account.setLoginAcc(userAccInfoDTO.getEmail());
            account.setPassword(userAccInfoDTO.getPassword());
            Integer userInsertResult = userDAO.addOneUserInfo(userInfo);
            Integer accInsertResult = userDAO.addOneAccount(account);
            if(userInsertResult==1&&accInsertResult==1){
                return "success";
            }else {
                return "error";
            }
        }

    }


}
