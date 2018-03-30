package com.wthfeng.hfmusic.service.impl.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wthfeng.hfmusic.dao.home.HomeDAO;
import com.wthfeng.hfmusic.model.view.ViewHomeMusic;
import com.wthfeng.hfmusic.model.view.ViewForm;
import com.wthfeng.hfmusic.model.view.ViewHotSinger;
import com.wthfeng.hfmusic.service.home.HomeService;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/4/20 22:41
 * @email wthfeng@126.com
 */
@Service("homeService")
public class HomeServiceImpl implements HomeService {

    private static final int HOT_FORM_NUM=8;

    @Autowired
    private HomeDAO homeDAO;

    @Override
    public List<ViewForm> HotForm()throws Exception {
        return homeDAO.hotForm(HOT_FORM_NUM);
    }

    @Override
    public List<ViewHomeMusic> monthlyHot()throws Exception {
        return homeDAO.monthlyHot();
    }

    @Override
    public List<ViewHomeMusic> monthlyNew()throws Exception {
        return homeDAO.monthlyNew();
    }

    @Override
    public List<ViewHotSinger> hotSinger()throws Exception {
        return homeDAO.hotSinger();
    }
}
