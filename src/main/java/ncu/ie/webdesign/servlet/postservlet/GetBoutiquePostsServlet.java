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

@WebServlet(urlPatterns = "/bbs/posts/boutiquePosts")
public class GetBoutiquePostsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //无前端数据

        PostsService postsService=new PostsServiceImpl();

        //无需要获取的前端数据

        List<PostsDTO> allBoutiquePosts;
        allBoutiquePosts=postsService.getAllBoutiquePosts();
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        ajaxCallBack.setCallbackData( allBoutiquePosts );
        JSONObject callback = new JSONObject(ajaxCallBack);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(callback);

    }
}
