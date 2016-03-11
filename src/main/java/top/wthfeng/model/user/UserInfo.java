package top.wthfeng.model.user;

/**
 * Created by Administrator on 2016/1/1.
 */
public class UserInfo {
    private Integer userId;
    private String username;
    private String nickName;
    private String accessToken;
    /**
     * 性别，0为男，1为女
     */
    private Byte sex;
    private Byte starNum;
    private String photo;
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
