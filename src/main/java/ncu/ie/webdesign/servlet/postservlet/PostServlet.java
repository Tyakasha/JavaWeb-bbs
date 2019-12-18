package ncu.ie.webdesign.servlet.postservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by Wan HaoDong
 * @date 2019-12-17    11:26
 **/
@WebServlet(urlPatterns = "/bbs/postPage")
public class PostServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type= req.getParameter("type");
        System.out.println(type);
        req.setAttribute("type", type);
        /*用绝对路径来跳转*/
        req.getRequestDispatcher("/post.jsp").forward(req, resp);
    }
}
