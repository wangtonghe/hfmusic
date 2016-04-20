package top.wthfeng.hfmusic.model.view;

/**
 * 热门收藏(歌单)
 * Created by wangtonghe on 2016/1/9.
 */
public class ViewHotForm {
    /**
     * 热门收藏id
     */
    private Integer formId;
    /**
     * 热门收藏名称
     */
    private String name;
    /**
     * 热门收藏封面图片
     */
    private String cover;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 喜欢人数+收藏数
     */
    private Integer hot;
    /**
     * 是否是系统歌单（用户创建的为0）
     */
   private Integer isSystem;

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getHot() {
        return hot;
    }

    public void setHot(Integer hot) {
        this.hot = hot;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
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
