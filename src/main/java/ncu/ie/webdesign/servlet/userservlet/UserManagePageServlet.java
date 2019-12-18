package ncu.ie.webdesign.servlet.userservlet;

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
        /*
        * 获取所有的注册用户信息
        * 这里需要新建一个userManagePageDTO
        * 包含 rowNum，userName，loginAcc，registerDate
        *
        * */
        req.setAttribute("userManagePageDTO", null);
        req.getRequestDispatcher("/usermanage.jsp").forward(req,resp);
    }
}
