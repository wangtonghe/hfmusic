package top.wthfeng.hfmusic.service.impl.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.View;
import top.wthfeng.hfmusic.dao.music.MusicDAO;
import top.wthfeng.hfmusic.model.music.MusicDetails;
import top.wthfeng.hfmusic.model.view.ViewMusicDetails;
import top.wthfeng.hfmusic.service.music.MusicService;
import top.wthfeng.hfmusic.util.HttpClientUtil;

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
    public ViewMusicDetails details(int musicId) throws Exception {
         ViewMusicDetails details = musicDAO.details(musicId);
         HttpClientUtil httpClientUtil = new HttpClientUtil();
         String lyric = httpClientUtil.doGet(details.getLyric());
         System.out.println("lyric = " + lyric);
         details.setLyric(lyric);
         return details;
    }
}
