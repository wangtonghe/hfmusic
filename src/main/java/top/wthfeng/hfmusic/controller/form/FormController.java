package top.wthfeng.hfmusic.controller.form;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.wthfeng.hfmusic.model.param.FormCollectParam;
import top.wthfeng.hfmusic.model.param.PageParam;
import top.wthfeng.hfmusic.model.view.ViewError;
import top.wthfeng.hfmusic.service.form.FormService;

import javax.annotation.Resource;
import java.util.Date;
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
     * 未登陆用户不用传授权令牌，登陆用户需传，以便确认是否收藏该歌单
     * @param formId
     */
    @RequestMapping(value = "/details",method = RequestMethod.GET)
    public Map<String,Object>  getDetails(int formId,int userId)throws Exception{
        Map<String,Object> result = new HashMap<>();
        Map<String,Integer> param = new HashMap<>();
        param.put("formId",formId);
        param.put("userId",userId);
        result.put("code",0);
        result.put("data",formService.getDetails(param));
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

    /**
     * 收藏、取消收藏歌单
     * @return
     */
    @RequestMapping(value = "/collect",method = RequestMethod.POST)
    public Map<String,Object> collect(FormCollectParam param)throws Exception{
        Map<String,Object> result = new HashMap<>();
        if(param.getFlag()!=0&&param.getFlag()!=1){
            result.put("code",1);
            result.put("data",new ViewError("flag必须为0或1"));
            return result;
        }
        param.setCreateTime(new Date());
        formService.collect(param);
        result.put("code",0);
        result.put("data",null);
        return result;
    }










}
