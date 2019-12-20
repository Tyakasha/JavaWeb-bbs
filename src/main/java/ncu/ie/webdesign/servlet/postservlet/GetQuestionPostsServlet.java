package ncu.ie.webdesign.servlet.postservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.dto.PostsDTO;
import ncu.ie.webdesign.entity.Posts;
import ncu.ie.webdesign.service.PostsService;
import ncu.ie.webdesign.service.impl.PostsServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author by Wan HaoDong
 * @date 2019-12-20    04:25
 **/
@WebServlet(urlPatterns = "/bbs/posts/allQuestionPosts")
public class GetQuestionPostsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PostsService postsService=new PostsServiceImpl();
        List<Posts> allQuestionPosts=postsService.getAllQuestionPosts();
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        ajaxCallBack.setCallbackData( allQuestionPosts );
        JSONObject callback = new JSONObject(ajaxCallBack);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(callback);
    }
}
