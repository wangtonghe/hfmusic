package top.wthfeng.hfmusic.model.music;

/**
 * 歌曲主要 参数
 * @author wangtonghe
 * @date 2016/5/7 17:40
 * @email wthfeng@126.com
 */
public class SimpleMusic {
    private int musicId;
    private String musicName;
    private String singerName;
    private String album;
    private String musicUrl;

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

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
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
}
