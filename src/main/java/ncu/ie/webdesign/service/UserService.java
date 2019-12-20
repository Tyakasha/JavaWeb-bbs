package ncu.ie.webdesign.service;

import ncu.ie.webdesign.dto.PostsDTO;
import ncu.ie.webdesign.dto.UserAccInfoDTO;
import ncu.ie.webdesign.dto.UserInfoPageDTO;
import ncu.ie.webdesign.dto.UserManageDTO;
import ncu.ie.webdesign.entity.Account;
import ncu.ie.webdesign.entity.UserInfo;

import java.util.List;

/**
 * @author by Wan HaoDong
 * @date 2019-12-12  16:34
 * @description 用户服务业务逻辑接口
 **/
public interface UserService {

    /**
     * 用户登录验证
     * @param loginAcc             用户登录账号
     * @param password             登录密码
     * @return                              返回登录校验结果
     */
    Boolean loginCheck(String loginAcc, String password);


    /**
     * 通过登录账号获取用户账号信息
     * @param loginAcc              用户登录账号
     * @return                              返回用户账号信息
     */
    Account getUserAccByLoginAcc(String loginAcc);

    /**
     * 获取所有的用户管理界面的信息
     * @return  返回结果信息
     */
    List<UserManageDTO> getAllUserManageDTO();


    /**
     * 通过用户登录账号获取用户信息
     * @param userName              用户登录账号
     * @return                              返回用户信息
     */
    UserInfo getUserInfoByUserName(String userName);


    /**
     * 通过用户登录账号获取用户信息及账户新的数据传输对象
     * @param loginAcc              用户登录账号
     * @return                              返回用户信息及账户新的数据传输对象
     */
    UserAccInfoDTO getUserAccInfoDTOByLoginAcc(String loginAcc);

    /**
     * 通过用户名获取用户信息页数据
     * @param userName     用户名
     * @return  返回信息数据
     */
    UserInfoPageDTO getUserInfoPageDTOByUserName(String userName);

    /**
     * 用户注册
     * @param userAccInfoDTO            用户信息及账户信息数据传输对象
     * @return                                      返回注册结果信息
     */
    String userRegister(UserAccInfoDTO userAccInfoDTO);

    /**
     * 用户获取自己发布过的所有普通帖子（限定帖子类型）
     * @param userName  用户名
     * @return 所有结果
     */
    List<PostsDTO> getMyPosts(String userName);

    /**
     * 用户获取自己发布过的所有问答帖（限定帖子类型）
     * @param userName  用户名
     * @return 所有结果
     */
    List<PostsDTO> getMyQuestionPosts(String userName);

}
