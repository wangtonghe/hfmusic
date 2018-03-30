package com.wthfeng.hfmusic.model.view;

/**
 * 歌手 出参
 * @author wangtonghe
 * @date 2016/5/15 15:54
 * @email wthfeng@126.com
 */
public class ViewSinger {
    private int singerId;
    private String singerName;
    private String portrait;
    private int hot;
    /**
     * 歌曲数
     */
    private int musicNum;


    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getMusicNum() {
        return musicNum;
    }

    public void setMusicNum(int musicNum) {
        this.musicNum = musicNum;
    }
}
