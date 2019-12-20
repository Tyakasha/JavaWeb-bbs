package ncu.ie.webdesign.dto;



/**
 * @author by Wan HaoDong
 * @date 2019-12-20    06:45
 **/
public class UserManageDTO {

    /**
     * 行号，用于前端显示
     */
    private Integer rowNum;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 登录账号
     */
    private String loginAcc;

    /**
     * 账户类型
     */
    private Integer  accType;

    /**
     * 注册日期
     */
    private String registerDate;

    public UserManageDTO() {
    }

    public UserManageDTO(Integer rowNum, String userName, String loginAcc, Integer accType, String registerDate) {
        this.rowNum = rowNum;
        this.userName = userName;
        this.loginAcc = loginAcc;
        this.accType = accType;
        this.registerDate = registerDate;
    }

    public Integer getRowNum() {
        return rowNum;
    }

    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginAcc() {
        return loginAcc;
    }

    public void setLoginAcc(String loginAcc) {
        this.loginAcc = loginAcc;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getAccType() {
        return accType;
    }

    public void setAccType(Integer accType) {
        this.accType = accType;
    }

    @Override
    public String toString() {
        return "UserManageDTO{" +
                "rowNum=" + rowNum +
                ", userName='" + userName + '\'' +
                ", loginAcc='" + loginAcc + '\'' +
                ", accType=" + accType +
                ", registerDate='" + registerDate + '\'' +
                '}';
    }
}
