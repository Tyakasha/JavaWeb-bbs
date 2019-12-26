package akm;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class Test extends HttpServlet {

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{

	}

	public void doGet(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		doPost(req, resp);
	}

}


