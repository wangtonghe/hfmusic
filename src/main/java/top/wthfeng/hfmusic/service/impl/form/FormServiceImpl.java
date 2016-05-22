package top.wthfeng.hfmusic.service.impl.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.hfmusic.dao.form.FormDAO;
import top.wthfeng.hfmusic.dao.home.HomeDAO;
import top.wthfeng.hfmusic.model.view.ViewForm;
import top.wthfeng.hfmusic.model.view.ViewFormDetails;
import top.wthfeng.hfmusic.model.view.ViewPageList;
import top.wthfeng.hfmusic.model.view.ViewSysLabel;
import top.wthfeng.hfmusic.service.form.FormService;
import top.wthfeng.hfmusic.util.NumberUtil;

import java.util.List;
import java.util.Map;

/**
 * @author wangtonghe
 * @date 2016/5/7 17:49
 * @email wthfeng@126.com
 */
@Service("formService")
public class FormServiceImpl implements FormService {


    private static final int HOT_FORM_NUM=12;

    @Autowired
    private FormDAO formDAO;

    @Autowired
    private HomeDAO homeDAO;

    @Override
    public ViewPageList<ViewForm> getFormByLabel(Map<String,Object> param)throws Exception {
        ViewPageList<ViewForm> data=new ViewPageList<>();
        data.setList(formDAO.getFormByLabel(param));
        data.setTotalPageNum(NumberUtil.getPageNum(formDAO.getFormByLabelNum((String)param.get("label")),(Integer) param.get("pageSize")));
        return data;
    }

    @Override
    public ViewPageList<ViewForm> getFormByLabelId(Map<String, Object> param) {
        ViewPageList<ViewForm> data=new ViewPageList<>();
        if(((Integer)param.get("labelId")).intValue()==0){
            data.setList(homeDAO.hotForm(HOT_FORM_NUM));
            data.setTotalPageNum(HOT_FORM_NUM);
            return data;
        }

        data.setList(formDAO.getFormByLabelId(param));
        data.setTotalPageNum(NumberUtil.getPageNum(formDAO.getFormByLabelIdNum((Integer)param.get("labelId")),(Integer) param.get("pageSize")));
        return data;
    }

    @Override
    public List<ViewSysLabel> getSysLabel()throws Exception {
        return formDAO.getSysLabel();
    }

    @Override
    public ViewFormDetails getDetails(Integer formId)throws Exception {
        return formDAO.getDetails(formId);
    }
}
