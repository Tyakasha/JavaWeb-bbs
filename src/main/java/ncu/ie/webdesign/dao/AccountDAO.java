package ncu.ie.webdesign.dao;

public interface AccountDAO {
    /**
     * 重置用户名
     * @param userName  旧用户名
     * @param newUserName   新用户名
     * @return  返回重置结果
     */
    Integer resetUserName(String userName, String newUserName);

    /**
     * 重置密码
     * @param email 邮箱
     * @param newPassword 新密码
     * @return  返回重置结果
     */
    Integer resetPassword(String email, String newPassword);

    /**
     * 发布问答贴减少积分
     * @param reward    问答贴的积分奖励
     * @param userName  用户名
     * @return  返回减少结果
     */
    Integer reducePoint(int reward, String userName);

    /**
     * 管理员授权用户
     * @param loginAcc 登陆账户
     * @return  返回授权结果
     */
    Integer authorize(String loginAcc);
}
