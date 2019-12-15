package ncu.ie.webdesign.entity;

/**
 * @author by Wan HaoDong
 * @date 2019-12-14  10:33
 * @description     用户信息实体类
 **/
public class UserInfo {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户邮箱，与用户登录账号关联
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


    public UserInfo() {
    }

    public UserInfo(String userName, String email, String jobCategory, String phoneNum) {
        this.userName = userName;
        this.email = email;
        this.jobCategory = jobCategory;
        this.phoneNum = phoneNum;
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", jobCategory='" + jobCategory + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

}
