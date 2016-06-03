package top.wthfeng.hfmusic.model.param;

import java.util.Date;

/**
 * 注册用户入参
 * Created by Administrator on 2016/1/2.
 */
public class RegisterUserParam {
    private Integer userId;
    private String username;
    private String password;
    private String accessToken;
    private Date lastLoginTime;
    private String headPortrait;
    private Byte starNum;
    private String nickName;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public Byte getStarNum() {
        return starNum;
    }

    public void setStarNum(Byte starNum) {
        this.starNum = starNum;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
