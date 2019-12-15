package ncu.ie.webdesign.servlet.userservlet;


import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.dto.UserAccInfoDTO;
import ncu.ie.webdesign.entity.Account;
import ncu.ie.webdesign.entity.UserInfo;
import ncu.ie.webdesign.service.UserService;
import ncu.ie.webdesign.service.impl.UserServiceImpl;
import org.json.JSONObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author by Wan HaoDong
 * @date 2019-12-12  09:34
 **/
@WebServlet(urlPatterns = "/bbs/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*初始化用户服务类*/
        UserService userService=new UserServiceImpl();
        /*初始化用户信息及账户信息数据传输对象*/
        UserAccInfoDTO userAccInfoDTO=null;

        /*
        * 获取前端数据
        * */
        String loginAcc=req.getParameter("loginAcc");
        String password=req.getParameter("password");

        /*
        * 登录校验
        * */
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        JSONObject callback;
        if(userService.loginCheck(loginAcc,password)){
            userAccInfoDTO=userService.getUserAccInfoDTOByLoginAcc(loginAcc);
            HttpSession session = req.getSession();
            session.setAttribute("userAccInfoDTO", userAccInfoDTO);
            ajaxCallBack.setSuccessFlag(true);
        }else{
            ajaxCallBack.setSuccessFlag(false);
        }
        callback=new JSONObject(ajaxCallBack);
        resp.getWriter().print(callback);
    }
}
