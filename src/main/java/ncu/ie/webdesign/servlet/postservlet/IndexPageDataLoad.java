package ncu.ie.webdesign.servlet.postservlet;


import ncu.ie.webdesign.dto.AjaxCallBack;
import ncu.ie.webdesign.dto.FirstPageDTO;
import ncu.ie.webdesign.dto.PostsDTO;
import ncu.ie.webdesign.entity.Posts;
import ncu.ie.webdesign.service.PostsService;
import ncu.ie.webdesign.service.impl.PostsServiceImpl;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by Wan HaoDong
 * @date 2019-12-15    01:38
 **/
@WebServlet(urlPatterns ={"/bbs/load"})
public class IndexPageDataLoad  extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostsService postsService = new PostsServiceImpl();
        List<Posts> allPostsDTO=postsService.getAllPosts();
        List<PostsDTO> allTopPosts = postsService.getAllTopPosts();
        Map<String,Object>dataMap=new HashMap<>();
        dataMap.put("allPostsData", allPostsDTO);
        dataMap.put("topPostsData", allTopPosts);
        AjaxCallBack ajaxCallBack=new AjaxCallBack();
        ajaxCallBack.setCallbackData(dataMap);
        JSONObject callback=new JSONObject(ajaxCallBack);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().print(callback);
        //req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
