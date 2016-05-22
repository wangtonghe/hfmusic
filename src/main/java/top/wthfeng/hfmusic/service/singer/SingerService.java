package top.wthfeng.hfmusic.service.singer;

import top.wthfeng.hfmusic.model.param.SingerParam;
import top.wthfeng.hfmusic.model.view.ViewPageList;
import top.wthfeng.hfmusic.model.view.ViewSinger;

/**
 * @author wangtonghe
 * @date 2016/5/15 15:51
 * @email wthfeng@126.com
 */
public interface SingerService {

    /**
     * 根据地区获取歌手
     * @param param
     * @return
     */
    ViewPageList<ViewSinger> getSingerByArea(SingerParam param)throws Exception;

    /**
     * 根据首字符获取歌手
     * @param param
     * @return
     */
    ViewPageList<ViewSinger> getSingerByChar(SingerParam param)throws Exception;






}
