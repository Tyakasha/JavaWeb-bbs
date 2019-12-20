package ncu.ie.webdesign.dao;

import ncu.ie.webdesign.entity.ThumbInfo;

import java.util.List;

public interface ThumbDAO {
    /**
     * 重置用户名
     * @param userName  旧用户名
     * @param newUserName   新用户名
     * @return  返回重置结果
     */
    Integer resetUserName(String userName, String newUserName);


    /**
     * 增加一条点赞信息
     * @param userName  点赞的用户名
     * @param postId    点赞帖子的id
     * @return  返回插入结果
     */
    Integer addThumbInfo(String userName, int postId);

    /**
     * 删除帖子点赞信息
     * @param postsId    删除帖子id
     * @return  返回删除结果
     */
    Integer deletePostThumbInfo(Integer postsId);

    Integer deleteThumbInfoByUserNameAndPostId(String userName,Integer postsId);

    /**
     * 通过用户名和帖子Id获取点赞信息
     * @param userName      用户名
     * @param postsId           帖子Id
     * @return          返回点赞信息
     */
    ThumbInfo queryByPostsIdAndUserName(String userName,Integer postsId);

    /**
     * 通过帖子id查询所有的点赞信息
     * @param postsId       帖子id
     * @return  返回点赞信息
     */
    List<ThumbInfo> queryAllThumbInfoByPostsId(Integer postsId);
}
