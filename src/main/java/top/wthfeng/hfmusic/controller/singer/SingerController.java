package top.wthfeng.hfmusic.controller.singer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.wthfeng.hfmusic.model.param.SingerParam;
import top.wthfeng.hfmusic.model.view.ViewPageList;
import top.wthfeng.hfmusic.model.view.ViewSinger;
import top.wthfeng.hfmusic.service.singer.SingerService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 歌手controller
 * @author wangtonghe
 * @date 2016/5/15 15:42
 * @email wthfeng@126.com
 */
@RestController
@RequestMapping("/singer")
public class SingerController {

    @Resource
    private SingerService singerService;

    /**
     * 根据地区、性别获取歌手
     * @return
     */
    @Deprecated
    @RequestMapping(value = "/getSingerByArea",method = RequestMethod.GET)
    public Map<String,Object> getSingerByArea(SingerParam param)throws Exception{
        Map<String,Object> result = new HashMap<>();
        ViewPageList<ViewSinger> list = singerService.getSingerByArea(param);
        result.put("code",0);
        result.put("data",list);
        return result;
    }

    /**
     * 根据歌手姓名首字符选择歌手
     * @param param
     * @return
     */
    @RequestMapping(value = "/getSingerByChar",method = RequestMethod.GET)
    public Map<String,Object> getSingerByChar(SingerParam param)throws Exception{
        Map<String,Object> result = new HashMap<>();
        ViewPageList<ViewSinger> list = singerService.getSingerByChar(param);
        result.put("code",0);
        result.put("data",list);
        return result;


    }
}
