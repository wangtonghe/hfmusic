package top.wthfeng.hfmusic.controller.form;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 歌单页面 controller
 * @author wangtonghe
 * @date 2016/5/7 17:19
 * @email wthfeng@126.com
 */
@Controller
@RequestMapping("/form")
public class FormController {

    /**
     * 获取歌单详情
     * @param formId
     */
    @RequestMapping(value = "/details",method = RequestMethod.GET)
    @ResponseBody
    public void getDetails(int formId){
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",null);

    }



}
