package com.wthfeng.hfmusic.service.music;

import com.wthfeng.hfmusic.model.music.SimpleMusic;
import com.wthfeng.hfmusic.model.param.MusicUserParam;
import com.wthfeng.hfmusic.model.view.ViewMusicDetails;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/5/17 19:24
 * @email wthfeng@126.com
 */
public interface MusicService {

    /**
     * 获取歌曲详情
     * @param musicId
     * @return
     */
    ViewMusicDetails details(int musicId)throws Exception;

    /**
     * 喜欢或取消喜欢歌曲
     * @param param
     * @throws Exception
     */
    void likeMusic(MusicUserParam param)throws Exception;

    /**
     * 根据关键字查询歌曲
     * @param key
     * @return
     * @throws Exception
     */
    List<SimpleMusic> getByMusicName(String key)throws Exception;






}
