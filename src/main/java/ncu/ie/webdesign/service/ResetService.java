package ncu.ie.webdesign.service;

import com.sun.org.apache.xpath.internal.operations.Bool;

public interface ResetService {

    /**
     *判断重置用户名
     * @param userName  旧用户名
     * @param newUserName   新用户名
     * @return  判断是否重置成功
     */
    Boolean resetUserNameCheck(String userName, String newUserName);

    /**
     *判断重置密码
     * @param userName 用户名
     * @param email 邮箱
     * @param newPassword 新密码

     * @return 判断是否重置成功
     */
    Boolean resetPasswordCheck(String userName, String email, String newPassword);

    /**
     *判断重置工作类别
     * @param newJobCategory   新的工作类别
     * @param userName      用户名
     * @return  判断是否重置成功
     */
    Boolean resetJobCategoryCheck(String newJobCategory, String userName);


    /**
     *判断重置电话号码
     * @param newPhoneNum   新的电话号码
     * @param userName      用户名
     * @return  判断是否重置成功
     */
    Boolean resetPhoneNumCheck(String newPhoneNum, String userName);
}
