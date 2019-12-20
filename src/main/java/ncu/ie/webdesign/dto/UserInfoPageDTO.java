package ncu.ie.webdesign.dto;

/**
 * @author by Wan HaoDong
 * @date 2019-12-19    17:21
 **/
public class UserInfoPageDTO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 账户类型
     */
    private Integer accType;

    /**
     * 账户积分
     */
    private Integer points;

    /**
     * 工作性质
     */
    private String jobCategory;

    /**
     * 联系手机
     */
    private String phoneNum;

    /**
     * 账号注册日期
     */
    private String registerDate;

    /**
     * 用户被点赞数
     * （发表过的帖子获得的总赞数）
     */
    private Integer  beenThumbNum;

    public UserInfoPageDTO(String userName, String email, Integer accType, Integer points, String jobCategory, String phoneNum, String registerDate, Integer beenThumbNum) {
        this.userName = userName;
        this.email = email;
        this.accType = accType;
        this.points = points;
        this.jobCategory = jobCategory;
        this.phoneNum = phoneNum;
        this.registerDate = registerDate;
        this.beenThumbNum = beenThumbNum;
    }

    public UserInfoPageDTO() {
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

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getBeenThumbNum() {
        return beenThumbNum;
    }

    public void setBeenThumbNum(Integer beenThumbNum) {
        this.beenThumbNum = beenThumbNum;
    }

    @Override
    public String toString() {
        return "UserInfoPageDTO{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", accType=" + accType +
                ", points=" + points +
                ", jobCategory='" + jobCategory + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", registerDate='" + registerDate + '\'' +
                ", beenThumbNum=" + beenThumbNum +
                '}';
    }
}
