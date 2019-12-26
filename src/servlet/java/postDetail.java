package akm;

import java.text.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

//   /bbs
public class postDetail extends HttpServlet {

// Get
	public void doGet(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		String postId = req.getParameter("postId");

		//不正常访问
		if ( postId==null ) {
			return;
		}

		PostsDTO detailPostsDTO = new PostsDTO();
		List<ReplyInfo> postsComments = new ArrayList<ReplyInfo>();

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{
			//查询所有用户数据
			PreparedStatement stmt = conn.prepareStatement(
"SELECT posts_id,title,content,thumb_num,post_user,post_date FROM posts WHERE posts_id=?"
			);
			stmt.setString(1, postId);
			ResultSet rs = stmt.executeQuery();
			detailPostsDTO.setPostId(777);
			// 未找到帖子
			if ( ! rs.next() )
				return null;
			// 找到了
			detailPostsDTO.setPostId(rs.getInt("posts_id"));
			detailPostsDTO.setTitle(rs.getString("title"));
			detailPostsDTO.setContent(rs.getString("content"));
			detailPostsDTO.setThumbNum(rs.getInt("thumb_num"));
			detailPostsDTO.setPostUser(rs.getString("post_user"));
			detailPostsDTO.setPostDate(rs.getString("post_date"));

			stmt = conn.prepareStatement(
"SELECT * FROM reply_info WHERE post_id=?"
			);
			stmt.setString(1, postId);
			rs = stmt.executeQuery();

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			while ( rs.next() ) {
				java.util.Date date = dateFormat.parse(rs.getString("reply_date"));
				postsComments.add( new ReplyInfo(rs.getInt("reply_id"), rs.getInt("post_id"),
					rs.getString("reply_content"), rs.getString("reply_user"),
					rs.getInt("reply_adopt_flag"), date ) );
			}
			return "true";
		});

		req.setAttribute("detailPostsDTO", detailPostsDTO);
		req.setAttribute("postsComments", postsComments);
		req.getRequestDispatcher("/postdetail.jsp").forward(req,resp);

	}

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		doGet(req, resp);
	}

}


