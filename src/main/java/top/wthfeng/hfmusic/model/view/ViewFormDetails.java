package top.wthfeng.hfmusic.model.view;

import top.wthfeng.hfmusic.model.form.FormLabel;
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
    /**
     * 歌单id
     */
    private int formId;
    /**
     * 歌单名
     */
    private String formName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 用户头像
     */
    private String headPortrait;

    /**
     * 收藏数
     */
    private int collectNum;
    /**
     * 封面
     */
    private String cover;
    /**
     * 标签
     */
    private List<FormLabel> labels;
    /**
     * 介绍
     */
    private String info;
    /**
     * 是否收藏
     */
    private int isCollect;

    /**
     * 歌曲数
     */
    private int musicNum;
    /**
     * 歌曲列表
     */
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

    public List<FormLabel> getLabels() {
        return labels;
    }

    public void setLabels(List<FormLabel> labels) {
        this.labels = labels;
    }

    public int getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(int isCollect) {
        this.isCollect = isCollect;
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

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }
}
