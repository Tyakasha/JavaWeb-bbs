package ncu.ie.webdesign.service;

import ncu.ie.webdesign.dto.UserAccInfoDTO;
import ncu.ie.webdesign.entity.Account;
import ncu.ie.webdesign.entity.UserInfo;

/**
 * @author by Wan HaoDong
 * @date 2019-12-12  16:34
 * @description 用户服务业务逻辑接口
 **/
public interface UserService {

    /**
     * 用户登录验证
     * @param loginAcc              用户登录账号
     * @param password             登录密码
     * @return                              返回登录校验结果
     */
    Boolean loginCheck(String loginAcc,String password);

    /**
     * 通过登录账号获取用户账号信息
     * @param loginAcc              用户登录账号
     * @return                              返回用户账号信息
     */
    Account getUserAccByLoginAcc(String loginAcc);

    /**
     * 通过用户登录账号获取用户信息
     * @param loginAcc              用户登录账号
     * @return                              返回用户信息
     */
    UserInfo getUserInfoByLoginAcc(String loginAcc);

    /**
     * 通过用户登录账号获取用户信息及账户新的数据传输对象
     * @param loginAcc              用户登录账号
     * @return                              返回用户信息及账户新的数据传输对象
     */
    UserAccInfoDTO getUserAccInfoDTOByLoginAcc(String loginAcc);

    /**
     * 用户注册
     * @param userAccInfoDTO            用户信息及账户信息数据传输对象
     * @return                                      返回注册结果信息
     */
    String userRegister(UserAccInfoDTO userAccInfoDTO);


}
