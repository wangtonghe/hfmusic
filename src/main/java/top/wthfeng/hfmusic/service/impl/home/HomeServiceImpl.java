package top.wthfeng.hfmusic.service.impl.home;

import org.springframework.stereotype.Service;
import top.wthfeng.hfmusic.model.view.ViewHomeMusic;
import top.wthfeng.hfmusic.model.view.ViewHotForm;
import top.wthfeng.hfmusic.service.home.HomeService;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/4/20 22:41
 * @email wthfeng@126.com
 */
@Service("homeService")
public class HomeServiceImpl implements HomeService {

    @Override
    public List<ViewHotForm> HotForm() {
        return null;
    }

    @Override
    public List<ViewHomeMusic> monthlyHot() {
        return null;
    }

    @Override
    public List<ViewHomeMusic> monthlyNew() {
        return null;
    }
}
