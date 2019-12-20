package ncu.ie.webdesign.dao.impl;

import ncu.ie.webdesign.dao.ThumbDAO;
import ncu.ie.webdesign.entity.ThumbInfo;
import ncu.ie.webdesign.util.JdbcConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ThumbDAOImpl implements ThumbDAO {

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

        String sqlStatement="update thumb_info SET thumb_user=? where thumb_user=?";
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
    public Integer addThumbInfo(String userName, int postId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;

        String sqlStatement="INSERT INTO thumb_info values(?, ?)";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1,postId);
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
    public Integer deletePostThumbInfo(Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;
        String sqlStatement="DELETE FROM thumb_info WHERE postid=?";
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
    public Integer deleteThumbInfoByUserNameAndPostId(String userName, Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;
        String sqlStatement="DELETE FROM thumb_info WHERE posts_id=? and thumb_user=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1, postsId);
            ps.setString(2, userName);
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
    public ThumbInfo queryByPostsIdAndUserName(String userName, Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        ThumbInfo thumbInfo=null;
        /*初始化sql语句*/
        String sqlStatement="SELECT  * FROM thumb_info WHERE thumb_user=? and posts_id=?";
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setString(1,userName);
            ps.setInt(2,postsId);
            rs = ps.executeQuery();
            while (rs.next()){
               thumbInfo=new ThumbInfo(rs.getInt("posts_id"),rs.getString("thumb_user"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                JdbcConnection.relase(connection,ps,rs);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return thumbInfo;
    }

    @Override
    public List<ThumbInfo> queryAllThumbInfoByPostsId(Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="SELECT  * FROM thumb_info WHERE posts_id=?";
        List<ThumbInfo>thumbInfos=new ArrayList<>();
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1,postsId);
            rs = ps.executeQuery();
            while (rs.next()){
               thumbInfos.add(new ThumbInfo(rs.getInt("posts_id"),rs.getString("thumb_user")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                JdbcConnection.relase(connection,ps,rs);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return thumbInfos;
    }


}
