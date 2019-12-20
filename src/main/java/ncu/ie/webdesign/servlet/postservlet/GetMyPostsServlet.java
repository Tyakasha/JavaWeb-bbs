package ncu.ie.webdesign.servlet.postservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.dto.PostsDTO;
import ncu.ie.webdesign.dto.UserAccInfoDTO;
import ncu.ie.webdesign.service.UserService;
import ncu.ie.webdesign.service.impl.UserServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns ="/bbs/user/myPosts" )
public class GetMyPostsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*初始化用户服务类*/
        UserService userService=new UserServiceImpl();

        //获取前端数据
        HttpSession session=req.getSession();
        String userName=(String)session.getAttribute("userName");
        List<PostsDTO> myPosts=userService.getMyPosts(userName);
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        ajaxCallBack.setCallbackData(myPosts);
        JSONObject callback=new JSONObject(ajaxCallBack);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(callback);
    }
}
