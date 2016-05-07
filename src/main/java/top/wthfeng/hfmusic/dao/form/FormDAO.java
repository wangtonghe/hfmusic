package top.wthfeng.hfmusic.dao.form;

import top.wthfeng.hfmusic.model.view.ViewFormDetails;

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
}
