package ncu.ie.webdesign.service;


import ncu.ie.webdesign.dto.PostsDTO;
import ncu.ie.webdesign.entity.Posts;
import ncu.ie.webdesign.entity.ReplyInfo;

import java.util.List;

public interface PostsService {

    /**
     * 列举前十条帖子
     * @return 返回十条帖子的list
     */
    List<Posts> getAllPosts();

    /**
     * 根据帖子标签列出帖子
     * @param tagName 帖子标签
     * @return 返回结果
     */
    List<PostsDTO> getPostsByTag(String tagName);

    /**
     * 获取所有的置定帖
     * @return 返回结果
     */
    List<PostsDTO> getAllTopPosts();

    /**
     * 获得所有精品贴
     * @return 返回结果
     */
    List<PostsDTO> getAllBoutiquePosts();

    /**
     * 获取所有问答帖
     * @return  返回问答帖信息
     */
    List<Posts> getAllQuestionPosts();

    /**
     * 删除一条帖子
     * @param postId 删除的帖子ID
     * @return 返回删除结果
     */
    Integer deletePost(int postId);

    /**
     * 用户发布新帖
     * @param posts   帖子对象
     * @return  返回发布结果
     */
    Boolean postNew(Posts posts);

    /**
     * 通过帖子ID获取帖子详细信息
     * 用户名是用来查看用户对该帖子的点赞信息
     * @param postsId     帖子id
     * @param userName  用户名
     * @return      返回帖子信息
     */
    PostsDTO getDetailPostsById(String userName,Integer postsId);


    /**
     * 通过帖子Id获取帖子的全部评论信息
     * @param postsId       帖子Id
     * @return      返回帖子评论信息
     */
    List<ReplyInfo> getPostReplyInfosByIPostsId(Integer postsId);

    /**
     * 管理员给帖子加精
     * @param postsId   帖子id
     * @return  返回加精结果
     */
    Boolean markPost(Integer postsId);

    /**
     * 管理员取消帖子加精
     * @param postsId   帖子id
     * @return  返回帖子取消加精结果
     */
    Boolean unMarkPost(Integer postsId);

    /**
     * 管理员置顶帖子
     * @param postsId   帖子id
     * @return  返回帖子置顶结果
     */
    Boolean topPost(Integer postsId);

    /**
     * 管理员取消置顶帖子
     * @param postsId   帖子id
     * @return  返回取消结果
     */
    Boolean unTopPost(Integer postsId);

    /**
     * 用户提交评论
     * @param postsId          帖子id
     * @param replyContent  评论内容
     * @param replyUser     评论用户
     * @return  返回提交结果
     */
    Boolean commitComment(Integer postsId,String replyContent,String replyUser);

    /**
     * 获取用户被点赞的帖子
     * @param userName  用户名
     * @return  返回用户被点赞的帖子
     */
    List<PostsDTO> getUserThumbPosts(String userName);

}
