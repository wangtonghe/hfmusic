package top.wthfeng.hfmusic.dao.form;

import org.apache.ibatis.annotations.Param;
import top.wthfeng.hfmusic.model.view.ViewForm;
import top.wthfeng.hfmusic.model.view.ViewFormDetails;
import top.wthfeng.hfmusic.model.view.ViewSysLabel;

import java.util.List;
import java.util.Map;

/**
 * @author wangtonghe
 * @date 2016/5/7 17:50
 * @email wthfeng@126.com
 */
public interface FormDAO {

    /**
     * 获取歌单详情
     * @param formId
     * @return
     */
    ViewFormDetails getDetails(Integer formId);

    /**
     * 根据标签获取歌单(分页)
     * @param param
     * @return
     */
    List<ViewForm> getFormByLabel(Map<String,Object> param);

    /**
     * 根据标签id获取歌单(分页)
     * @param param
     * @return
     */
    List<ViewForm> getFormByLabelId(Map<String,Object> param);

    /**
     * 根据标签id获取歌单总数
     * @param labelId
     * @return
     */
     int getFormByLabelIdNum(int  labelId);


    /**
     * 根据标签获取歌单总数
     * @param label
     * @return
     */
    int getFormByLabelNum(@Param("label") String label);

    /**
     * 获取系统标签
     * @return
     */
    List<ViewSysLabel> getSysLabel();


}
