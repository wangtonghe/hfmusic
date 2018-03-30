package com.wthfeng.hfmusic.model.param;

import java.util.Date;

/**
 * 歌手收藏入参
 * @author wangtonghe
 * @date 2016/5/26 16:27
 * @email wthfeng@126.com
 */
public class SingerCollectParam {
    /**
     * 歌手id
     */
    private int singerId;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 1为收藏，0为取消收藏
     */
    private int flag;

    private Date createTime;

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
