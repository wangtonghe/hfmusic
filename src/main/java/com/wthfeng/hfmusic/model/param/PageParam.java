package com.wthfeng.hfmusic.model.param;

/**
 * 分页 入参
 * @author wangtonghe
 * @date 2016/5/15 11:06
 * @email wthfeng@126.com
 */
public class PageParam {
    private Integer pageNum;
    private Integer pageSize;
    private Integer offSet;

    public Integer getPageNum() {
        if(pageNum==null||pageNum<1){
            return 1;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if(pageSize==null||pageSize<1){
            return 20;
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffSet() {
        return (this.getPageNum()-1)*this.getPageSize();
    }

    public void setOffSet(Integer offSet) {
        this.offSet = offSet;
    }
}
