package ncu.ie.webdesign.service.impl;


import ncu.ie.webdesign.dao.ThumbDAO;
import ncu.ie.webdesign.dao.UserInfoDAO;
import ncu.ie.webdesign.dao.impl.ThumbDAOImpl;
import ncu.ie.webdesign.dao.impl.UserInfoDAOImpl;
import ncu.ie.webdesign.dto.PostsDTO;
import ncu.ie.webdesign.dto.UserAccInfoDTO;
import ncu.ie.webdesign.dto.UserInfoPageDTO;
import ncu.ie.webdesign.dto.UserManageDTO;
import ncu.ie.webdesign.entity.Account;
import ncu.ie.webdesign.entity.Posts;
import ncu.ie.webdesign.entity.ThumbInfo;
import ncu.ie.webdesign.entity.UserInfo;
import ncu.ie.webdesign.service.PostsService;
import ncu.ie.webdesign.service.ThumbService;
import ncu.ie.webdesign.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by Wan HaoDong
 * @date 2019-12-12  16:36
 * @description 用户服务实现类
 **/
public class UserServiceImpl implements UserService {
    @Override
    public Boolean loginCheck(String loginAcc, String password) {
        UserInfoDAOImpl uerDAO=new UserInfoDAOImpl();
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
        UserInfoDAOImpl uerDAO=new UserInfoDAOImpl();
        return uerDAO.queryAccByLoginAcc(loginAcc);
    }

    @Override
    public List<UserManageDTO> getAllUserManageDTO() {
        UserInfoDAO userInfoDAO=new UserInfoDAOImpl();
        List<UserInfo> allUserInfo=userInfoDAO.queryAllUserInfo();
        List<UserManageDTO> allUserManageDTO=new ArrayList<>();
        Integer counter=1;
        for (UserInfo userInfo:allUserInfo){
            String userName=userInfo.getUserName();
            String loginAcc=userInfo.getEmail();
            String accRegisterDate=userInfoDAO.queryAccByLoginAcc(loginAcc).getRegisterDate();
            Integer accType=userInfoDAO.queryAccByLoginAcc(loginAcc).getAccType();
            allUserManageDTO.add(new UserManageDTO(counter,userName,loginAcc,accType,accRegisterDate));
            counter++;
        }
        return allUserManageDTO;
    }


    @Override
    public UserInfo getUserInfoByUserName(String userName) {
        UserInfoDAOImpl uerDAO=new UserInfoDAOImpl();
        return uerDAO.queryUserInfoByUserName(userName);
    }

    @Override
    public UserAccInfoDTO getUserAccInfoDTOByLoginAcc(String loginAcc) {
        UserInfoDAOImpl userDAO=new UserInfoDAOImpl();
        /*
        * 获取用户信息及账户信息
        * */
        UserInfo userInfo=userDAO.queryUserInfoByLoginAcc(loginAcc);
        Account userAcc=userDAO.queryAccByLoginAcc(loginAcc);
        /*
        * 封装两者的数据传输对象
        * */
        return new UserAccInfoDTO(
                userInfo.getUserName(),userInfo.getEmail(),
                userInfo.getJobCategory(),userInfo.getPhoneNum(),
                userAcc.getPassword(),userAcc.getAccType(),
                userAcc.getPoints(), userAcc.getRegisterDate()
        );
    }

    @Override
    public UserInfoPageDTO getUserInfoPageDTOByUserName(String userName) {
        UserService userService=new UserServiceImpl();
        UserInfo userInfo=userService.getUserInfoByUserName(userName);
        UserAccInfoDTO userAcc=getUserAccInfoDTOByLoginAcc(userInfo.getEmail());
        //String userName, String email, Integer accType, Integer points, String jobCategory, String phoneNum, String registerDate, Integer beenThumbNum
        UserInfoPageDTO  userInfoPageDTO=new UserInfoPageDTO(
                userAcc.getUserName(),userAcc.getEmail(),userAcc.getAccType(),
                userAcc.getPoints(),userAcc.getJobCategory(),userAcc.getPhoneNum(),
                userAcc.getRegisterDate(),0
        );
        /*
        * 通过获取已发过的帖子来计算该用户的
        * 被点赞数
        * */
        List<PostsDTO> myPosts = userService.getMyPosts(userName);
        /*
        * 非空才有计算的意义
        * */
        if(myPosts!=null){
            Integer beenThumbNum=0;
            List<ThumbInfo> thumbInfos;
            ThumbDAO thumbDAO=new ThumbDAOImpl();
            for (PostsDTO postsDTO:myPosts){
                Integer postsId=postsDTO.getPostsId();
                thumbInfos = thumbDAO.queryAllThumbInfoByPostsId(postsId);
                if(thumbInfos!=null&&thumbInfos.size()>0){
                    beenThumbNum+=thumbInfos.size();
                }
            }
            userInfoPageDTO.setBeenThumbNum(beenThumbNum);
        }
        return userInfoPageDTO;
    }

    @Override
    public String userRegister(UserAccInfoDTO userAccInfoDTO) {
        UserInfoDAOImpl userDAO=new UserInfoDAOImpl();
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

    @Override
    public List<PostsDTO> getMyPosts(String userName) {
        UserInfoDAOImpl uerDAO=new UserInfoDAOImpl();
        List<Posts> posts=new ArrayList<>();
        List<PostsDTO> myPosts=new ArrayList<>();
        posts=uerDAO.getMyPosts(userName);
        for(int i=0;i<posts.size();i++)
        {
            PostsDTO myPosts2=new PostsDTO();
            myPosts2.setPostsId(posts.get(i).getPostsId());
            myPosts2.setContent(posts.get(i).getContent());
            myPosts2.setTitle(posts.get(i).getTitle());
            myPosts2.setThumbNum(posts.get(i).getThumbNum());
            myPosts2.setPostUser(posts.get(i).getPostUser());
            myPosts2.setPostDate(posts.get(i).getPostDate());
            myPosts2.setTopFlag(posts.get(i).getTopFlag());
            myPosts.add(myPosts2);
        }
        return myPosts;
    }

    @Override
    public List<PostsDTO> getMyQuestionPosts(String userName) {
        UserInfoDAOImpl uerDAO=new UserInfoDAOImpl();
        List<Posts> posts=new ArrayList<>();
        List<PostsDTO> myQuestionPosts=new ArrayList<>();
        posts=uerDAO.getMyQuestionPosts(userName);
        for(int i=0;i<posts.size();i++)
        {
            PostsDTO myQuestionPosts2=new PostsDTO();
            myQuestionPosts2.setPostsId(posts.get(i).getPostsId());
            myQuestionPosts2.setContent(posts.get(i).getContent());
            myQuestionPosts2.setTitle(posts.get(i).getTitle());
            myQuestionPosts2.setThumbNum(posts.get(i).getThumbNum());
            myQuestionPosts2.setPostUser(posts.get(i).getPostUser());
            myQuestionPosts2.setPostDate(posts.get(i).getPostDate());
            myQuestionPosts2.setTopFlag(posts.get(i).getTopFlag());
            myQuestionPosts.add(myQuestionPosts2);
        }
        return myQuestionPosts;
    }

}
