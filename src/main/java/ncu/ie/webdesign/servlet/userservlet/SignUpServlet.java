package ncu.ie.webdesign.servlet.userservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.dto.UserAccInfoDTO;
import ncu.ie.webdesign.service.UserService;
import ncu.ie.webdesign.service.impl.UserServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author by Wan HaoDong
 * @date 2019-12-14  14:34
 * @description 用户注册Servlet
 **/
@WebServlet(urlPatterns = "/bbs/signUp")
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*初始化用户服务类*/
        UserService userService=new UserServiceImpl();
        /*初始化用户信息数据传输对象，用于接收和封装前端传入的数据*/
        UserAccInfoDTO userAccInfoDTO=new UserAccInfoDTO();
        /*
        * 接收前端数据
        * */
        userAccInfoDTO.setUserName(req.getParameter("userName"));
        userAccInfoDTO.setPhoneNum(req.getParameter("phoneNum"));
        userAccInfoDTO.setJobCategory(req.getParameter("jobCategory"));
        userAccInfoDTO.setEmail(req.getParameter("email"));
        userAccInfoDTO.setPassword(req.getParameter("password"));
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        ajaxCallBack.setSuccessFlag(true);
        ajaxCallBack.setCallbackData(userService.userRegister(userAccInfoDTO));
        JSONObject callback=new JSONObject(ajaxCallBack);
        resp.getWriter().print(callback);
    }
}
