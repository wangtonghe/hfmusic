package top.wthfeng.hfmusic.controller.form;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.wthfeng.hfmusic.model.param.PageParam;
import top.wthfeng.hfmusic.service.form.FormService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 歌单页面 controller
 * @author wangtonghe
 * @date 2016/5/7 17:19
 * @email wthfeng@126.com
 */
@RestController
@RequestMapping("/form")
public class FormController {


    @Resource
    private FormService formService;

    /**
     * 获取歌单详情
     * @param formId
     */
    @RequestMapping(value = "/details",method = RequestMethod.GET)
    public Map<String,Object>  getDetails(int formId)throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",formService.getDetails(formId));
        return result;

    }

    /**
     * 根据标签名获取歌单
     * @param label
     * @param pageParam
     * @return
     */
    @RequestMapping(value = "/getFormByLabel",method = RequestMethod.GET)
    public Map<String,Object> getFormByLabel(String label, PageParam pageParam)throws Exception{
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        param.put("pageSize",pageParam.getPageSize());
        param.put("offSet",pageParam.getOffSet());
        param.put("label",label);
        result.put("code",0);
        result.put("data",formService.getFormByLabel(param));
        return result;

    }

    /**
     * 根据标签id获取歌单
     * @return
     */
    @RequestMapping(value = "/getFormByLabelId",method = RequestMethod.GET)
    public Map<String,Object> getFormByLabelId(PageParam pageParam,int labelId)throws Exception{
        Map<String,Object> result = new HashMap<>();
        Map<String,Object> param = new HashMap<>();
        param.put("pageSize",pageParam.getPageSize());
        param.put("offSet",pageParam.getOffSet());
        param.put("labelId",labelId);
        result.put("code",0);
        result.put("data",formService.getFormByLabelId(param));
        return result;

    }

    /**
     * 获取所有系统歌单
     * @return
     */
    @RequestMapping(value = "/getSysLabel",method = RequestMethod.GET)
    public Map<String,Object> getSysLabel()throws Exception{
        Map<String,Object> result = new HashMap<>();
        result.put("code",0);
        result.put("data",formService.getSysLabel());
        return result;

    }



}
