package ncu.ie.webdesign.servlet.userservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.entity.Posts;
import ncu.ie.webdesign.service.ThumbService;
import ncu.ie.webdesign.service.UserService;
import ncu.ie.webdesign.service.impl.ThumbServiceImpl;
import ncu.ie.webdesign.service.impl.UserServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//点赞帖子
@WebServlet(urlPatterns = "/bbs/user/thumb")
public class ThumbServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*初始化点赞服务类*/
        ThumbService thumbService=new ThumbServiceImpl();

        /*获取前端数据*/
        HttpSession session = req.getSession();

        Integer postId =Integer.parseInt(req.getParameter("postsId"));
        String userName=(String)session.getAttribute("userName");
        AjaxCallBack ajaxCallBack = new AjaxCallBack();
        ajaxCallBack.setSuccessFlag(thumbService.ThumbPosts(userName, postId));
        JSONObject callback=new JSONObject(ajaxCallBack);
        resp.getWriter().print(callback);
    }
}
