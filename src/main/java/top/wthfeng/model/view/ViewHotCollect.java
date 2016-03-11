package top.wthfeng.model.view;

/**
 * 热门收藏
 * Created by wangtonghe on 2016/1/9.
 */
public class ViewHotCollect {
    /**
     * 热门收藏id
     */
    private Integer id;
    /**
     * 热门收藏名称
     */
    private String name;
    /**
     * 热门收藏封面图片
     */
    private String cover;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
