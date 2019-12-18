package ncu.ie.webdesign.servlet.postservlet;


import ncu.ie.webdesign.dto.PostsDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author by Wan HaoDong
 * @date 2019-12-15    01:38
 **/
@WebServlet(urlPatterns = "/bbs")
public class IndexPageDataLoad  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        * 测试数据
        * */
        ArrayList<PostsDTO> postDTOList1 =new ArrayList<>();
        ArrayList<PostsDTO> postDTOList2 =new ArrayList<>();
        ArrayList<PostsDTO> postDTOList3 =new ArrayList<>();
        ArrayList<PostsDTO> postDTOList4 =new ArrayList<>();
        ArrayList<PostsDTO> postDTOList5 =new ArrayList<>();
        ArrayList<Object> allPosts=new ArrayList<>();
        for (int j = 0; j <10 ; j++) {
            postDTOList1.add(new PostsDTO(j+1, "标题"+(j+1), UUID.randomUUID().toString(),100, "极客时间", "2019-12-15 00:25"));
            postDTOList2.add(new PostsDTO(j+1, "标题"+(j+1), UUID.randomUUID().toString(),100, "极客时间", "2019-12-15 00:25"));
            postDTOList3.add(new PostsDTO(j+1, "标题"+(j+1), UUID.randomUUID().toString(),100, "极客时间", "2019-12-15 00:25"));
            postDTOList4.add(new PostsDTO(j+1, "标题"+(j+1), UUID.randomUUID().toString(),100, "极客时间", "2019-12-15 00:25"));
            postDTOList5.add(new PostsDTO(j+1, "标题"+(j+1), UUID.randomUUID().toString(),100, "极客时间", "2019-12-15 00:25"));
        }
        allPosts.add(postDTOList1);
        allPosts.add(postDTOList2);
        allPosts.add(postDTOList3);
        allPosts.add(postDTOList4);
        allPosts.add(postDTOList5);
        req.setAttribute("allPostsDTO", postDTOList1);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
