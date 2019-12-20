package ncu.ie.webdesign.service.impl;

import ncu.ie.webdesign.dao.PostsDAO;
import ncu.ie.webdesign.dao.ThumbDAO;
import ncu.ie.webdesign.dao.impl.PostsDAOImpl;
import ncu.ie.webdesign.dao.impl.ThumbDAOImpl;
import ncu.ie.webdesign.service.ThumbService;

public class ThumbServiceImpl implements ThumbService {
    @Override
    public Boolean ThumbCheck(String userName, Integer postsId) {
        ThumbDAO thumbDAO=new ThumbDAOImpl();
        return thumbDAO.queryByPostsIdAndUserName(userName, postsId)==null;
    }

    @Override
    public Boolean ThumbPosts(String userName, Integer postsId) {
        ThumbDAO thumbDAO=new ThumbDAOImpl();
        PostsDAO postsDAO=new PostsDAOImpl();
        return thumbDAO.addThumbInfo(userName, postsId)==1&&postsDAO.addThumbNum(postsId)==1;
    }

    @Override
    public Boolean cancelThumb(String userName, Integer postsId) {
        ThumbDAO thumbDAO=new ThumbDAOImpl();
        PostsDAO postsDAO=new PostsDAOImpl();
        return thumbDAO.deleteThumbInfoByUserNameAndPostId(userName, postsId)==1&&postsDAO.reduceThumbNum(postsId)==1;
    }
}
