package ncu.ie.webdesign.servlet.userservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.service.ThumbService;
import ncu.ie.webdesign.service.impl.ThumbServiceImpl;
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
 * @date 2019-12-20    00:20
 * @description 用户取消点赞
 **/
@WebServlet(urlPatterns = "/bbs/user/cancelThumb")
public class CancelThumbServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThumbService thumbService=new ThumbServiceImpl();
        HttpSession session=req.getSession();
        String userName= (String) session.getAttribute("userName");
        Integer postsId=Integer.valueOf(req.getParameter("postsId"));
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        ajaxCallBack.setSuccessFlag(thumbService.cancelThumb(userName, postsId));
        JSONObject callback=new JSONObject(ajaxCallBack);
        resp.getWriter().print(callback);
    }
}
