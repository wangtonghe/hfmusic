package com.wthfeng.hfmusic.service.impl.singer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wthfeng.hfmusic.dao.singer.SingerDAO;
import com.wthfeng.hfmusic.model.param.SingerCollectParam;
import com.wthfeng.hfmusic.model.param.SingerParam;
import com.wthfeng.hfmusic.model.view.ViewPageList;
import com.wthfeng.hfmusic.model.view.ViewSinger;
import com.wthfeng.hfmusic.model.view.ViewSingerMusic;
import com.wthfeng.hfmusic.service.singer.SingerService;
import com.wthfeng.hfmusic.util.NumberUtil;

import java.util.List;
import java.util.Map;

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

    @Override
    public ViewSingerMusic getMusicTop50(Map<String,Integer> param ) {
        return singerDAO.getMusicTop50(param);
    }

    @Override
    public void collect(SingerCollectParam param) {
        if(param.getFlag()==1){
            singerDAO.collect(param);
        }else{
            singerDAO.cancelCollect(param);
        }

    }

    @Override
    public List<ViewSinger> getByName(String key) {
        return singerDAO.getByName(key);
    }
}
