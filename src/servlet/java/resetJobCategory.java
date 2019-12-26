package akm;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class resetJobCategory extends HttpServlet {

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		HttpSession session = req.getSession();

		String newJobCategory = req.getParameter("newJobCategory");

		// 获取原用户名
		String userName = (String)session.getAttribute("userName"/*TODO*/);
		
		// 未登录 或 session已过期
		if ( userName==null )
			return;

		//不正常访问
		if ( newJobCategory==null )
			return;

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{
			// 修改信息
			PreparedStatement stmt = conn.prepareStatement(
"UPDATE user_info SET job_category=? where user_name=?"
			);
			stmt.setString(1, newJobCategory);
			stmt.setString(2, userName);
			int r = stmt.executeUpdate();
			if ( r == 0 ) // 修改失败
				return null;
			// 修改成功
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


