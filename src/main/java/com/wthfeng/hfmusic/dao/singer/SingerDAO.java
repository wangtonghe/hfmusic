package com.wthfeng.hfmusic.dao.singer;

import org.apache.ibatis.annotations.Param;
import com.wthfeng.hfmusic.model.param.SingerCollectParam;
import com.wthfeng.hfmusic.model.param.SingerParam;
import com.wthfeng.hfmusic.model.view.ViewSinger;
import com.wthfeng.hfmusic.model.view.ViewSingerMusic;

import java.util.List;
import java.util.Map;

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
     * 取消收藏歌手
     * @param param
     */
    void cancelCollect(SingerCollectParam param);

    /**
     * 根据名字获取歌手
     * @param key
     * @return
     */
    List<ViewSinger> getByName(@Param(value = "singerName") String key);


}
