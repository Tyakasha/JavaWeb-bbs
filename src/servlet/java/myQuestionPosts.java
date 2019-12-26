package akm;
//import ncu.ie.webdesign.dto.PostsDTO;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class myQuestionPosts extends HttpServlet {

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		HttpSession session = req.getSession();

		List<PostsDTO> postList = new ArrayList<PostsDTO>();

		// 获取原用户名
		String userName = (String)session.getAttribute("userName");
//test:		String userName = "test";
		
		// 未登录 或 session已过期
		if ( userName==null )
			return;

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{

			PreparedStatement stmt = null;
			// 选出post
			stmt = conn.prepareStatement(
"SELECT * FROM posts WHERE post_user=? AND type=1"
			);
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				postList.add(new PostsDTO(rs.getInt("posts_id"), rs.getString("title"),
					rs.getString("content"), rs.getInt("thumb_num"),
					rs.getString("post_user"), rs.getString("post_date") ) );
			}

			return "true";
		});
/*
//for test
		var out = resp.getWriter();
		for (var x : postList)
			out.println("<h1>"+x.getPostId()+"</h1>");
*/

/*
		req.getWriter.print(callback);
		callback:
		{
			successFlag:null
			callbackData:List<PostsDTO>
		}
*/
// /*	TODO:
		AjaxCallBack ajaxCallBack = new AjaxCallBack();
		ajaxCallBack.setCallbackData( postList );
//		JSONObject callback = new JSONObject(ajaxCallBack);;
//		resp.getWriter().print(callback);
	
	}

}


