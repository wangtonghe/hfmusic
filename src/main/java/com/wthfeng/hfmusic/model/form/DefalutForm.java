package com.wthfeng.hfmusic.model.form;

import java.util.Date;

/**
 * 默认歌单
 * @author wangtonghe
 * @date 2016/5/24 16:41
 * @email wthfeng@126.com
 */
public class DefalutForm {
    private String formName;
    private int userId;
    private Date createTime;
    private String cover;
    private int isSystem;
    private int online;

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(int isSystem) {
        this.isSystem = isSystem;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }
}
