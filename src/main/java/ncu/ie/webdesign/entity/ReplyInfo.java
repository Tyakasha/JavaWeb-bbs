package ncu.ie.webdesign.entity;

public class ReplyInfo {

    //回复帖ID 主键
    private Integer replyId;

    //回复的帖子ID
    private Integer postId;

    //回复内容
    private String replyContent;

    //回复用户
    private String replyUser;

    //采纳标识  1采纳
    private Integer replyAdoptFlag;

    //回复日期
    private String replyDate;

    public ReplyInfo() {
    }

    public ReplyInfo(Integer replyId, Integer postId, String replyContent, String replyUser, Integer replyAdoptFlag, String replyDate) {
        this.replyId = replyId;
        this.postId = postId;
        this.replyContent = replyContent;
        this.replyUser = replyUser;
        this.replyAdoptFlag = replyAdoptFlag;
        this.replyDate = replyDate;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public String getReplyUser() {
        return replyUser;
    }

    public void setReplyUser(String replyUser) {
        this.replyUser = replyUser;
    }

    public Integer getReplyAdoptFlag() {
        return replyAdoptFlag;
    }

    public void setReplyAdoptFlag(Integer replyAdoptFlag) {
        this.replyAdoptFlag = replyAdoptFlag;
    }

    public String getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(String replyDate) {
        this.replyDate = replyDate;
    }

    @Override
    public String toString() {
        return "ReplyInfo{" +
                "replyId=" + replyId +
                ", postId=" + postId +
                ", replyContent='" + replyContent + '\'' +
                ", replyUser='" + replyUser + '\'' +
                ", replyAdoptFlag=" + replyAdoptFlag +
                ", replyDate=" + replyDate +
                '}';
    }
}
