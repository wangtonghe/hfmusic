package com.wthfeng.hfmusic.model.param;

/**
 * @author wangtonghe
 * @date 2016/5/15 16:03
 * @email wthfeng@126.com
 */
public class SingerParam extends PageParam {

    /**
     * 传来的歌手姓名首字符，也可能是“热门”
     */
    private String character;

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
