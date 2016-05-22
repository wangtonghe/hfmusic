package top.wthfeng.hfmusic.service.impl.mine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.hfmusic.dao.mine.MineDAO;
import top.wthfeng.hfmusic.model.view.ViewMyForm;
import top.wthfeng.hfmusic.model.view.ViewSinger;
import top.wthfeng.hfmusic.service.mine.MineService;

import java.util.List;

/**
 * @author wangtonghe
 * @date 2016/5/15 17:30
 * @email wthfeng@126.com
 */
@Service("mineService")
public class MineServiceImpl implements MineService {

    @Autowired
    private MineDAO mineDAO;

    @Override
    public List<ViewMyForm> getMyForm(int userId)throws Exception {
        return mineDAO.getMyForm(userId);
    }

    @Override
    public List<ViewMyForm> getCollectForm(int userId)throws Exception {
        return mineDAO.getCollectForm(userId);
    }

    @Override
    public List<ViewSinger> getCollectSinger(int userId)throws Exception {
        return mineDAO.getCollectSinger(userId);
    }
}
