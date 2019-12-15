package ncu.ie.webdesign.entity;

/**
 * @author by Wan HaoDong
 * @date 2019-12-11  20:53
 * @description     用户账户实体类
 **/
public class Account {

    /**
     * 账户登录账号
     */
    private String loginAcc;

    /**
     * 账号登录密码
     */
    private String password;

    /**
     * 账户类型
     * 1表示管理员，0表示普通用户
     */
    private Integer accType;

    /*
    * 账户积分
    * */
    private Integer points;

    /**
     * 账号注册日期
     */
    private String registerDate;

    public Account() {
    }

    public Account(String loginAcc, String password, Integer accType, Integer points, String registerDate) {
        this.loginAcc = loginAcc;
        this.password = password;
        this.accType = accType;
        this.points = points;
        this.registerDate = registerDate;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getLoginAcc() {
        return loginAcc;
    }

    public void setLoginAcc(String loginAcc) {
        this.loginAcc = loginAcc;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public Integer getAccType() {
        return accType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "loginAcc='" + loginAcc + '\'' +
                ", password='" + password + '\'' +
                ", accType=" + accType +
                ", points=" + points +
                ", registerDate='" + registerDate + '\'' +
                '}';
    }
}
