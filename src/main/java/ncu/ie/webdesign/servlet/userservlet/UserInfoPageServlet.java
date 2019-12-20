package ncu.ie.webdesign.servlet.userservlet;

import ncu.ie.webdesign.service.UserService;
import ncu.ie.webdesign.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by Wan HaoDong
 * @date 2019-12-18    00:58
 **/
@WebServlet(urlPatterns = "/bbs/userInfoPage")
public class UserInfoPageServlet  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String userName=req.getParameter("userName");
        if(userService.getUserInfoByUserName(userName)==null){
            /*
             * 如果没有对应的用户，由于没有写404，所以重新返回首页
             * */
            resp.sendRedirect(req.getContextPath());
        }else{
            req.setAttribute("userInfoPageDTO", userService.getUserInfoPageDTOByUserName(userName));
            req.setAttribute("myPostsDTO", userService.getMyPosts(userName));
            req.getRequestDispatcher("/userinfo.jsp").forward(req, resp);
        }

    }
}
