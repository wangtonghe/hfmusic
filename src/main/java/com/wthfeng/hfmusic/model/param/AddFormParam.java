package com.wthfeng.hfmusic.model.param;

/**
 * 添加歌单
 * @author wangtonghe
 * @date 2016/5/31 14:54
 * @email wthfeng@126.com
 */
public class AddFormParam {
    private Integer formId;
    private Integer musicId;

    public Integer getFormId() {
        return formId;
    }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }
}
