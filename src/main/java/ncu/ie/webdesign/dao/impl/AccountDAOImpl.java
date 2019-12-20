package ncu.ie.webdesign.dao.impl;

import ncu.ie.webdesign.dao.AccountDAO;
import ncu.ie.webdesign.util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public Integer resetUserName(String userName, String newUserName) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;
        String sqlStatement="update account SET login_acc=? where login_acc=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,newUserName);
            ps.setString(2,userName);
            affectedRow=ps.executeUpdate();
        }
        catch (Exception e)
        {
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
    public Integer resetPassword(String email,String newPassword) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;
        String sqlStatement="update account SET password=? where login_acc=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,newPassword);
            ps.setString(2,email);
            affectedRow=ps.executeUpdate();
        }
        catch (Exception e)
        {
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
    public Integer reducePoint(int reward, String userName) {
        int affectedRow=0;
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="UPDATE account SET points=points-? WHERE login_acc=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1,reward);
            ps.setString(2,userName);
            affectedRow=ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
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
    public Integer authorize(String loginAcc) {
        int affectedRow=0;
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="UPDATE account SET acc_type=1 WHERE login_acc=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,loginAcc);
            affectedRow=ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
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
