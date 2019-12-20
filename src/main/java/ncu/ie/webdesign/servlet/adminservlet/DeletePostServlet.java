package ncu.ie.webdesign.servlet.adminservlet;

import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.service.AdminService;
import ncu.ie.webdesign.service.impl.AdminServiceImpl;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/bbs/admin/deletePost")
public class DeletePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //初始化服务类
        AdminService adminService=new AdminServiceImpl();


        //获取前端数据
        int postId=Integer.parseInt(req.getParameter("postId"));

        AjaxCallBack ajaxCallBack = new AjaxCallBack();
        ajaxCallBack.setSuccessFlag(adminService.deletePostById(postId));
        JSONObject callback=new JSONObject(ajaxCallBack);
        resp.getWriter().print(callback);
    }
}
