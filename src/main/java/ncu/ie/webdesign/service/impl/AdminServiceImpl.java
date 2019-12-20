package ncu.ie.webdesign.service.impl;

import ncu.ie.webdesign.dao.impl.AccountDAOImpl;
import ncu.ie.webdesign.dao.impl.PostsDAOImpl;
import ncu.ie.webdesign.dao.impl.ReplyDAOImpl;
import ncu.ie.webdesign.dao.impl.ThumbDAOImpl;
import ncu.ie.webdesign.service.AdminService;

public class AdminServiceImpl implements AdminService {
    @Override
    public Boolean deletePostById(int postId) {
        PostsDAOImpl postsDAO=new PostsDAOImpl();
        return  postsDAO.deletePost(postId)==1;
    }

    @Override
    public Boolean markPostCheck(int postId) {
        PostsDAOImpl postsDAO=new PostsDAOImpl();
        int flag=postsDAO.markPost(postId);
        if(flag==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Boolean topPostCheck(int postId) {
        PostsDAOImpl postsDAO=new PostsDAOImpl();

        int flag=postsDAO.topPost(postId);
        if(flag==1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public Boolean authorizeCheck(String loginAcc) {
        AccountDAOImpl accountDAO=new AccountDAOImpl();
        int flag=accountDAO.authorize(loginAcc);
        return flag == 1;
    }


}
