package akm;
//package ncu.ie.webdesign.dto;

public class UserInfoPageDTO {
    String userName;
    Integer accType;
    String email;
    Integer points;	//账户积分
    String jobCategroy;
    String phoneNum;
    Integer userThumbNum;	//用户被点赞数
    String registerDate;

    public UserInfoPageDTO() {
    }

    public UserInfoPageDTO(String userName, Integer accType, String email, Integer points, String jobCategroy, String phoneNum, Integer userThumbNum, String registerDate) {
        this.userName = userName;
        this.accType = accType;
        this.email = email;
        this.points = points;
        this.jobCategroy = jobCategroy;
        this.phoneNum = phoneNum;
        this.userThumbNum = userThumbNum;
        this.registerDate = registerDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAccType() {
        return accType;
    }

    public void setAccType(Integer accType) {
        this.accType = accType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getJobCategroy() {
        return jobCategroy;
    }

    public void setJobCategroy(String jobCategroy) {
        this.jobCategroy = jobCategroy;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getUserThumbNum() {
        return userThumbNum;
    }

    public void setUserThumbNum(Integer userThumbNum) {
        this.userThumbNum = userThumbNum;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "UserInfoPageDTO{" +
                "userName='" + userName + '\'' +
                ", accType=" + accType +
                ", email='" + email + '\'' +
                ", points=" + points +
                ", jobCategroy='" + jobCategroy + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", userThumbNum=" + userThumbNum +
                ", registerDate='" + registerDate + '\'' +
                '}';
    }
}
