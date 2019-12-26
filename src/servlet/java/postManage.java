package akm;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

//    /bbs
public class postManage extends HttpServlet {

// Get
	public void doGet(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		List<PostsDTO> postsManagePageDTO = new ArrayList<PostsDTO>();

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{
			//查询所有用户数据
			PreparedStatement stmt = conn.prepareStatement(
"SELECT posts_id,title,content,thumb_num,post_user,post_date FROM posts"
			);
			ResultSet rs = stmt.executeQuery();
			while ( rs.next() ) {
				postsManagePageDTO.add( new PostsDTO(rs.getInt("posts_id"), rs.getString("title"),
					rs.getString("content"), rs.getInt("thumb_num"),
					rs.getString("post_user"), rs.getString("post_date") ) );
			}
			return "true";
		});

		req.setAttribute("postsManagePageDTO", postsManagePageDTO);
		req.getRequestDispatcher("/postsmanage.jsp").forward(req,resp);

	}

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		doGet(req, resp);
	}

}


