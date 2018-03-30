package com.wthfeng.hfmusic.model.param;

import java.util.Date;

/**
 * @author wangtonghe
 * @date 2016/5/24 11:38
 * @email wthfeng@126.com
 */
public class FormCollectParam {
    /**
     * 收藏用户id
     */
    private int userId;
    /**
     * 收藏歌单id
     */
    private int formId;
    /**
     * 1为收藏，0为取消收藏
     */
    private int flag;

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
