package top.wthfeng.hfmusic.service.impl.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.hfmusic.dao.form.FormDAO;
import top.wthfeng.hfmusic.dao.music.MusicDAO;
import top.wthfeng.hfmusic.model.music.SimpleMusic;
import top.wthfeng.hfmusic.model.param.MusicUserParam;
import top.wthfeng.hfmusic.model.view.ViewMusicDetails;
import top.wthfeng.hfmusic.service.music.MusicService;
import top.wthfeng.hfmusic.util.HttpClientUtil;

import java.util.Date;
import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/5/17 19:37
 * @email wthfeng@126.com
 */
@Service("musicService")
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicDAO musicDAO;
    @Autowired
    private FormDAO formDAO;

    @Override
    public List<SimpleMusic> getByMusicName(String key) throws Exception {
        return musicDAO.getByMusicName(key);
    }

    @Override
    public void likeMusic(MusicUserParam param) throws Exception {
        param.setCreateTime(new Date());
        int formId=formDAO.getDefaultFormId(param.getUserId());
        param.setFormId(formId);
        if(param.getFlag()==0){  //取消喜欢
            musicDAO.cancelLikeMusic(param);
            formDAO.deleteDefaultForm(param);
        }else {
            musicDAO.likeMusic(param);
            formDAO.add2DefaultForm(param);
        }
    }

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
