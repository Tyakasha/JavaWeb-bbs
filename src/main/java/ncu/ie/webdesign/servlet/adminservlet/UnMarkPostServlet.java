package ncu.ie.webdesign.servlet.adminservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.service.PostsService;
import ncu.ie.webdesign.service.impl.PostsServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by Wan HaoDong
 * @date 2019-12-20    01:59
 **/
@WebServlet(urlPatterns = "/bbs/admin/unMarkPost")
public class UnMarkPostServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostsService postsService=new PostsServiceImpl();
        Integer postsId=Integer.valueOf(req.getParameter("postsId"));
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        ajaxCallBack.setSuccessFlag(postsService.unMarkPost(postsId));
        JSONObject callback=new JSONObject(ajaxCallBack);
        resp.getWriter().print(callback);
    }
}
