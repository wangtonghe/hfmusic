package top.wthfeng.hfmusic.service.home;

import top.wthfeng.hfmusic.model.view.ViewHomeMusic;
import top.wthfeng.hfmusic.model.view.ViewForm;
import top.wthfeng.hfmusic.model.view.ViewHotSinger;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/4/20 22:36
 * @email wthfeng@126.com
 */
public interface HomeService {

    /**
     * 获取热门歌单
     * @return
     */
     List<ViewForm> HotForm();

    /**
     * 获取本月热门歌曲
     * @return
     */
     List<ViewHomeMusic> monthlyHot();

    /**
     * 获取本月热门新歌
     * @return
     */
     List<ViewHomeMusic> monthlyNew();

    /**
     * 获取热门歌手
     * @return
     */
    List<ViewHotSinger> hotSinger();



}
