package com.wthfeng.hfmusic.service.impl.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wthfeng.hfmusic.dao.form.FormDAO;
import com.wthfeng.hfmusic.dao.home.HomeDAO;
import com.wthfeng.hfmusic.model.param.AddFormParam;
import com.wthfeng.hfmusic.model.param.FormCollectParam;
import com.wthfeng.hfmusic.model.param.FormParam;
import com.wthfeng.hfmusic.model.view.*;
import com.wthfeng.hfmusic.service.form.FormService;
import com.wthfeng.hfmusic.util.NumberUtil;

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
    public void collect(FormCollectParam param) {
        if(param.getFlag()==0){
            formDAO.cancelCollect(param);
        }else{
            formDAO.collect(param);
        }
    }

    @Override
    public void create(FormParam param) throws Exception {
        formDAO.create(param);
        formDAO.insertLabels(param);
    }

    @Override
    public List<ViewMyForm> getMyFormList(int userId) throws Exception {
        return formDAO.listMyForm(userId);
    }

    @Override
    public void addMyForm(AddFormParam param) throws Exception {
        formDAO.addMyForm(param);

    }

    @Override
    public List<ViewForm> getByName(String key) {
        return formDAO.getByName(key);
    }

    @Override
    public ViewFormDetails getDetails(Map<String,Integer> param)throws Exception {
        return formDAO.getDetails(param);
    }
}
