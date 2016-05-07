package top.wthfeng.hfmusic.service.form;

import top.wthfeng.hfmusic.model.view.ViewFormDetails;

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
}
