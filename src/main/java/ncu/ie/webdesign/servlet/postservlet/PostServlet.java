package ncu.ie.webdesign.servlet.postservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.dto.UserAccInfoDTO;
import ncu.ie.webdesign.entity.Posts;
import ncu.ie.webdesign.service.PostsService;
import ncu.ie.webdesign.service.UserService;
import ncu.ie.webdesign.service.impl.PostsServiceImpl;
import ncu.ie.webdesign.service.impl.UserServiceImpl;
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
 * @date 2019-12-19    17:50
 * @description 用户发帖
 **/
@WebServlet(urlPatterns = "/bbs/user/post")
public class PostServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*初始化用户服务类*/
        PostsService postsService = new PostsServiceImpl();
        //获取前端数据(type的值从哪里获取)
        HttpSession session=req.getSession();
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String tag = req.getParameter("tag");
        Integer type = Integer.parseInt(req.getParameter("type"));
        Integer reward = Integer.parseInt(req.getParameter("reward"));
        UserAccInfoDTO userAccInfoDTO = (UserAccInfoDTO) session.getAttribute("userAccInfoDTO");
        String userName=userAccInfoDTO.getUserName();
        Posts newPosts=new Posts(userName,title,content,type,tag,reward);
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        if (postsService.postNew(newPosts)){
            ajaxCallBack.setSuccessFlag(true);
        }else {
            ajaxCallBack.setSuccessFlag(false);
        }
        JSONObject callback=new JSONObject(ajaxCallBack);
        resp.getWriter().print(callback);
    }
}
