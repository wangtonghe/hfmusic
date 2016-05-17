package top.wthfeng.hfmusic.service.mine;

import top.wthfeng.hfmusic.model.view.ViewMyForm;
import top.wthfeng.hfmusic.model.view.ViewSinger;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/5/15 17:29
 * @email wthfeng@126.com
 */
public interface MineService {

    /**
     * 得到我的歌单
     * @return
     */
    List<ViewMyForm> getMyForm(int userId);

    /**
     * 得到我收藏的歌单
     * @return
     */
    List<ViewMyForm> getCollectForm(int userId);

    /**
     * 获取收藏的歌手
     * @param userId
     * @return
     */
    List<ViewSinger> getCollectSinger(int userId);





}
