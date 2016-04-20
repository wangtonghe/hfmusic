package top.wthfeng.hfmusic.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wthfeng.hfmusic.model.view.ViewHotForm;
import top.wthfeng.hfmusic.model.view.ViewHomeMusic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页
 * @author wangtonghe
 * @date 2016/4/20 21:31
 * @email wthfeng@126.com
 */
@Controller
public class HomeController {

    /**
     * 获取首页热门歌单（8个）
     * @return
     */
    @RequestMapping(value = "/home/HotForm",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> HotSpecial(){
        Map<String,Object> result = new HashMap<>();
        List<ViewHotForm> data = null;
        result.put("code",0);
        result.put("data",data);
        return result;
    }

    /**
     * 获取首页本月热门歌曲（10首）
     * @return
     */
    @RequestMapping(value = "/home/monthlyHot",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> monthlyHot(){
        Map<String,Object> result = new HashMap<>();
        List<ViewHomeMusic> data = null;
        result.put("code",0);
        result.put("data",data);
        return result;
    }

    /**
     * 获取首页本月热门新歌（10首）
     * @return
     */
    @RequestMapping(value = "/home/monthlyNew",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> monthlyNew(){
        Map<String,Object> result = new HashMap<>();
        List<ViewHomeMusic> data = null;
        result.put("code",0);
        result.put("data",data);
        return result;
    }








}
