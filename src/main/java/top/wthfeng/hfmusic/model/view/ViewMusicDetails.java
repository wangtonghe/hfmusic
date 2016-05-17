package top.wthfeng.hfmusic.model.view;

/**
 * @author wangtonghe
 * @date 2016/5/17 19:24
 * @email wthfeng@126.com
 */
public class ViewMusicDetails {
    private int musicId;
    private String cover;
    private String singer;
    private int singerId;
    private String album;
    /**
     * 歌曲url
     */
    private String musicUrl;
    /**
     * 歌词url
     */
    private String lyricUrl;

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getLyricUrl() {
        return lyricUrl;
    }

    public void setLyricUrl(String lyricUrl) {
        this.lyricUrl = lyricUrl;
    }
}
