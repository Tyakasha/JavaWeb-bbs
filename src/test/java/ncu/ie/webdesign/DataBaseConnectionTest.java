package ncu.ie.webdesign;

import ncu.ie.webdesign.entity.Account;
import ncu.ie.webdesign.util.JdbcConnection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author by Wan HaoDong
 * @date 2019-12-11  20:48
 **/
public class DataBaseConnectionTest {


    @Test
    public void tableAccountTest(){
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        String sqlStatement="select * from account where login_acc='vinfer@123.com'";
        Account userAcc=null;
        /*进行数据访问并获取数据，进行封装*/
        try{
            ps=connection.prepareStatement(sqlStatement);
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
        System.out.println(userAcc);
        /*最终测试结果和预期一致，该表以及数据库连接的测试通过*/
    }

}
