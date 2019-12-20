package ncu.ie.webdesign.dao;

import ncu.ie.webdesign.entity.ReplyInfo;

import java.util.List;

public interface ReplyDAO {

    /**
     * 删除帖子的回复信息
     * @param postsId 删除帖子的id
     * @return 返回删除信息
     */
    Integer deletePostReplyInfo(Integer postsId);

    /**
     * 通过帖子Id查询该帖子的所有回复信息
     * @param postsId   帖子Id
     * @return      帖子的回复信息
     */
    List<ReplyInfo> queryReplyInfoByPostsId(Integer postsId);

    /**
     * 增加一条帖子的回复/评论信息
     * @param postsId
     * @return
     */
    Integer addOneReplyInfo(Integer postsId,String replyContent,String replyUser);



}
