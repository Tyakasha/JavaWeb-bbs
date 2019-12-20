package ncu.ie.webdesign.servlet.userservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.service.ResetService;
import ncu.ie.webdesign.service.impl.ResetServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/bbs/resetPassword")
public class ResetPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String email = req.getParameter("email");
        String password=req.getParameter("newPassword");
        ResetService ResetService = new ResetServiceImpl();


        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        JSONObject callback;
        if(ResetService.resetPasswordCheck(userName,email,password)){
            ajaxCallBack.setSuccessFlag(true);
        }else{
            ajaxCallBack.setSuccessFlag(false);
        }
        callback=new JSONObject(ajaxCallBack);
        resp.getWriter().print(callback);
    }

}