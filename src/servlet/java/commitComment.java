package akm;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class commitComment extends HttpServlet {

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		HttpSession session = req.getSession();

		String postId = req.getParameter("postId");
		String commentData = req.getParameter("commentData");


		// 获取原用户名
		String userName = (String)session.getAttribute("userName");
//		String userName = "test";

		// 未登录 或 session已过期
		if ( userName==null )
			return;

		//不正常访问
		if ( postId==null || commentData==null ) {
			return;
		}

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{
			// 修改信息
			PreparedStatement stmt = conn.prepareStatement(
"INSERT INTO reply_info VALUES(0, ?, ?, ?, 0, CURRENT_TIMESTAMP(0))"
			);
			stmt.setString(1, postId);
			stmt.setString(2, commentData);
			stmt.setString(3, userName);
			int r = stmt.executeUpdate();

			if ( r == 0 ) { // 失败
				return null;
			}
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


