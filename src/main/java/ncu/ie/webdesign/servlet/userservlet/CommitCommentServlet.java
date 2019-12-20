package ncu.ie.webdesign.servlet.userservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.service.PostsService;
import ncu.ie.webdesign.service.ResetService;
import ncu.ie.webdesign.service.impl.PostsServiceImpl;
import ncu.ie.webdesign.service.impl.ResetServiceImpl;
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
 * @date 2019-12-20    02:34
 **/
@WebServlet(urlPatterns = "/bbs/user/commitComment")
public class CommitCommentServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostsService postsService=new PostsServiceImpl();
        Integer postsId=Integer.valueOf(req.getParameter("postsId"));
        String replyContent=req.getParameter("commentData");
        HttpSession session=req.getSession();
        String userName= (String) session.getAttribute("userName");
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        ajaxCallBack.setSuccessFlag(postsService.commitComment(postsId, replyContent, userName));
        JSONObject callback=new JSONObject(ajaxCallBack);
        resp.getWriter().print(callback);
    }
}
