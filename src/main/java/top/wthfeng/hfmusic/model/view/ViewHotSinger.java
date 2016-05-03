package top.wthfeng.hfmusic.model.view;

/**
 * 首页热门歌手 出参
 * @author wangtonghe
 * @date 2016/4/23 9:33
 * @email wthfeng@126.com
 */
public class ViewHotSinger {
    /**
     * 歌手id
     */
    private Integer singerId;
    /**
     * 歌手名
     */
    private String singerName;
    /**
     * 歌手热度
     */
    private Integer hot;

    public Integer getSingerId() {
        return singerId;
    }

    public void setSingerId(Integer singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }
}
