package top.wthfeng.hfmusic.dao.music;

import top.wthfeng.hfmusic.model.view.ViewForm;
import top.wthfeng.hfmusic.model.view.ViewHomeMusic;
import top.wthfeng.hfmusic.model.view.ViewMusicDetails;

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




}
