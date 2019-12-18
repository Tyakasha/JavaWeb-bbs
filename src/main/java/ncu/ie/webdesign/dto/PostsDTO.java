package ncu.ie.webdesign.dto;

/**
 * @author by Wan HaoDong
 * @date 2019-12-15    01:43
 **/
public class PostsDTO {

    private Integer postId;
    private String title;
    private String content;
    private Integer thumbNum;
    private String postUser;
    private String postDate;

    public PostsDTO(Integer postId, String title, String content, Integer thumbNum, String postUser, String postDate) {
        this.postId = postId;
        this.title = title;
        this.content = content;
        this.thumbNum = thumbNum;
        this.postUser = postUser;
        this.postDate = postDate;
    }

    public PostsDTO() {
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
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
}
