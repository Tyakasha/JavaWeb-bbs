package akm;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class post extends HttpServlet {

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		HttpSession session = req.getSession();

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String tag = req.getParameter("tag");
		String type = req.getParameter("type");
		String reward = req.getParameter("reward");

		// 获取原用户名
		String userName = (String)session.getAttribute("userName");
		
		// 未登录 或 session已过期
		if ( userName==null )
			return;

		//不正常访问
		if ( title==null || content==null || tag==null || type==null )
			return;

		if ( type.charAt(0)=='1' && reward==null )
			return;

		int tmpInt = 0;
		if ( reward != null ) {
			try {
				tmpInt = Integer.parseInt(reward);
			} catch ( Exception e ) {
				// ...
			}
		}
		Integer intReward = tmpInt;

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{

			PreparedStatement stmt = null;
			if ( reward != null ) {
				// 积分查询
				stmt = conn.prepareStatement(
"SELECT points FROM account WHERE login_acc=?"
				);
				stmt.setString(1, userName);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				int points = rs.getInt("points");
				// 积分不够
				if ( points < intReward )
					return null;
				// 更新积分
				stmt = conn.prepareStatement(
"UPDATE account SET points=points-? WHERE login_acc=?"
				);
				stmt.setInt(1, intReward);
				stmt.setString(2, userName);
				stmt.executeUpdate();
			}

			// 插入post
			stmt = conn.prepareStatement(
"INSERT INTO posts(posts_id,post_user,title,content,type,tag,thumb_num,reward) values(0,?,?,?,?,?,0,?)"
			);
			stmt.setString(1, userName);
			stmt.setString(2, title);
			stmt.setString(3, content);
			stmt.setString(4, type);
			stmt.setString(5, tag);
			stmt.setString(6, reward==null ? "0" : reward);
			stmt.executeUpdate();

			return "true";
		});

		AjaxCallBack ajaxCallBack = new AjaxCallBack();
		if ( result != null ) {
			// 成功
			ajaxCallBack.setSuccessFlag(true);
		} else {
			// 失败
			// 是问答帖，积分不够
			ajaxCallBack.setSuccessFlag(false);
			ajaxCallBack.setCallbackData("pointsNotEnough");
		}

 /*	 TODO:
		JSONObject callback = new JSONObject(ajaxCallBack);;
		resp.getWriter().print(callback);
// */

	}

}


