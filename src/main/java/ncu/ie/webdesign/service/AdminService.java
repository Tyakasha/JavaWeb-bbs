package ncu.ie.webdesign.service;

public interface AdminService {

    /**
     * 管理员删除帖子检查
     * @param postId    删除的帖子id
     * @return  返回删除检查结果
     */
    Boolean deletePostById(int postId);

    /**
     * 管理员加精帖子
     * @param postId 加精帖子的ID
     * @return 返回加精结果
     */
    Boolean markPostCheck(int postId);

    /**
     * 管理员置定帖子
     * @param postId 置定帖子的id
     * @return  返回置定结果
     */
    Boolean topPostCheck(int postId);

    /**
     * 管理员给用户管理权限
     * @param loginAcc  用户账号
     * @return 返回授权结果
     */
    Boolean authorizeCheck(String loginAcc);
}
