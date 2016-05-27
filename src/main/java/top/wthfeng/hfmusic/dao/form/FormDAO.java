package top.wthfeng.hfmusic.dao.form;

import org.apache.ibatis.annotations.Param;
import top.wthfeng.hfmusic.model.param.FormCollectParam;
import top.wthfeng.hfmusic.model.param.MusicUserParam;
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
     * @param param
     * @return
     */
    ViewFormDetails getDetails(Map<String,Integer> param);

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

    /**
     * 收藏歌单
     * @param param
     */
    void collect(FormCollectParam param);

    /**
     * 取消收藏歌单
     * @param param
     */
    void cancelCollect(FormCollectParam param);

    /**
     * 将某歌添加到默认歌单
     * @param param
     */
    void add2DefaultForm(MusicUserParam param);

    /**
     * 获取默认歌单id
     * @param userId
     */
    int  getDefaultFormId(int userId);

    /**
     * 根据歌单名获取歌单
     * @return
     */
    List<ViewForm> getByName(@Param(value = "formName") String key);



}
