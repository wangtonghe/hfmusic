package top.wthfeng.hfmusic.model.system;

/**
 * @author wangtonghe
 * @date 2016/5/15 19:30
 * @email wthfeng@126.com
 */
public class SysUser {
    private int userId;
    private String userName;
    private int sex;
    private String headPortrait;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
