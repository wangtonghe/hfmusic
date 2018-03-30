package com.wthfeng.hfmusic.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wthfeng.hfmusic.service.home.HomeService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 首页
 * @author wangtonghe
 * @date 2016/4/20 21:31
 * @email wthfeng@126.com
 */
@RestController
public class HomeController {

    @Resource
    private HomeService homeService;

    /**
     * 获取首页热门歌单（8个）
     * @return
     */
    @RequestMapping(value = "/home/hotForm",method = RequestMethod.GET)
    public Map<String,Object> hotForm()throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",homeService.HotForm());
        return result;
    }

    /**
     * 获取首页本月热门歌曲（10首）
     * @return
     */
    @RequestMapping(value = "/home/monthlyHot",method = RequestMethod.GET)
    public Map<String,Object> monthlyHot()throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",homeService.monthlyHot());
        return result;
    }

    /**
     * 获取首页本月热门新歌（10首）
     * @return
     */
    @RequestMapping(value = "/home/monthlyNew",method = RequestMethod.GET)
    public Map<String,Object> monthlyNew()throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",homeService.monthlyNew());
        return result;
    }

    /**
     * 获取首页本月热门歌手（10人）
     * @return
     */
    @RequestMapping(value = "/home/hotSinger",method = RequestMethod.GET)
    public Map<String,Object> hotSinger()throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",homeService.hotSinger());
        return result;
    }










}
