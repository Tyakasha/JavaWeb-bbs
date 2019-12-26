package akm;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class resetUserName extends HttpServlet {

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		HttpSession session = req.getSession();

		String newUserName = req.getParameter("newUserName");

		// 获取原用户名
// /*
		String userName = (String)session.getAttribute("userName");
// */
 /*
		String userName = req.getParameter("userName");
// */
		
		// 未登录 或 session已过期
		if ( userName==null )
			return;

		//不正常访问
		if ( newUserName==null )
			return;

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{
			// 验证userName email
			PreparedStatement stmt = conn.prepareStatement(
"UPDATE account SET login_acc=? where login_acc=?"
			);
			stmt.setString(1, newUserName);
			stmt.setString(2, userName);
			int r = 0;
			try {
				r = stmt.executeUpdate();
			} catch (Exception e) { 
				// 主键冲突异常，修改失败，用户名重复了
				// ...
			}
			if ( r == 0 ) // 修改失败
				return null;

			// 修改成功, 同时更新所有表中该用户的用户名
			stmt = conn.prepareStatement(
"UPDATE posts SET post_user=? WHERE post_user=?"
			);
			stmt.setString(1, newUserName);
			stmt.setString(2, userName);
			stmt.executeUpdate();

			stmt = conn.prepareStatement(
"UPDATE reply_info SET reply_user=? WHERE reply_user=?"
			);
			stmt.setString(1, newUserName);
			stmt.setString(2, userName);
			stmt.executeUpdate();

			stmt = conn.prepareStatement(
"UPDATE thumb_info SET thumb_user=? WHERE thumb_user=?"
			);
			stmt.setString(1, newUserName);
			stmt.setString(2, userName);
			stmt.executeUpdate();

			stmt = conn.prepareStatement(
"UPDATE user_info SET user_name=? WHERE user_name=?"
			);
			stmt.setString(1, newUserName);
			stmt.setString(2, userName);
			stmt.executeUpdate();

			return "true";
		});

		AjaxCallBack ajaxCallBack = new AjaxCallBack();
		if ( result != null ) {
			// 成功
			ajaxCallBack.setSuccessFlag(true);
		} else {
			// 失败
			// 新用户名和其他用户用户名重复
			ajaxCallBack.setSuccessFlag(false);
		}

 /*	 TODO:
		JSONObject callback = new JSONObject(ajaxCallBack);;
		resp.getWriter().print(callback);
// */
	
	}

}


