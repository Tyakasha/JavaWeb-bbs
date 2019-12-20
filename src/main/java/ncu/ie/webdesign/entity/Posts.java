package ncu.ie.webdesign.entity;



public class Posts {


    /**
     * 帖子Id
     */
    private Integer postsId;

    /**
     * 发布帖子的用户的用户名
     */
    private String postUser;

    /**
     * 帖子标题
     */
    private String title;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 帖子类型 0普通帖 1问答帖
     */
    private Integer type;

    /**
     * 帖子种类标签 默认其他
     */
    private String tag;

    /**
     * 帖子点赞量
     */
    private Integer thumbNum;

    /**
     * 置顶标记
     */
    private Integer topFlag;

    /**
     * 帖子加精标签 1表示加精
     */
    private Integer boutiqueFlag;

    /**
     * 帖子发布日期
     */
    private String postDate;

    /**
     * 帖子积分奖励，默认为0
     */
    private Integer reward;

    public Posts() {
    }

    public Posts(Integer postsId, String postUser, String title, String content, Integer type, String tag, Integer thumbNum, Integer topFlag, Integer boutiqueFlag, String postDate, Integer reward) {
        this.postsId = postsId;
        this.postUser = postUser;
        this.title = title;
        this.content = content;
        this.type = type;
        this.tag = tag;
        this.thumbNum = thumbNum;
        this.topFlag = topFlag;
        this.boutiqueFlag = boutiqueFlag;
        this.postDate = postDate;
        this.reward = reward;
    }

    public Posts(String postUser, String title, String content, Integer type, String tag, Integer reward) {
        this.postUser = postUser;
        this.title = title;
        this.content = content;
        this.type = type;
        this.tag = tag;
        this.reward = reward;
    }

    public Integer getPostsId() {
        return postsId;
    }

    public void setPostsId(Integer postsId) {
        this.postsId = postsId;
    }

    public String getPostUser() {
        return postUser;
    }

    public void setPostUser(String postUser) {
        this.postUser = postUser;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getThumbNum() {
        return thumbNum;
    }

    public void setThumbNum(Integer thumbNum) {
        this.thumbNum = thumbNum;
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

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "postsId=" + postsId +
                ", postsUser='" + postUser + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", tag='" + tag + '\'' +
                ", thumbNum=" + thumbNum +
                ", topFlag=" + topFlag +
                ", boutiqueFlag=" + boutiqueFlag +
                ", postDate=" + postDate +
                ", reward=" + reward +
                '}';
    }
}
