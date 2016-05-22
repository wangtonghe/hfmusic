package top.wthfeng.hfmusic.controller.mine;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.wthfeng.hfmusic.context.UserContext;
import top.wthfeng.hfmusic.model.view.ViewMyForm;
import top.wthfeng.hfmusic.model.view.ViewSinger;
import top.wthfeng.hfmusic.service.mine.MineService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 * @author wangtonghe
 * @date 2016/5/15 17:21
 * @email wthfeng@126.com
 */
@RestController
@RequestMapping("/mine")
public class MineController {

    @Resource
    private MineService mineService;

    /**
     * 获取我创建的歌单
     * @return
     */
    @RequestMapping(value = "/getMyForm",method = RequestMethod.GET)
    public Map<String,Object> getMyForm()throws Exception{
        Map<String,Object> result = new HashMap<>();
        int userId= UserContext.getUser().getUserId();
        List<ViewMyForm> list = mineService.getMyForm(userId);
        result.put("code",0);
        result.put("data",list);
        return result;
    }

    /**
     * 获取我收藏的歌单
     * @return
     */
    @RequestMapping(value = "/getCollectForm",method = RequestMethod.GET)
    public Map<String,Object> getCollectForm()throws Exception{
        Map<String,Object> result = new HashMap<>();
        int userId= UserContext.getUser().getUserId();
        List<ViewMyForm> list = mineService.getCollectForm(userId);
        result.put("code",0);
        result.put("data",list);
        return result;

    }
    /**
     * 获取我收藏的歌手
     * @return
     */
    @RequestMapping(value = "/getCollectSinger",method = RequestMethod.GET)
    public Map<String,Object> getCollectSinger()throws Exception{
        Map<String,Object> result = new HashMap<>();
        int userId= UserContext.getUser().getUserId();
        List<ViewSinger> list = mineService.getCollectSinger(userId);
        result.put("code",0);
        result.put("data",list);
        return result;

    }
}

