package ncu.ie.webdesign.servlet.postservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.dto.PostsDTO;
import ncu.ie.webdesign.service.PostsService;
import ncu.ie.webdesign.service.impl.PostsServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/bbs/posts/allTopPosts")
public class GetAllTopPostsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostsService postsService=new PostsServiceImpl();

        //无需要获取的前端数据

        List<PostsDTO> allTopPosts=new ArrayList<>();
        allTopPosts=postsService.getAllTopPosts();

        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        JSONObject callback = null;
        //        if(ResetService.resetJobCategoryCheck(userName,newJobCategory)){
//            ajaxCallBack.setSuccessFlag(true);
//        }else{
//            ajaxCallBack.setSuccessFlag(false);
//        }
//        callback=new JSONObject(ajaxCallBack);
       resp.getWriter().print(callback);
       ajaxCallBack.setCallbackData( allTopPosts );

    }
}
