package top.wthfeng.hfmusic.service.form;

import top.wthfeng.hfmusic.model.view.ViewForm;
import top.wthfeng.hfmusic.model.view.ViewFormDetails;
import top.wthfeng.hfmusic.model.view.ViewPageList;
import top.wthfeng.hfmusic.model.view.ViewSysLabel;

import java.util.List;
import java.util.Map;

/**
 * @author wangtonghe
 * @date 2016/5/7 17:47
 * @email wthfeng@126.com
 */
public interface FormService {
    /**
     * 获取歌单详情
     * @param formId
     * @return
     */
    ViewFormDetails getDetails(Integer formId);

    /**
     * 根据标签获取歌单
     * @param param
     * @return
     */
    ViewPageList<ViewForm> getFormByLabel(Map<String,Object> param);

    /**
     * 根据标签id获取歌单
     * @param param
     * @return
     */
    ViewPageList<ViewForm> getFormByLabelId(Map<String,Object> param);

    /**
     * 获取系统标签
     * @return
     */
    List<ViewSysLabel> getSysLabel();




}
