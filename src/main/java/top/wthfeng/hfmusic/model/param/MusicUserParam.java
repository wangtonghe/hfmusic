package top.wthfeng.hfmusic.model.param;

import java.util.Date;

/**
 * @author wangtonghe
 * @date 2016/5/24 17:35
 * @email wthfeng@126.com
 */
public class MusicUserParam {
    private int formId;
    private int musicId;
    private int userId;
    private int flag;
    private Date createTime;

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
