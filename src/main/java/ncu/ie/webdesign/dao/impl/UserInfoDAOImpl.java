package ncu.ie.webdesign.dao.impl;

import ncu.ie.webdesign.dao.UserInfoDAO;
import ncu.ie.webdesign.entity.Account;
import ncu.ie.webdesign.entity.Posts;
import ncu.ie.webdesign.entity.UserInfo;
import ncu.ie.webdesign.util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by Wan HaoDong
 * @date 2019-12-12  16:32
 **/
public class UserInfoDAOImpl implements UserInfoDAO {
    /**
     * 根据用户登录账号获取用户账户信息
     * @param loginAcc              登录账号
     * @return                              返回用户账户信息
     */
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
    public List<Account> queryAllAccountInfo() {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="select * from account where login_acc=?";
        List<Account> allAccountInfo=new ArrayList<>();
        /*进行数据访问并获取数据，进行封装*/
        try{
            ps=connection.prepareStatement(sqlStatement);
            rs=ps.executeQuery();
            while (rs.next()){
                allAccountInfo.add(new Account(rs.getString("login_acc"),rs.getString("password"),rs.getInt("acc_type"),rs.getInt("points"),rs.getString("register_date")));
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
        return allAccountInfo;
    }

    @Override
    public List<UserInfo> queryAllUserInfo() {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="select * from user_info";

        List<UserInfo> allUserInfo=new ArrayList<>();
        /*进行数据访问并获取数据，进行封装*/
        try{
            ps=connection.prepareStatement(sqlStatement);
            rs=ps.executeQuery();
            while (rs.next()){
                allUserInfo.add(new UserInfo(rs.getString("user_name"),rs.getString("email"),rs.getString("job_category"),rs.getString("phone_num")));
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
        return allUserInfo;
    }

    /**
     * 根据用户登录账号获取用户信息
     * @param userName              登录账号
     * @return                              返回用户信息
     */
    @Override
    public UserInfo queryUserInfoByUserName(String userName) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="select * from user_info where user_name=?";
        UserInfo userInfo = null;
        /*进行数据访问并获取数据，进行封装*/
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setObject(1, userName);
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


    /**
     * 根据传入的列名和条件查询用户信息
     * @param columnName                数据库表字段的列名
     * @param condition                      查询条件
     * @return                                      返回查询信息
     */
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


    /**
     * 新增一个用户信息
     * @param userInfo              用户信息
     * @return                              返回插入结果，成功返回1，否则返回0
     */
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


    /**
     * 新增一个账户信息
     * @param account               账户信息
     * @return                              返回插入结果，成功返回1，否则返回0
     */
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

    @Override
    public Integer resetUserName(String userName, String newUserName) {

        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        int affectedRow=0;
        /*初始化sql语句*/
        String sqlStatement="update user_info SET user_name=? where user_name=?";
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
    public Boolean userCheck(String userName, String email) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;
        boolean flag;

        String sqlStatement="SELECT user_name FROM user_info WHERE user_name=? AND email=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,userName);
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
        if(affectedRow==1)
        {
            flag=true;
        }
        else
        {
            flag=false;
        }
        return flag;
    }

    @Override
    public Integer resetJobCategory(String userName, String newJobCategory) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;

        String sqlStatement="UPDATE user_info SET job_category=? where user_name=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,newJobCategory);
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
    public Integer resetPhoneNum(String newPhoneNum, String userName) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;

        String sqlStatement="UPDATE user_info SET phone_num=? where user_name=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,newPhoneNum);
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
    public List<Posts> getMyPosts(String userName) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        String sqlStatement="SELECT * FROM posts WHERE post_user=? AND type=0";
        List<Posts> posts=new ArrayList<>();
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,userName);
            rs=ps.executeQuery();
            while (rs.next()){
                Posts posts2=new Posts();
                posts2.setPostsId(rs.getInt("posts_id"));
                posts2.setPostUser( rs.getString("post_user"));
                posts2.setTitle(rs.getString("title"));
                posts2.setContent(rs.getString("content"));
                posts2.setType(rs.getInt("type"));
                posts2.setTag(rs.getString("tag"));
                posts2.setThumbNum(rs.getInt("thumb_num"));
                posts2.setTopFlag(rs.getInt("top_flag"));
                posts2.setBoutiqueFlag(rs.getInt("boutique_flag"));
                posts2.setPostDate(rs.getString("post_date"));
                posts2.setReward(rs.getInt("reward"));
                posts.add(posts2);
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
        return posts;
    }

    @Override
    public List<Posts> getMyQuestionPosts(String userName) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        String sqlStatement="SELECT * FROM posts WHERE post_user=? AND type=1";
        List<Posts> posts=new ArrayList<>();
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,userName);
            rs=ps.executeQuery();
            while (rs.next()){
                Posts posts2=new Posts();
                posts2.setPostsId(rs.getInt("posts_id"));
                posts2.setPostUser( rs.getString("post_user"));
                posts2.setTitle(rs.getString("title"));
                posts2.setContent(rs.getString("content"));
                posts2.setType(rs.getInt("type"));
                posts2.setTag(rs.getString("tag"));
                posts2.setThumbNum(rs.getInt("thumb_num"));
                posts2.setTopFlag(rs.getInt("top_flag"));
                posts2.setBoutiqueFlag(rs.getInt("boutique_flag"));
                posts2.setPostDate(rs.getString("post_date"));
                posts2.setReward(rs.getInt("reward"));
                posts.add(posts2);
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
        return posts;
    }

    @Override
    public Integer addOneQuestionPost(String title, String content, String tag, int type, int reward, String userName) {
        int affectedRow=0;
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="INSERT INTO posts(post_user,title,content,type,tag,thumb_num,reward) values(?,?,?,?,?,?,?)";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,userName);
            ps.setString(2,title);
            ps.setString(3,content);
            ps.setInt(4,type);
            ps.setString(5,tag);
            ps.setInt(6,0);
            ps.setInt(7,reward);
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
    public Integer addOneNormalPost(String title, String content, String tag, int type, String userName) {
        int affectedRow=0;
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="INSERT INTO posts(post_user,title,content,type,tag,thumb_num) values(?,?,?,?,?,?)";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,userName);
            ps.setString(2,title);
            ps.setString(3,content);
            ps.setInt(4,type);
            ps.setString(5,tag);
            ps.setInt(6,0);
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
    public Integer getPoint(String userName) {
        int point=0;
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="SELECT * FROM account WHERE login_acc=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,userName);
            rs=ps.executeQuery();
            while (rs.next())
            {
                point=rs.getInt("points");
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
        return point;
    }


}
