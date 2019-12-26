package akm;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class thumb extends HttpServlet {

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		HttpSession session = req.getSession();

		String postId = req.getParameter("postId");


		// 获取原用户名
		String userName = (String)session.getAttribute("userName");
//		String userName = "test";

		// 未登录 或 session已过期
		if ( userName==null )
			return;

		//不正常访问
		if ( postId==null ) {
			return;
		}

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{
			// 修改信息
			PreparedStatement stmt = conn.prepareStatement(
"INSERT INTO thumb_info values(?, ?)"
			);
			stmt.setString(1, postId);
			stmt.setString(2, userName);
			int r = 0;
			try {
				r = stmt.executeUpdate();
			} catch (Exception e) { 
				// 主键冲突异常，点赞失败，已经点过了
				// ...
			}
			if ( r == 0 ) { // 失败
				return null;
			}

			// 成功, 更新点赞数
			stmt = conn.prepareStatement(
"UPDATE posts SET thumb_num=thumb_num+1 WHERE posts_id=?"
			);
			stmt.setString(1, postId);
			stmt.executeUpdate();
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


