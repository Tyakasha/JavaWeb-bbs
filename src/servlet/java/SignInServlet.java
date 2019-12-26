package ncu.ie.webdesign.servlet.userservlet;

import akm.Mydbc;//数据库操作类
/*
import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.dto.UserAccInfoDTO;
import ncu.ie.webdesign.entity.Account;
import ncu.ie.webdesign.entity.UserInfo;
import ncu.ie.webdesign.service.UserService;
import ncu.ie.webdesign.service.impl.UserServiceImpl;
import org.json.JSONObject;
*/
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

/**
 * @author by Wan HaoDong
 * @date 2019-12-12  09:34
 **/
@WebServlet(urlPatterns = "/bbs/signIn")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*初始化用户服务类*/
//        UserService userService=new UserServiceImpl();
        /*初始化用户信息及账户信息数据传输对象*/
//        UserAccInfoDTO userAccInfoDTO=null;

		HttpSession session = req.getSession();

        /*
        * 获取前端数据
        * */
        String loginAcc=req.getParameter("loginAcc");
        String password=req.getParameter("password");

		// 没有填信息, 直接访问此链接
		if (loginAcc == null || password == null)
			return;

		Mydbc mdb = new Mydbc();

		mdb.query((conn)->{
			var stmt = conn.prepareStatement(
"SELECT login_acc,acc_type FROM account WHERE login_acc=? AND password=?"
			);
			stmt.setString(1, loginAcc);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				// 登录成功
				session.setAttribute("loginAcc", loginAcc);
				session.setAttribute("accType", rs.getString("acc_type"));
			} else {
				// 登录失败
			}
			return "";
		});

        /*
        * 登录校验
        * */
/*
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
*/
    }
}
