package ncu.ie.webdesign.dao;

import ncu.ie.webdesign.entity.Posts;

import java.util.List;

public interface PostsDAO {
    /**
     * 重置用户名
     * @param userName  旧用户名
     * @param newUserName   新用户名
     * @return  返回重置结果
     */
    Integer resetUserName(String userName, String newUserName);

    /**
     * 列举所有的帖子
     * @return 返回posts列表
     */
    List<Posts> getAllPosts();

    /**
     * 根据帖子Id查询帖子信息
     * @param postsId           帖子Id
     * @return      返回帖子信息
     */
    Posts queryPostsById(Integer postsId);

    /**
     * 根据标签获取帖子内容
     * @param tagName 标签名
     * @return  返回标签对应的帖子
     */
    List<Posts> getPostsGetByTag(String tagName);

    /**
     * 获取所有置顶标签
     * @return 返回所有的置定标签（List）
     */
    List<Posts> getAllTopPosts();

    /**
     * 获取所有的精品帖数据
     * @return 返货所有的精品贴
     */
    List<Posts> queryAllBoutiquePosts();

    /**
     * 增加帖子点赞数
     * @param postsId    帖子id
     * @return  返回增加结果
     */
    Integer addThumbNum(Integer postsId);

    /*
    * 减少帖子点赞数
    * */
    Integer reduceThumbNum(Integer postsId);


    /**
     * 删除帖子
     * @param postId    删除帖子id
     * @return  返回删除结果
     */
    Integer deletePost(int postId);

    /**
     * 管理员给帖子加精
     * @param postsId 加精的帖子id
     * @return 返回加精结果
     */
    Integer markPost(Integer postsId);

    /**
     * 取消帖子置顶
     * @param postsId       帖子id
     * @return  返回取消置顶结果
     */
    Integer unMarkPost(Integer postsId);

    /**
     * 管理员置顶帖子
     * @param postsId 置顶的帖子id
     * @return  返回置顶结果
     */
    Integer topPost(Integer postsId);

    /**
     * 取消帖子置顶
     * @param postsId   帖子id
     * @return  返回取消指定结果
     */
    Integer unTopPost(Integer postsId);

    /**
     * 新增一条帖子记录（发帖）
     * @param posts  帖子对象
     * @return 返回新增结果
     */
    Integer addOnePosts(Posts posts);
}
