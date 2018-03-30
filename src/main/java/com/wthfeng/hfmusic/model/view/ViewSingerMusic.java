package com.wthfeng.hfmusic.model.view;

import com.wthfeng.hfmusic.model.music.SingerMusic;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/5/26 16:31
 * @email wthfeng@126.com
 */
public class ViewSingerMusic {
    private int singerId;
    private String singerName;
    private int isCollect;
    private String cover;

    private List<SingerMusic> musics;

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

    public int getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(int isCollect) {
        this.isCollect = isCollect;
    }

    public List<SingerMusic> getMusics() {
        return musics;
    }

    public void setMusics(List<SingerMusic> musics) {
        this.musics = musics;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
