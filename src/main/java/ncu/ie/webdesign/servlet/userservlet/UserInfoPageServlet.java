package ncu.ie.webdesign.servlet.userservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by Wan HaoDong
 * @date 2019-12-18    00:58
 **/
@WebServlet(urlPatterns = "/bbs/userInfoPage")
public class UserInfoPageServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName=req.getParameter("userName");
        System.out.println(userName);
        req.setAttribute("userInfoPageDTO", null);
        req.setAttribute("myPostsDTO", null);
        /*
        * 如果没有对应的用户，由于没有写404，所以重新返回首页
        * */
        req.getRequestDispatcher("/userinfo.jsp").forward(req, resp);
    }
}
