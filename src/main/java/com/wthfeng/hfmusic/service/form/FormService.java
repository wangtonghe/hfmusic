package com.wthfeng.hfmusic.service.form;

import com.wthfeng.hfmusic.model.param.AddFormParam;
import com.wthfeng.hfmusic.model.param.FormCollectParam;
import com.wthfeng.hfmusic.model.param.FormParam;
import com.wthfeng.hfmusic.model.view.*;

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
     * @param param
     * @return
     */
    ViewFormDetails getDetails(Map<String,Integer> param)throws Exception;

    /**
     * 根据标签获取歌单
     * @param param
     * @return
     */
    ViewPageList<ViewForm> getFormByLabel(Map<String,Object> param)throws Exception;

    /**
     * 根据标签id获取歌单
     * @param param
     * @return
     */
    ViewPageList<ViewForm> getFormByLabelId(Map<String,Object> param) throws Exception;

    /**
     * 获取系统标签
     * @return
     */
    List<ViewSysLabel> getSysLabel()throws Exception;

    /**
     * 收藏歌单
     * @param param
     */
    void collect(FormCollectParam param)throws Exception;

    /**
     * 根据歌单名获取歌单
     * @return
     */
    List<ViewForm> getByName(String key)throws Exception;

    /**
     * 创建歌单
     * @param param
     * @throws Exception
     */
    void create(FormParam param)throws Exception;

    /**
     * 获取我的歌单
     * @param userId
     * @return
     * @throws Exception
     */
    List<ViewMyForm> getMyFormList(int userId)throws Exception;

    /**
     * 添加歌曲到歌单
     * @param param
     * @throws Exception
     */
    void addMyForm(AddFormParam param)throws Exception;




}
