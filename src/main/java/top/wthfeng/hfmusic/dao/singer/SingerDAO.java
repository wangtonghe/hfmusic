package top.wthfeng.hfmusic.dao.singer;

import top.wthfeng.hfmusic.model.param.SingerParam;
import top.wthfeng.hfmusic.model.view.ViewSinger;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/5/15 16:02
 * @email wthfeng@126.com
 */
public interface SingerDAO {

    /**
     * 根据条件分页获取歌手
     * @param param
     * @return
     */
    List<ViewSinger> getSingerByArea(SingerParam param);

    /**
     * 根据条件分页获取歌手 获取条数
     * @param param
     * @return
     */
    int getSingerByAreaNum(SingerParam param);

    /**
     * 根据条件分页获取歌手
     * @param param
     * @return
     */
    List<ViewSinger> getSingerByChar(SingerParam param);

    /**
     * 根据条件分页获取歌手 获取条数
     * @param param
     * @return
     */
    int getSingerByCharNum(SingerParam param);

    /**
     * 获取热门歌手
     * @return
     */
    List<ViewSinger> getSingerHot(int num);


}
