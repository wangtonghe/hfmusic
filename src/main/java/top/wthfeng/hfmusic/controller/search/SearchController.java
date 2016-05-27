package top.wthfeng.hfmusic.controller.search;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wthfeng.hfmusic.model.view.ViewError;
import top.wthfeng.hfmusic.service.form.FormService;
import top.wthfeng.hfmusic.service.music.MusicService;
import top.wthfeng.hfmusic.service.singer.SingerService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 搜索页 controller
 * @author wangtonghe
 * @date 2016/5/27 15:59
 * @email wthfeng@126.com
 */
@RestController
public class SearchController {

    @Resource
    private SingerService singerService;

    @Resource
    private FormService formService;

    @Resource
    private MusicService musicService;


    /**
     * 搜索
     * @param key 搜索关键字
     * @param flag 1表示搜索单曲，2表示搜索歌单，3为搜索歌手
     * @return
     */
    @RequestMapping(value = "/search/all")
    public Map<String,Object> search(String key,int flag)throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        if(flag==1){
            result.put("data",musicService.getByMusicName(key));
        }else if(flag==2){
            result.put("data",formService.getByName(key));
        }else if(flag==3){
            result.put("data",singerService.getByName(key));
        }else{
            result.put("code",1);
            result.put("data", new ViewError("穿入参数非法"));
        }
        return result;
    }

}
