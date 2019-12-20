package ncu.ie.webdesign.servlet.adminservlet;

import ncu.ie.webdesign.service.UserService;
import ncu.ie.webdesign.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by Wan HaoDong
 * @date 2019-12-18    10:56
 **/
@WebServlet(urlPatterns = "/bbs/userManage")
public class UserManagePageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        req.setAttribute("userManagePageDTO", userService.getAllUserManageDTO());
        req.getRequestDispatcher("/usermanage.jsp").forward(req,resp);
    }
}
