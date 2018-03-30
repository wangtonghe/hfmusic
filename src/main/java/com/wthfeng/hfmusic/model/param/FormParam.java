package com.wthfeng.hfmusic.model.param;

import java.util.Date;
import java.util.List;

/**
 * 创建歌单 入参
 * @author wangtonghe
 * @date 2016/5/29 16:56
 * @email wthfeng@126.com
 */
public class FormParam {
    /**
     * 歌单id
     */
    private Integer formId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 表单名
     */
    private String formName;
    /**
     * 创建时间
     */
    private Date createTime;
    private List<Integer> labels;
    /**
     * 封面
     */
    private String cover;
    /**
     * 简介
     */
    private String info;

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public List<Integer> getLabels() {
        return labels;
    }

    public void setLabels(List<Integer> labels) {
        this.labels = labels;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
