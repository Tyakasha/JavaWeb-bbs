package ncu.ie.webdesign.service.impl;

import ncu.ie.webdesign.dao.PostsDAO;
import ncu.ie.webdesign.dao.ReplyDAO;
import ncu.ie.webdesign.dao.impl.PostsDAOImpl;
import ncu.ie.webdesign.dao.impl.ReplyDAOImpl;
import ncu.ie.webdesign.dto.PostsDTO;
import ncu.ie.webdesign.entity.Posts;
import ncu.ie.webdesign.entity.ReplyInfo;
import ncu.ie.webdesign.service.PostsService;
import ncu.ie.webdesign.service.ThumbService;
import ncu.ie.webdesign.service.UserService;

import java.util.ArrayList;
import java.util.List;

public class PostsServiceImpl implements PostsService {


    @Override
    public List<Posts> getAllPosts() {
        PostsDAOImpl postsDAO=new PostsDAOImpl();
        List<Posts> allPosts=postsDAO.getAllPosts();
        /*for (int i = 0; i <allPosts.size() ; i++) {
            Posts posts=allPosts.get(i);
            String content="是自己写的代码diff模块可能某个地方出问题了";
            posts.setContent(content);
            allPosts.set(i, posts);
        }*/
        return allPosts;
    }

    @Override
    public List<PostsDTO> getPostsByTag(String tagName) {
        PostsDAOImpl postsDAO=new PostsDAOImpl();
        List<Posts> posts=new ArrayList<>();
        List<PostsDTO> postsByTag=new ArrayList<>();
        posts=postsDAO.getPostsGetByTag(tagName);
        for(int i=0;i<posts.size();i++) {
            PostsDTO postsByTag2=new PostsDTO();
            postsByTag2.setPostsId(posts.get(i).getPostsId());
            postsByTag2.setContent(posts.get(i).getContent());
            postsByTag2.setTitle(posts.get(i).getTitle());
            postsByTag2.setThumbNum(posts.get(i).getThumbNum());
            postsByTag2.setPostUser(posts.get(i).getPostUser());
            postsByTag2.setPostDate(posts.get(i).getPostDate());
            postsByTag2.setTopFlag(posts.get(i).getTopFlag());
            postsByTag.add(postsByTag2);
        }
        return postsByTag;
    }

    @Override
    public List<PostsDTO> getAllTopPosts() {
        PostsDAOImpl postsDAO=new PostsDAOImpl();
        List<Posts> posts=new ArrayList<>();
        List<PostsDTO> allTopPosts=new ArrayList<>();
        posts=postsDAO.getAllTopPosts();
        for(int i=0;i<posts.size();i++)
        {
            PostsDTO allTopPosts2=new PostsDTO();
            allTopPosts2.setPostsId(posts.get(i).getPostsId());
            allTopPosts2.setContent(posts.get(i).getContent());
            allTopPosts2.setTitle(posts.get(i).getTitle());
            allTopPosts2.setThumbNum(posts.get(i).getThumbNum());
            allTopPosts2.setPostUser(posts.get(i).getPostUser());
            allTopPosts2.setPostDate(posts.get(i).getPostDate());
            allTopPosts2.setTopFlag(posts.get(i).getTopFlag());
            allTopPosts.add(allTopPosts2);
        }
        return allTopPosts;
    }

    @Override
    public List<PostsDTO> getAllBoutiquePosts() {
        PostsDAOImpl postsDAO=new PostsDAOImpl();
        List<Posts> posts;
        List<PostsDTO> allBoutiquePosts=new ArrayList<>();
        posts=postsDAO.queryAllBoutiquePosts();
        for(int i=0;i<posts.size();i++)
        {
            PostsDTO allBoutiquePosts2=new PostsDTO();
            allBoutiquePosts2.setPostsId(posts.get(i).getPostsId());
            allBoutiquePosts2.setContent(posts.get(i).getContent());
            allBoutiquePosts2.setTitle(posts.get(i).getTitle());
            allBoutiquePosts2.setThumbNum(posts.get(i).getThumbNum());
            allBoutiquePosts2.setPostUser(posts.get(i).getPostUser());
            allBoutiquePosts2.setPostDate(posts.get(i).getPostDate());
            allBoutiquePosts2.setTopFlag(posts.get(i).getTopFlag());
            allBoutiquePosts.add(allBoutiquePosts2);
        }
        return allBoutiquePosts;
    }

