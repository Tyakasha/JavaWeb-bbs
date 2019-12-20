package ncu.ie.webdesign.servlet.postservlet;

import ncu.ie.webdesign.dto.PostsDTO;
import ncu.ie.webdesign.dto.UserAccInfoDTO;
import ncu.ie.webdesign.entity.ReplyInfo;
import ncu.ie.webdesign.service.PostsService;
import ncu.ie.webdesign.service.impl.PostsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author by Wan HaoDong
 * @date 2019-12-18    00:11
 **/
@WebServlet(urlPatterns = "/bbs/postDetail")
public class PostDetailServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostsService postsService=new PostsServiceImpl();
        Integer postId=Integer.valueOf(req.getParameter("postId"));
        HttpSession session=req.getSession();
        String userName= (String) session.getAttribute("userName");
        PostsDTO postsDTO=postsService.getDetailPostsById(userName,postId);
        System.out.println(postsDTO.getUserThumbFlag());
        req.setAttribute("postsDTO", postsDTO);
        req.getRequestDispatcher("/postdetail.jsp").forward(req,resp);
    }
}
