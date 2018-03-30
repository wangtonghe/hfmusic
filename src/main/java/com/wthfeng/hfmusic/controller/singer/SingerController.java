package com.wthfeng.hfmusic.controller.singer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wthfeng.hfmusic.context.UserContext;
import com.wthfeng.hfmusic.model.param.SingerCollectParam;
import com.wthfeng.hfmusic.model.param.SingerParam;
import com.wthfeng.hfmusic.model.view.ViewPageList;
import com.wthfeng.hfmusic.model.view.ViewSinger;
import com.wthfeng.hfmusic.service.singer.SingerService;

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

    /**
     * 收藏、取消收藏歌手
     * @param param
     * @return
     */
    @RequestMapping(value = "/collect",method = RequestMethod.POST)
    public Map<String,Object> collect(SingerCollectParam param)throws Exception{
        Map<String,Object> result = new HashMap<>();
        int userId=0;
        if(UserContext.getUser()!=null){
            userId=UserContext.getUser().getUserId();
        }
        param.setUserId(userId);
        singerService.collect(param);
        result.put("code",0);
        result.put("data",null);
        return result;

    }

    /**
     * 获取某歌手50首歌曲
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getMusicTop50",method = RequestMethod.GET)
    public Map<String,Object> getMusicTop50(int singerId,int userId )throws Exception{
        Map<String,Object> result = new HashMap<>();
        Map<String,Integer> param = new HashMap<>();
        param.put("singerId",singerId);
        param.put("userId",userId);
        result.put("code",0);
        result.put("data",singerService.getMusicTop50(param));
        return result;
    }
}
