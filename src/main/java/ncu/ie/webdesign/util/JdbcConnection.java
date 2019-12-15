package ncu.ie.webdesign.util;

import java.sql.*;

/**
 * @author by Wan HaoDong
 * @date 2019-12-11  20:34
 **/
public class JdbcConnection {

    private static String url;
    private static String userName;
    private static String password;

    /*
    *初始化数据库连接配置信息
    *并注册数据库驱动
    * */
    static {
        try{
            String driverName = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://122.51.9.156:3306/bbs?serverTimezone=UTC&characterEncoding=utf8";
            userName = "root";
            password = "mysql@vinfer";
            //注册驱动
            Class.forName(driverName);
        }catch ( Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("获取数据库配置数据异常，请检查");
        }
    }

    /**
     * 获取数据连接对象
     * @return   返回一个数据库连接对象
     */
    public static Connection getConnection(){
        Connection connection;
        try{
            //通过DriverManager获取连接对象
            connection= DriverManager.getConnection(url,userName,password);
        }catch (SQLException ex){
            ex.printStackTrace();
            throw new RuntimeException("获取数据库连接异常，请检查配置文件");
        }
        return connection;
    }

    /**
     * 每一次连接完成数据交换后都需要关闭对象
     * 释放资源,连接对象待最后再关闭
     *
     * @param ps                语句执行对象
     * @param rs                 结果集接收对象
     * @throws Exception        sql异常
     */
    public static void relase(Connection con, PreparedStatement ps, ResultSet rs) throws Exception{
        if(rs!=null){
            rs.close();
        }
        if(ps!=null){
            ps.close();
        }
        //Connection对象放在最后关闭
        if(con!=null){
            con.close();
        }
    }

}
