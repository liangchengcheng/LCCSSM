package com.lcc.ssm.serviceimpl;

import com.lcc.ssm.dao.GoodDetailsDao;
import com.lcc.ssm.dao.LuceneDao;
import com.lcc.ssm.entity.GoodDetails;
import com.lcc.ssm.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liangchengcheng on 2017/6/12.
 */
@Service
public class GoodServiceImpl implements GoodService {
    @Autowired
    private GoodDetailsDao goodDetailsDao;

    @Autowired
    private LuceneDao luceneDao;

    @Override
    public List<GoodDetails> findGoodByClassifyName(String ClassifyName) throws Exception {
        return null;
    }

    @Override
    public List<GoodDetails> findIndex(String keyword, int start, int row) {
        List<GoodDetails> goodDetailsList;
        try{
            long start2 = System.nanoTime();
            goodDetailsList = luceneDao.findIndex(keyword,start,row);
            long time = System.nanoTime() - start2;
            //这个time是 测试的耗时时间
            return goodDetailsList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GoodDetails findGoodAllDetailsById(String realGoodid) {
        GoodDetails goodDetails = goodDetailsDao.findGoodAllDetailsByDetailId(realGoodid);
        return goodDetails;
    }

    @Override
    public List<GoodDetails> getGoodList(String location) {
        List<GoodDetails> goodList= goodDetailsDao.findGoods(location);
        System.out.println(goodList.toString());
        return goodList;
    }

    @Override
    public List<Integer> methodOfWarn(List<GoodDetails> goodDetailsList) throws Exception {
        return null;
    }
}
