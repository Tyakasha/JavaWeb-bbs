package akm;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

//   /bbs
public class userInfoPage extends HttpServlet {

// Get
	public void doGet(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		// 获取原用户名
		String userName = req.getParameter("username");

		// 没有参数
		if ( userName==null )
			return;

		UserInfoPageDTO userInfoPageDTO = new UserInfoPageDTO();
		List<PostsDTO> myPostsDTO = new ArrayList<PostsDTO>();

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{
			//查询用户名
			PreparedStatement stmt = conn.prepareStatement(
"SELECT acc_type,points,register_date FROM account WHERE login_acc=?"
			);
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();
			if ( ! rs.next() ) {
				// 用户不存在
				return null;
			}
			userInfoPageDTO.setUserName(userName);
			userInfoPageDTO.setAccType(rs.getInt("acc_type"));
			userInfoPageDTO.setPoints(rs.getInt("points"));
			userInfoPageDTO.setRegisterDate(rs.getString("register_date"));

			stmt = conn.prepareStatement(
"SELECT email,job_category,phone_num FROM user_info WHERE user_name=?"
			);
			stmt.setString(1, userName);
			rs = stmt.executeQuery();
			rs.next();
			userInfoPageDTO.setEmail(rs.getString("email"));
			userInfoPageDTO.setJobCategroy(rs.getString("job_category"));
			userInfoPageDTO.setPhoneNum(rs.getString("phone_num"));

			stmt = conn.prepareStatement(
"SELECT posts_id,title,content,thumb_num,post_date FROM posts WHERE post_user=?"
			);
			stmt.setString(1, userName);
			rs = stmt.executeQuery();
			while ( rs.next() ) {
				myPostsDTO.add(new PostsDTO(rs.getInt("posts_id"), rs.getString("title"),
					rs.getString("content"), rs.getInt("thumb_num"),
					userName, rs.getString("post_date") ) );
			}
			return "true";
		});

		if (result == null) {
			// 失败
			resp.sendRedirect(req.getContextPath()+"/bbs");
			return;
		}

		// 成功
		// 统计点赞数:
		int thumb_num = 0;
		for (PostsDTO dto : myPostsDTO) {
			thumb_num += dto.getThumbNum();
		}
		userInfoPageDTO.setUserThumbNum(thumb_num);

		req.setAttribute("userInfoPageDTO", userInfoPageDTO);
		req.setAttribute("myPostsDTO", myPostsDTO);
		req.getRequestDispatcher("/userinfo.jsp").forward(req, resp);

	}

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		doGet(req, resp);
	}

}


