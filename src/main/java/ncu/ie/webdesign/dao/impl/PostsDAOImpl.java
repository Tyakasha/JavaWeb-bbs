package ncu.ie.webdesign.dao.impl;

import ncu.ie.webdesign.dao.PostsDAO;
import ncu.ie.webdesign.entity.Posts;
import ncu.ie.webdesign.util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostsDAOImpl implements PostsDAO {
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
        String sqlStatement="update posts SET post_user=? where post_user=?";
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
    public List<Posts> getAllPosts() {

        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="SELECT * FROM posts";
        List<Posts> posts=new ArrayList<>();
        try{
            ps=connection.prepareStatement(sqlStatement);
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
    public Posts queryPostsById(Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="SELECT * FROM posts WHERE posts_id=?";
        Posts posts=null;
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1,postsId);
            rs=ps.executeQuery();
            while(rs.next()) {
                //Integer postsId, String postUser, String title, String content, Integer type, String tag, Integer thumbNum, Integer topFlag, Integer boutiqueFlag, String postDate, Integer reward
                posts=new Posts(rs.getInt("posts_id"),rs.getString("post_user"),
                        rs.getString("title"),rs.getString("content"),rs.getInt("type"),rs.getString("tag"),
                        rs.getInt("thumb_num"),rs.getInt("top_flag"),rs.getInt("boutique_flag"),rs.getString("post_date"),rs.getInt("reward"));
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
    public List<Posts> getPostsGetByTag(String tagName) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="SELECT * FROM posts WHERE tag=?";
        List<Posts> posts=new ArrayList<>();
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,tagName);
            rs=ps.executeQuery();
            while(rs.next())
            {
                Posts posts2=new Posts();
                posts2.setPostsId(rs.getInt("posts_id"));
                posts2.setPostUser(rs.getString("post_user"));
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
    public List<Posts> getAllTopPosts() {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="SELECT * FROM posts WHERE top_flag=1";
        List<Posts> posts=new ArrayList<>();
        try{
            ps=connection.prepareStatement(sqlStatement);
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
    public List<Posts> queryAllBoutiquePosts() {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="SELECT * FROM posts WHERE boutique_flag=1";
        List<Posts> posts=new ArrayList<>();
        try{
            ps=connection.prepareStatement(sqlStatement);
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
    public Integer addThumbNum(Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;
        String sqlStatement="UPDATE posts SET thumb_num=thumb_num+1 WHERE posts_id=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1, postsId);
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
    public Integer reduceThumbNum(Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;
        String sqlStatement="UPDATE posts SET thumb_num=thumb_num-1 WHERE posts_id=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1, postsId);
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
    public Integer deletePost(int postId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;
        String sqlStatement="DELETE FROM posts WHERE posts_id=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1,postId);
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
    public Integer markPost(Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;
        String sqlStatement="UPDATE posts SET boutique_flag=1 WHERE posts_id=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1, postsId);
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
    public Integer unMarkPost(Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;
        String sqlStatement="UPDATE posts SET boutique_flag=0 WHERE posts_id=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1, postsId);
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
    public Integer topPost(Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="UPDATE posts SET top_flag=1 WHERE posts_id=?";
        int affectedRow=0;
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1, postsId);
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
    public Integer unTopPost(Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="UPDATE posts SET top_flag=0 WHERE posts_id=?";
        int affectedRow=0;
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1, postsId);
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
    public Integer addOnePosts(Posts posts) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="INSERT INTO posts(title,content,type,tag,reward,post_user) values(?,?,?,?,?,?)";
        int affectedRow=0;
        try {
            ps=connection.prepareStatement(sqlStatement);
            ps.setObject(1, posts.getTitle());
            ps.setObject(2, posts.getContent());
            ps.setObject(3, posts.getType());
            ps.setObject(4, posts.getTag());
            ps.setObject(5, posts.getReward());
            ps.setObject(6, posts.getPostUser());
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
}
