package top.wthfeng.hfmusic.model.view;

import java.util.List;

/**
 * 分页 数据结构
 * @author wangtonghe
 * @date 2016/5/15 10:54
 * @email wthfeng@126.com
 */
public class ViewPageList<T> {
    /**
     * 数据集合
     */
    private List<T> list;

    /**
     * 总页数
     */
    private int totalPageNum;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }
}
