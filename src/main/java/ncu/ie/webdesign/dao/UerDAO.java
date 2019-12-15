package ncu.ie.webdesign.dao;

import ncu.ie.webdesign.entity.Account;
import ncu.ie.webdesign.entity.UserInfo;

/**
 * @author by Wan HaoDong
 * @date 2019-12-12  16:30
 * @description 用户数据访问接口
 **/
public interface UerDAO {

    /**
     * 根据用户登录账号获取用户账户信息
     * @param loginAcc              登录账号
     * @return                              返回用户账户信息
     */
    Account queryAccByLoginAcc(String loginAcc);

    /**
     * 根据用户登录账号获取用户信息
     * @param loginAcc              登录账号
     * @return                              返回用户信息
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

}
