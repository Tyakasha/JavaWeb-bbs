package ncu.ie.webdesign.dao.impl;

import ncu.ie.webdesign.dao.UerDAO;
import ncu.ie.webdesign.entity.Account;
import ncu.ie.webdesign.entity.UserInfo;
import ncu.ie.webdesign.util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author by Wan HaoDong
 * @date 2019-12-12  16:32
 **/
public class UerDAOImpl implements UerDAO {
    @Override
    public Account queryAccByLoginAcc(String loginAcc) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="select * from account where login_acc=?";
        Account userAcc=null;
        /*进行数据访问并获取数据，进行封装*/
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setObject(1, loginAcc);
            rs=ps.executeQuery();
            while (rs.next()){
                userAcc=new Account(rs.getString("login_acc"),rs.getString("password"),rs.getInt("acc_type"),rs.getInt("points"),rs.getString("register_date"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                JdbcConnection.relase(connection,ps,rs);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return userAcc;
    }

    @Override
    public UserInfo queryUserInfoByLoginAcc(String loginAcc) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="select * from user_info where email=?";
        UserInfo userInfo = null;
        /*进行数据访问并获取数据，进行封装*/
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setObject(1, loginAcc);
            rs=ps.executeQuery();
            while (rs.next()){
                userInfo=new UserInfo(rs.getString("user_name"),rs.getString("email"),rs.getString("job_category"),rs.getString("phone_num"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                JdbcConnection.relase(connection,ps,rs);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return userInfo;
    }

    @Override
    public UserInfo queryUserInfoByCondition(String columnName, String condition) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="select * from user_info where "+columnName+"=?";
        UserInfo userInfo = null;
        /*进行数据访问并获取数据，进行封装*/
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setObject(1, condition);
            rs=ps.executeQuery();
            while (rs.next()){
                userInfo=new UserInfo(rs.getString("user_name"),rs.getString("email"),rs.getString("job_category"),rs.getString("phone_num"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                JdbcConnection.relase(connection,ps,rs);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return userInfo;
    }

    @Override
    public Integer addOneUserInfo(UserInfo userInfo) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="insert into user_info(user_name,email,job_category,phone_num) values(?,?,?,?)";
        int affectedRow=0;
        try {
            ps=connection.prepareStatement(sqlStatement);
            ps.setObject(1, userInfo.getUserName());
            ps.setObject(2, userInfo.getEmail());
            ps.setObject(3, userInfo.getJobCategory());
            ps.setObject(4, userInfo.getPhoneNum());
            /*执行插入sql，并接收返回结果*/
            affectedRow=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcConnection.relase(connection,ps,rs);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return affectedRow;
    }

    @Override
    public Integer addOneAccount(Account account) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="insert into account(login_acc,password) values(?,?)";
        int affectedRow=0;
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setObject(1, account.getLoginAcc());
            ps.setObject(2, account.getPassword());
            affectedRow=ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                JdbcConnection.relase(connection,ps,rs);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return affectedRow;
    }


}
