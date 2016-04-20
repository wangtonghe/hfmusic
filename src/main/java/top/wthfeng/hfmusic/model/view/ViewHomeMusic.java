package top.wthfeng.hfmusic.model.view;

/**
 * 每月热歌
 * Created by wangtonghe on 2016/1/9.
 */
public class ViewHomeMusic {
    /**
     * 歌曲id
     */
    private Integer musicId;
    /**
     * 歌曲名称
     */
    private String musicName;
    /**
     * 歌手名
     */
    private String singerName;
    /**
     * 喜欢数
     */
    private Integer likeNum;

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
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

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }
}
