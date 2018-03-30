package com.wthfeng.hfmusic.model.music;

/**
 * @author wangtonghe
 * @date 2016/5/26 16:33
 * @email wthfeng@126.com
 */
public class SingerMusic {

    private int musicId;
    private String musicName;
    private String album;
    private String musicUrl;

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
