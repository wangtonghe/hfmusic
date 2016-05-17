package top.wthfeng.hfmusic.service.impl.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.hfmusic.dao.music.MusicDAO;
import top.wthfeng.hfmusic.model.view.ViewMusicDetails;
import top.wthfeng.hfmusic.service.music.MusicService;

/**
 * @author wangtonghe
 * @date 2016/5/17 19:37
 * @email wthfeng@126.com
 */
@Service("musicService")
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicDAO musicDAO;

    @Override
    public ViewMusicDetails details(int musicId) {
        return musicDAO.details(musicId);
    }
}
