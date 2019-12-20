package ncu.ie.webdesign.entity;

public class ThumbInfo {

    /**
     * 点赞的帖子ID
     */
    private Integer postsId;

    /**
     * 点赞的用户的用户名
     */
    private String thumbUser;

    public Integer getPostsId() {
        return postsId;
    }

    public void setPostsId(Integer postsId) {
        this.postsId = postsId;
    }

    public String getThumbUser() {
        return thumbUser;
    }

    public void setThumbUser(String thumbUser) {
        this.thumbUser = thumbUser;
    }

    public ThumbInfo(Integer postsId, String thumbUser) {
        this.postsId = postsId;
        this.thumbUser = thumbUser;
    }

    public ThumbInfo() {
    }

    @Override
    public String toString() {
        return "ThumbInfo{" +
                "postId=" + postsId +
                ", thumbUser='" + thumbUser + '\'' +
                '}';
    }
}
