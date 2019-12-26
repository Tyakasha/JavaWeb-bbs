package akm;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Mkeng {

    public static final String URL_HOME = "/bbs";
	public static final String URL_USER = "/user.jsp";

	private HttpServletRequest request;
	private HttpServletResponse response;
	private PrintWriter out;
	private HttpSession session;

	public Mkeng(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.request = request;
		this.response = response;

		this.out = response.getWriter();
		this.session = request.getSession();
	}

	public boolean isLogin() throws ServletException, IOException {
		Integer i = (Integer)session.getAttribute("loginStatus");
		if (session.isNew() || i==null || i<=0)
			return false;
		return true;
	}

	public boolean isAdmin() throws ServletException, IOException {
		Integer i = (Integer)session.getAttribute("loginAdmin");
		if (session.isNew() || i==null || i<=0)
			return false;
		return true;
	}

	public void goTo(String location) throws ServletException, IOException {
    //    if ( location != Mkeng.URL_HOME )
    //        location = Mkeng.URL_HOME + location;
		response.sendRedirect(location);
	}

	public void forward(String location) throws ServletException, IOException {
		request.getRequestDispatcher(location)
			.forward(request, response);
	}

	public String[] getParameters(String[] paraNameArray) {
		return getParameters(paraNameArray, null);
	}

	public String[] getParameters(String[] paraNameArray, String NULL) {
		int len = paraNameArray.length;
		var paraArray = new String[len];
		for (int i=0; i<len; ++i) {
			paraArray[i] = request.getParameter(paraNameArray[i]);
			if ( paraArray[i] == null ) {
				if ( NULL == null )
					return null;
				paraArray[i] = NULL;
			}
		}
		return paraArray;
	}

}
