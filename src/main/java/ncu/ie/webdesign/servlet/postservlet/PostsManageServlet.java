package ncu.ie.webdesign.servlet.postservlet;

import ncu.ie.webdesign.entity.Posts;
import ncu.ie.webdesign.service.PostsService;
import ncu.ie.webdesign.service.impl.PostsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author by Wan HaoDong
 * @date 2019-12-18    14:59
 **/
@WebServlet(urlPatterns = "/bbs/postsManage")
public class PostsManageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostsService postsService=new PostsServiceImpl();
        List<Posts> allPostsInfo=postsService.getAllPosts();
        req.setAttribute("postsManagePageDTO",allPostsInfo);
        req.getRequestDispatcher("/postsmanage.jsp").forward(req, resp);
    }
}
