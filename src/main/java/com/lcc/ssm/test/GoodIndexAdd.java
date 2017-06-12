package com.lcc.ssm.test;

import com.lcc.ssm.dao.GoodClassifyDao;
import com.lcc.ssm.dao.LuceneDao;
import com.lcc.ssm.entity.GoodDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by liangchengcheng on 2017/6/12.
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用Springtest测试框架
@ContextConfiguration("/spring/spring-*.xml") // 加载配置
public class GoodIndexAdd {

    private LuceneDao luceneDao = new LuceneDao();

    @Autowired
    private GoodClassifyDao goodClassifyDao;

    @Test
    public void addIndexForAll()throws Exception{
        /**
         * 8-62：商品种类ID的起始Commodity_classification
         * 建立你的商品种类索引，原因我只伪造了两个商品种类假数据，就是id=15和16的商品，所以我们只建立对他的索引咯
         * */
        for (int i = 15;i<=16;i++){
            List<GoodDetails> list = goodClassifyDao.findGoodDetailsByClassifyID(i);
            for (int index = 0; index < list.size(); index++) {
                luceneDao.addIndex(list.get(index));
                System.out.println(list.get(index).toString());
            }
        }
    }
}
