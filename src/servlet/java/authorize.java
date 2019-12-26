package akm;
//import ncu.ie.webdesign.dto.*;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class authorize extends HttpServlet {

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		String loginAcc = req.getParameter("loginAcc");

		//不正常访问
		if ( loginAcc==null ) {
			return;
		}

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{
			// 设置用户为管理员
			PreparedStatement stmt = conn.prepareStatement(
"UPDATE account SET acc_type=1 WHERE login_acc=?"
			);
			stmt.setString(1, loginAcc);
			int r = stmt.executeUpdate();
			if ( r == 0 ) { // 失败, 没有这个用户
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