    @Override
    public List<Posts> getAllQuestionPosts() {
        List<Posts>allPosts=getAllPosts();
        List<Posts>allQuestionPosts=new ArrayList<>();
        if(allPosts!=null) {
            for (Posts posts : allPosts) {
                if (posts.getType() == 1) {
                    allQuestionPosts.add(posts);
                }
            }
        }
        return allQuestionPosts;
    }

    @Override
    public Integer deletePost(int postId) {
        return null;
    }

    @Override
    public Boolean postNew(Posts posts) {
        PostsDAOImpl postsDAO=new PostsDAOImpl();
        return postsDAO.addOnePosts(posts)==1;
    }

    @Override
    public PostsDTO getDetailPostsById(String userName,Integer postsId) {
        PostsDAOImpl postsDAO=new PostsDAOImpl();
        ThumbService thumbService=new ThumbServiceImpl();
        Posts posts=postsDAO.queryPostsById(postsId);
        PostsDTO postsDTO=new PostsDTO();
        /*设置点赞标识*/
        if(userName==null){
            /*对于未登录用户直接设置零*/
            postsDTO.setUserThumbFlag(0);
        }else{
            postsDTO.setUserThumbFlag(thumbService.ThumbCheck(userName, postsId)?0:1 );
        }
        postsDTO.setContent(posts.getContent());
        postsDTO.setPostsId(postsId);
        postsDTO.setTitle(posts.getTitle());
        postsDTO.setThumbNum(posts.getThumbNum());
        postsDTO.setPostUser(posts.getPostUser());
        postsDTO.setPostDate(posts.getPostDate());
        postsDTO.setTopFlag(posts.getTopFlag());
        postsDTO.setBoutiqueFlag(posts.getBoutiqueFlag());
        return postsDTO;
    }

    @Override
    public List<ReplyInfo> getPostReplyInfosByIPostsId(Integer postsId) {
        ReplyDAO replyDAO=new ReplyDAOImpl();
        return replyDAO.queryReplyInfoByPostsId(postsId);
    }

    @Override
    public Boolean markPost(Integer postsId) {
        PostsDAO postsDAO=new PostsDAOImpl();
        return postsDAO.markPost(postsId)==1;
    }

    @Override
    public Boolean unMarkPost(Integer postsId) {
        PostsDAO postsDAO=new PostsDAOImpl();
        return postsDAO.unMarkPost(postsId)==1;
    }

    @Override
    public Boolean topPost(Integer postsId) {
        PostsDAO postsDAO=new PostsDAOImpl();
        return postsDAO.topPost(postsId)==1;
    }

    @Override
    public Boolean unTopPost(Integer postsId) {
        PostsDAO postsDAO=new PostsDAOImpl();
        return postsDAO.unTopPost(postsId)==1;
    }

    @Override
    public Boolean commitComment(Integer postsId, String replyContent, String replyUser) {
        ReplyDAO replyDAO=new ReplyDAOImpl();
        return replyDAO.addOneReplyInfo(postsId, replyContent, replyUser)==1;
    }

    @Override
    public List<PostsDTO> getUserThumbPosts(String userName) {
        UserService userService=new UserServiceImpl();
        List<PostsDTO> myPosts=userService.getMyPosts(userName);
        List<PostsDTO> myThumbPosts=new ArrayList<>();
        for (PostsDTO postsDTO:myPosts){
            if(postsDTO.getThumbNum()>0){
                myThumbPosts.add(postsDTO);
            }
        }
        return myThumbPosts;
    }

}
