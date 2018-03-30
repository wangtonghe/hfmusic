package com.wthfeng.hfmusic.dao.music;

import org.apache.ibatis.annotations.Param;
import com.wthfeng.hfmusic.model.music.SimpleMusic;
import com.wthfeng.hfmusic.model.param.MusicUserParam;
import com.wthfeng.hfmusic.model.view.ViewForm;
import com.wthfeng.hfmusic.model.view.ViewHomeMusic;
import com.wthfeng.hfmusic.model.view.ViewMusicDetails;

import java.util.List;

/**
 * 音乐DAO
 * Created by wangtonghe on 2016/1/9.
 */
public interface MusicDAO {

    /**
     * 列出热门收藏歌单
     *
     * @return
     */
     List<ViewForm> listHotCollect();

    /**
     * 列出每月热门音乐
     *
     * @return
     */
     List<ViewHomeMusic> listMonthHotMusic();

    /**
     * 列出每月新歌
     *
     * @return
     */
     List<ViewHomeMusic> listMonthNewMusic();

    /**
     * 歌曲详情
     * @param musicId
     * @return
     */
    ViewMusicDetails details(int musicId);

    /**
     * 喜欢歌曲
     * @param param
     */
    void likeMusic(MusicUserParam param);

    /**
     * 取消喜欢歌曲
     * @param param
     */
    void cancelLikeMusic(MusicUserParam param);

    /**
     * 根据关键字获取歌曲
     * @param key
     * @return
     */
    List<SimpleMusic> getByMusicName(@Param(value = "musicName") String key);






}
