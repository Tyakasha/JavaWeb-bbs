package ncu.ie.webdesign.servlet.postservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by Wan HaoDong
 * @date 2019-12-18    14:59
 **/
@WebServlet(urlPatterns = "/bbs/postsManage")
public class PostsManageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * 封装信息并跳转
        * 直接用Post类型的List，不需要建新类
        * */
        req.setAttribute("postsManagePageDTO",null);
        req.getRequestDispatcher("/postsmanage.jsp").forward(req, resp);
    }
}
