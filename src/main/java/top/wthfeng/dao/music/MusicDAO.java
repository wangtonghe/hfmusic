package top.wthfeng.dao.music;

import top.wthfeng.model.view.ViewHotCollect;
import top.wthfeng.model.view.ViewMonthMusic;

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
    public List<ViewHotCollect> listHotCollect();

    /**
     * 列出每月热门音乐
     *
     * @return
     */
    public List<ViewMonthMusic> listMonthHotMusic();

    /**
     * 列出每月新歌
     *
     * @return
     */
    public List<ViewMonthMusic> listMonthNewMusic();


}
