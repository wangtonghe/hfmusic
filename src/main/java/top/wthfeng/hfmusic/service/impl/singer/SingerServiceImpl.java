package top.wthfeng.hfmusic.service.impl.singer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wthfeng.hfmusic.dao.home.HomeDAO;
import top.wthfeng.hfmusic.dao.singer.SingerDAO;
import top.wthfeng.hfmusic.model.param.SingerParam;
import top.wthfeng.hfmusic.model.view.ViewPageList;
import top.wthfeng.hfmusic.model.view.ViewSinger;
import top.wthfeng.hfmusic.service.singer.SingerService;
import top.wthfeng.hfmusic.util.NumberUtil;

/**
 * @author wangtonghe
 * @date 2016/5/15 16:02
 * @email wthfeng@126.com
 */
@Service("singerService")
public class SingerServiceImpl implements SingerService {
    private static final int HOT_SINGER_NUM=12;

    @Autowired
    private SingerDAO singerDAO;



    @Override
    public ViewPageList<ViewSinger> getSingerByArea(SingerParam param) throws Exception{
        ViewPageList<ViewSinger> data = new ViewPageList<>();
        data.setList(singerDAO.getSingerByArea(param));
        data.setTotalPageNum(NumberUtil.getPageNum(singerDAO.getSingerByAreaNum(param),param.getPageSize()));
        return data;
    }

    @Override
    public ViewPageList<ViewSinger> getSingerByChar(SingerParam param)throws Exception {
        ViewPageList<ViewSinger> data = new ViewPageList<>();
        if(param.getCharacter().equals("热门")){
            data.setList(singerDAO.getSingerHot(HOT_SINGER_NUM));
            data.setTotalPageNum(HOT_SINGER_NUM);
            return data;
        }
        data.setList(singerDAO.getSingerByChar(param));
        data.setTotalPageNum(NumberUtil.getPageNum(singerDAO.getSingerByCharNum(param),param.getPageSize()));
        return data;

    }
}
