package ncu.ie.webdesign.dao;

import ncu.ie.webdesign.entity.Account;
import ncu.ie.webdesign.entity.Posts;
import ncu.ie.webdesign.entity.UserInfo;

import java.util.List;

/**
 * @author by Wan HaoDong
 * @date 2019-12-12  16:30
 * @description 用户数据访问接口
 **/
public interface UserInfoDAO {

    /**
     * 根据用户登录账号获取用户账户信息
     * @param loginAcc              登录账号
     * @return                              返回用户账户信息
     */
    Account queryAccByLoginAcc(String loginAcc);

    /**
     * 获取所有账户信息
     * @return  返回所有账户信息
     */
    List<Account> queryAllAccountInfo();

    /**
     * 获取所有用户信息
     * @return      返回所有用户信息
     */
    List<UserInfo> queryAllUserInfo();

    /**
     * 根据用户登录账号获取用户信息
     * @param userName              登录账号
     * @return                              返回用户信息
     */
    UserInfo queryUserInfoByUserName(String userName);

    /**
     * 通过登录账号查询用户信息
     * @param loginAcc      用户登录账号
     * @return  返回用户信息
     */
    UserInfo queryUserInfoByLoginAcc(String loginAcc);

    /**
     * 根据传入的列名和条件查询用户信息
     * @param columnName                数据库表字段的列名
     * @param condition                      查询条件
     * @return                                      返回查询信息
     */
    UserInfo queryUserInfoByCondition(String columnName,String condition);

    /**
     * 新增一个用户信息
     * @param userInfo              用户信息
     * @return                              返回插入结果，成功返回1，否则返回0
     */
    Integer addOneUserInfo(UserInfo userInfo);

    /**
     * 新增一个账户信息
     * @param account               账户信息
     * @return                              返回插入结果，成功返回1，否则返回0
     */
    Integer addOneAccount(Account account);

    /**
     * 重置用户名
     * @param userName  旧用户名
     * @param newUserName   新用户名
     * @return  返回重置结果
     */
    Integer resetUserName(String userName,String newUserName);

    /**
     *  根据用户名和邮箱判断用户正确性
     * @param userName 用户名
     * @param email 电子邮箱，即登陆账户
     * @return  返回验证结果
     */
    Boolean userCheck(String userName,String email);

    /**
     * 重置工作类别
     * @param userName  用户名
     * @param newJobCategory    新工作类别
     * @return  返回重置结果
     */
    Integer resetJobCategory(String userName,String newJobCategory);

    /**
     *
     * @param newPhoneNum   新的电话号码
     * @param userName   用户名
     * @return  返回充值结果
     */
    Integer resetPhoneNum(String newPhoneNum,String userName);

    /**
     * 用户获取自己发布过的所有普通帖子（要限定帖子类型）
     * @param userName 用户名
     * @return  返回所有的帖子
     */
    List<Posts> getMyPosts(String userName);

    /**
     * 用户获取自己发布过的所有问答帖（要限定帖子类型）
     * @param userName 用户名
     * @return 返回所有的问答帖
     */
    List<Posts> getMyQuestionPosts(String userName);

    /**
     * 插入一个问答帖,也就是需要reward的
     * @param title 帖子标题
     * @param content   帖子内容
     * @param tag   帖子标签
     * @param type  帖子种类 0普通帖 1精品帖
     * @param reward    帖子的积分奖励
     * @param userName  发布者用户名
     * @return  返回插入结果
     */
    Integer addOneQuestionPost(String title,String content,String tag,int type,int reward,String userName);


    /**
     * 插入一个普通帖子，也就是不需要reward的
     * @param title
     * @param content
     * @param tag
     * @param type
     * @param userName
     * @return
     */
    Integer addOneNormalPost(String title,String content,String tag,int type,String userName);


    /**
     * 根据账号获取该账号的积分
     * @param userName 用户名
     * @return  返回账户积分
     */
    Integer getPoint(String userName);

}
