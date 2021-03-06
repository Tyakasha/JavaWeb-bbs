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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/bbs/user/resetPhoneNum")
public class ResetPhoneNumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResetService ResetService = new ResetServiceImpl();

        //获取前端数据
        String newPhoneNum=req.getParameter("newPhoneNum");
        HttpSession session=req.getSession();
        String userName = (String) session.getAttribute("userName");

        /*
         * 重置校验
         * */
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        JSONObject callback;
        if(ResetService.resetPhoneNumCheck(newPhoneNum,userName)){
            ajaxCallBack.setSuccessFlag(true);
        }else{
            ajaxCallBack.setSuccessFlag(false);
        }
        callback=new JSONObject(ajaxCallBack);
        resp.getWriter().print(callback);
    }
}
