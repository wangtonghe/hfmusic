package top.wthfeng.hfmusic.model.view;

import java.util.Date;

/**
 * 我的歌单 出参
 * @author wangtonghe
 * @date 2016/5/15 17:26
 * @email wthfeng@126.com
 */
public class ViewMyForm {
    private int formId;
    private String formName;
    private String cover;
    private Date createTime;
    /**
     * 歌曲总数
     */
    private int musicNum;

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getMusicNum() {
        return musicNum;
    }

    public void setMusicNum(int musicNum) {
        this.musicNum = musicNum;
    }
}
