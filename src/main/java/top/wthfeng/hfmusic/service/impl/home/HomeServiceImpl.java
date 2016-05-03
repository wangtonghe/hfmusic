package top.wthfeng.hfmusic.service.impl.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.hfmusic.dao.home.HomeDAO;
import top.wthfeng.hfmusic.model.view.ViewHomeMusic;
import top.wthfeng.hfmusic.model.view.ViewHotForm;
import top.wthfeng.hfmusic.model.view.ViewHotSinger;
import top.wthfeng.hfmusic.service.home.HomeService;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/4/20 22:41
 * @email wthfeng@126.com
 */
@Service("homeService")
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeDAO homeDAO;

    @Override
    public List<ViewHotForm> HotForm() {
        return homeDAO.hotForm();
    }

    @Override
    public List<ViewHomeMusic> monthlyHot() {
        return homeDAO.monthlyHot();
    }

    @Override
    public List<ViewHomeMusic> monthlyNew() {
        return homeDAO.monthlyNew();
    }

    @Override
    public List<ViewHotSinger> hotSinger() {
        return homeDAO.hotSinger();
    }
}
