package top.wthfeng.hfmusic.model.view;

/**
 * Created by Administrator on 2016/1/1.
 */
public class ViewUserLogin {

    /**
     * 用户id
     */
    private int userId;
    private String username;
    private String nickName;
    private String accessToken;
    /**
     * 性别，0为男，1为女
     */
    private Byte sex;
    private Byte starNum;
    private String headPortrait;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getStarNum() {
        return starNum;
    }

    public void setStarNum(Byte starNum) {
        this.starNum = starNum;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }
}
