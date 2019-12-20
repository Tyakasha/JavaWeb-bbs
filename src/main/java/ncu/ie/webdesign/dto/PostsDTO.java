package ncu.ie.webdesign.dto;

/**
 * @author by Wan HaoDong
 * @date 2019-12-15    01:43
 **/
public class PostsDTO {

    /*
    * 帖子ID
    * */
    private Integer postsId;

    /**
     * 帖子标题
     */
    private String title;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 帖子点赞数
     */
    private Integer thumbNum;

    /**
     * 帖子发布用户用户名
     */
    private String postUser;

    /**
     * 帖子发布日期
     */
    private String postDate;

    /**
     * 帖子置顶标识
     */
    private Integer topFlag;

    /**
     * 帖子加精标识
     */
    private Integer boutiqueFlag;

    /**
     * 用户点赞标识
     */
    private Integer userThumbFlag;


    public PostsDTO() {
    }

    public PostsDTO(Integer postsId, String title, String content, Integer thumbNum, String postUser, String postDate, Integer topFlag) {
        this.postsId = postsId;
        this.title = title;
        this.content = content;
        this.thumbNum = thumbNum;
        this.postUser = postUser;
        this.postDate = postDate;
        this.topFlag = topFlag;
    }

    public Integer getPostsId() {
        return postsId;
    }

    public void setPostsId(Integer postsId) {
        this.postsId = postsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getThumbNum() {
        return thumbNum;
    }

    public void setThumbNum(Integer thumbNum) {
        this.thumbNum = thumbNum;
    }

    public String getPostUser() {
        return postUser;
    }

    public void setPostUser(String postUser) {
        this.postUser = postUser;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public Integer getTopFlag() {
        return topFlag;
    }

    public void setTopFlag(Integer topFlag) {
        this.topFlag = topFlag;
    }

    public Integer getBoutiqueFlag() {
        return boutiqueFlag;
    }

    public void setBoutiqueFlag(Integer boutiqueFlag) {
        this.boutiqueFlag = boutiqueFlag;
    }

    public Integer getUserThumbFlag() {
        return userThumbFlag;
    }

    public void setUserThumbFlag(Integer userThumbFlag) {
        this.userThumbFlag = userThumbFlag;
    }

    @Override
    public String toString() {
        return "PostsDTO{" +
                "postId=" + postsId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", thumbNum=" + thumbNum +
                ", postUser='" + postUser + '\'' +
                ", postDate='" + postDate + '\'' +
                ", topFlag=" + topFlag +
                ", boutiqueFlag=" + boutiqueFlag +
                ", userThumbFlag=" + userThumbFlag +
                '}';
    }
}
