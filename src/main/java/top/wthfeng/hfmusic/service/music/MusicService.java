package top.wthfeng.hfmusic.service.music;

import top.wthfeng.hfmusic.model.view.ViewMusicDetails;

/**
 * @author wangtonghe
 * @date 2016/5/17 19:24
 * @email wthfeng@126.com
 */
public interface MusicService {

    /**
     * 获取歌曲详情
     * @param musicId
     * @return
     */
    ViewMusicDetails details(int musicId);


}
