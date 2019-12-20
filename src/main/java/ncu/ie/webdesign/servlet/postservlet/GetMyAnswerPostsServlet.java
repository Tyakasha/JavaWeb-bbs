package ncu.ie.webdesign.servlet.postservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by Wan HaoDong
 * @date 2019-12-20    09:55
 **/
@WebServlet(urlPatterns = "/bbs/user/myAnswerPosts")
public class GetMyAnswerPostsServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        ajaxCallBack.setCallbackData(null);
        JSONObject callback=new JSONObject(ajaxCallBack);
        resp.getWriter().print(callback);
    }
}
