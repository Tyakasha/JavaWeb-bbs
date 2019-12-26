package akm;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

//   /bbs
public class userManage extends HttpServlet {

// Get
	public void doGet(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		List<UserAccInfoDTO> userManagePageDTO = new ArrayList<UserAccInfoDTO>();

		Mydbc mdb = new Mydbc();
		String result = mdb.query((conn)->{
			//查询所有用户数据
			PreparedStatement stmt = conn.prepareStatement(
"SELECT password,acc_type,points,register_date,user_name,email,job_category,phone_num FROM account,user_info WHERE login_acc=email"
			);
			ResultSet rs = stmt.executeQuery();
			while ( rs.next() ) {
				userManagePageDTO.add(new UserAccInfoDTO( rs.getString("user_name"), rs.getString("email"),
					rs.getString("job_category"), rs.getString("phone_num"), rs.getString("password"),
					rs.getInt("acc_type"), rs.getInt("points"), rs.getString("register_date") ) );
			}
			return "true";
		});

		req.setAttribute("userManagePageDTO", userManagePageDTO);
		req.getRequestDispatcher("/usermanage.jsp").forward(req,resp);

	}

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		doGet(req, resp);
	}

}


