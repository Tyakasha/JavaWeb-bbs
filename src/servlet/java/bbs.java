package akm;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

//   /bbs
public class bbs extends HttpServlet {

	public void doPost(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		List<PostsDTO> allPostsDTO = new ArrayList<PostsDTO>();
		List<PostsDTO> firstPageDTO = new ArrayList<PostsDTO>();
		List<PostsDTO> topPostsDTO = new ArrayList<PostsDTO>();

		Mydbc mdb = new Mydbc();
		mdb.query((conn)->{
			//选出所有帖子数据
			PreparedStatement stmt = conn.prepareStatement(
"SELECT * FROM posts ORDER BY post_date DESC"
			);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PostsDTO post = new PostsDTO(rs.getInt("posts_id"), rs.getString("title"),
					rs.getString("content"), rs.getInt("thumb_num"),
					rs.getString("post_user"), rs.getString("post_date") );
				allPostsDTO.add( post );
				if ( rs.getInt("top_flag")==1 )
					topPostsDTO.add( post );
			}
			return "";
		});

		// firstPage最多是前10个
		if ( allPostsDTO.size() < 10 )
			firstPageDTO = allPostsDTO;
		else {
			for (int i=0; i<10; ++i)
				firstPageDTO.add( allPostsDTO.get(i) );
		}

		// 如果获取到的数据为空即list大小为0，那么设置该数据为null
		// 用session保存传递信息
		req.setAttribute("allPostsDTO", allPostsDTO.size()!=0 ? allPostsDTO : null);
		req.setAttribute("topPostsDTO", topPostsDTO.size()!=0 ? topPostsDTO : null);
		req.setAttribute("firstPageDTO", firstPageDTO.size()!=0 ? firstPageDTO : null);

		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	public void doGet(HttpServletRequest req,
			HttpServletResponse resp)
		throws IOException, ServletException
	{
		doPost(req, resp);
	}

}


