package top.wthfeng.hfmusic.dao.music;

import top.wthfeng.hfmusic.model.view.ViewHotForm;
import top.wthfeng.hfmusic.model.view.ViewHomeMusic;

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
    public List<ViewHotForm> listHotCollect();

    /**
     * 列出每月热门音乐
     *
     * @return
     */
    public List<ViewHomeMusic> listMonthHotMusic();

    /**
     * 列出每月新歌
     *
     * @return
     */
    public List<ViewHomeMusic> listMonthNewMusic();


}
