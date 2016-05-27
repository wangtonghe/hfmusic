package top.wthfeng.hfmusic.service.singer;

import top.wthfeng.hfmusic.model.param.SingerCollectParam;
import top.wthfeng.hfmusic.model.param.SingerParam;
import top.wthfeng.hfmusic.model.view.ViewPageList;
import top.wthfeng.hfmusic.model.view.ViewSinger;
import top.wthfeng.hfmusic.model.view.ViewSingerMusic;

import java.util.List;
import java.util.Map;

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

    /**
     * 获取某歌手50首歌曲
     * @param param
     * @return
     */
    ViewSingerMusic getMusicTop50(Map<String,Integer> param);

    /**
     * 收藏歌手
     * @param param
     */
    void collect(SingerCollectParam param);

    /**
     * 根据名字获取歌手
     * @param key
     * @return
     */
    List<ViewSinger> getByName(String key);








}
