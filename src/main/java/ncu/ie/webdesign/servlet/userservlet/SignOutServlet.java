package ncu.ie.webdesign.servlet.userservlet;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author by Wan HaoDong
 * @date 2019-12-13  21:34
 * @description 用户登出Servlet
 **/
@WebServlet(urlPatterns = "/bbs/signOut")
public class SignOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        /*销毁用户的session信息*/
        session.invalidate();
        JSONObject callback=new JSONObject();
        resp.getWriter().print(callback);
    }
}
