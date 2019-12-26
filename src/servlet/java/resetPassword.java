package akm;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class resetPassword extends HttpServlet {

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");

		//不正常访问
		if ( userName==null || email==null )
			return;

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{
			// 验证userName email
			PreparedStatement stmt = conn.prepareStatement(
"SELECT user_name FROM user_info WHERE user_name=? AND email=?"
			);
			stmt.setString(1, userName);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() )
				return "true";
			else
				return null;
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


