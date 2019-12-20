package ncu.ie.webdesign.servlet.postservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.service.PostsService;
import ncu.ie.webdesign.service.impl.PostsServiceImpl;
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
 * @date 2019-12-20    09:32
 **/
@WebServlet(urlPatterns = "/bbs/user/beenThumbedPosts")
public class GetMyThumbPostsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostsService postsService=new PostsServiceImpl();
        HttpSession session=req.getSession();
        String userName= (String) session.getAttribute("userName");
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        ajaxCallBack.setCallbackData(postsService.getUserThumbPosts(userName));
        JSONObject callback=new JSONObject(ajaxCallBack);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(callback);
    }
}
