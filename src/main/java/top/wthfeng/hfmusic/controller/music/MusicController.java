package top.wthfeng.hfmusic.controller.music;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.wthfeng.hfmusic.service.music.MusicService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangtonghe
 * @date 2016/5/17 19:19
 * @email wthfeng@126.com
 */
@RestController
@RequestMapping(value = "/music")
public class MusicController {

    @Resource
    private MusicService musicService;

    /**
     * 获取歌曲详情
     * @param musicId
     * @return
     */
    @RequestMapping(value = "/details",method = RequestMethod.GET)
    public Map<String,Object> details(int musicId)throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",musicService.details(musicId));
        return result;
    }
}
