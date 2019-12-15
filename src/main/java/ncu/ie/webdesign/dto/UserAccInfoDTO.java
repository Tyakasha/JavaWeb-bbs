package ncu.ie.webdesign.dto;

/**
 * @author by Wan HaoDong
 * @date 2019-12-14    15:24
 * @description     用户信息及用户账户信息数据传输对象，将用户信息及账户信息同时封装到一个DTO中回传给前端
 **/
public class UserAccInfoDTO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户邮箱/登录账号
     */
    private String email;

    /**
     * 用户工作性质
     */
    private String jobCategory;

    /**
     * 用户联系电话
     */
    private String phoneNum;

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


    public UserAccInfoDTO() {
    }

    public UserAccInfoDTO(String userName, String email, String jobCategory, String phoneNum, String password, Integer accType, Integer points, String registerDate) {
        this.userName = userName;
        this.email = email;
        this.jobCategory = jobCategory;
        this.phoneNum = phoneNum;
        this.password = password;
        this.accType = accType;
        this.points = points;
        this.registerDate = registerDate;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccType() {
        return accType;
    }

    public void setAccType(Integer accType) {
        this.accType = accType;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    @Override
    public String toString() {
        return "UserAccInfoDTO{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", jobCategory='" + jobCategory + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                ", accType=" + accType +
                ", points=" + points +
                ", registerDate='" + registerDate + '\'' +
                '}';
    }
}
