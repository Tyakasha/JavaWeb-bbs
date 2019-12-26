package akm;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class markPost extends HttpServlet {

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		String postId = req.getParameter("postId");

		//不正常访问
		if ( postId==null ) {
			return;
		}

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{
			// 置顶帖子
			PreparedStatement stmt = conn.prepareStatement(
"UPDATE posts SET boutique_flag=1 WHERE posts_id=?"
			);
			stmt.setString(1, postId);
			int r = stmt.executeUpdate();
			if ( r == 0 ) { // 失败, 没有这个帖子
				return null;
			}
			// 成功
			return "true";
		});

		AjaxCallBack ajaxCallBack = new AjaxCallBack();
		if ( result != null ) {
			// 成功
			ajaxCallBack.setSuccessFlag(true);
		} else {
			// 失败
			ajaxCallBack.setSuccessFlag(false);
		}

 /*	 TODO:
		JSONObject callback = new JSONObject(ajaxCallBack);;
		resp.getWriter().print(callback);
// */
	
	}

}


