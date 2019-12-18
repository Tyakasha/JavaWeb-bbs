package ncu.ie.webdesign.servlet.postservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by Wan HaoDong
 * @date 2019-12-18    00:11
 **/
@WebServlet(urlPatterns = "/bbs/postDetail")
public class PostDetailServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer postId=Integer.valueOf(req.getParameter("postId"));
        System.out.println(postId);
        req.getRequestDispatcher("/test.jsp").forward(req,resp);
    }
}
