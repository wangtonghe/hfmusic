package top.wthfeng.hfmusic.model.view;

import top.wthfeng.hfmusic.model.music.SimpleMusic;

import java.util.Date;
import java.util.List;

/**
 * 歌单详情 出参
 * @author wangtonghe
 * @date 2016/5/7 17:35
 * @email wthfeng@126.com
 */
public class ViewFormDetails {
    private int formId;
    private String formName;
    private Date createTime;
    private String creator;
    private String portrait;
    private int collectNum;
    private String cover;
    private List<String> labels;
    private String info;
    private int musicNum;
    private List<SimpleMusic> musicList;

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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(int collectNum) {
        this.collectNum = collectNum;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getMusicNum() {
        return musicNum;
    }

    public void setMusicNum(int musicNum) {
        this.musicNum = musicNum;
    }

    public List<SimpleMusic> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<SimpleMusic> musicList) {
        this.musicList = musicList;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        portrait = portrait;
    }
}
