package top.wthfeng.hfmusic.dao.home;

import top.wthfeng.hfmusic.model.view.ViewHomeMusic;
import top.wthfeng.hfmusic.model.view.ViewHotForm;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/4/20 22:42
 * @email wthfeng@126.com
 */
public interface HomeDAO {
    /**
     * 获取热门歌单
     * @return
     */
     List<ViewHotForm> HotForm();

    /**
     * 获取本月热门歌曲
     * @return
     */
     List<ViewHomeMusic> monthlyHot(String month);

    /**
     * 获取本月热门新歌
     * @return
     */
     List<ViewHomeMusic> monthlyNew(String month);
}
