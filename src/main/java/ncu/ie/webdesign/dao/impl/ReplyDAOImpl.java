package ncu.ie.webdesign.dao.impl;

import ncu.ie.webdesign.dao.ReplyDAO;
import ncu.ie.webdesign.entity.Posts;
import ncu.ie.webdesign.entity.ReplyInfo;
import ncu.ie.webdesign.util.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReplyDAOImpl implements ReplyDAO {


    @Override
    public Integer deletePostReplyInfo(Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;
        String sqlStatement="DELETE FROM reply_info WHERE posts_id=?";
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
    public List<ReplyInfo> queryReplyInfoByPostsId(Integer postsId) {
        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/
        String sqlStatement="SELECT * FROM reply_info WHERE posts_id=?";
        List<ReplyInfo> replyInfos=new ArrayList<>();
        try{
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1,postsId);
            rs=ps.executeQuery();
            while(rs.next()) {
                ReplyInfo replyInfo=new ReplyInfo(rs.getInt("reply_id"),rs.getInt("posts_id"),rs.getString("reply_content"),
                        rs.getString("reply_user"),rs.getInt("reply_adopt_flag"),rs.getString("reply_date"));
                replyInfos.add(replyInfo);
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
        if(replyInfos.size()>0){
            return replyInfos;
        }else{
            return null;
        }
    }

    @Override
    public Integer addOneReplyInfo(Integer postsId,String replyContent,String replyUser) {

        /*初始化连接对象*/
        Connection connection = JdbcConnection.getConnection();
        /*初始化数据库执行对象*/
        PreparedStatement ps = null;
        /*初始化结果集接收对象*/
        ResultSet rs = null;
        /*初始化sql语句*/

        int affectedRow=0;
        String sqlStatement="INSERT INTO reply_info(posts_id,reply_content,reply_user) VALUES(?, ?, ?)";
        try {
            ps=connection.prepareStatement(sqlStatement);
            ps.setInt(1,postsId);
            ps.setString(2,replyContent);
            ps.setString(3,replyUser);
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
}
