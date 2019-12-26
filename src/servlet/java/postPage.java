package akm;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class postPage extends HttpServlet {

	public void doGet(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		String type = req.getParameter("type");

		//不正常访问
		if ( type==null ) {
			return;
		}

		req.setAttribute("type", type);
		req.getRequestDispatcher("/post.jsp").forward(req, resp);
	
	}

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		doGet(req, resp);
	}
}


