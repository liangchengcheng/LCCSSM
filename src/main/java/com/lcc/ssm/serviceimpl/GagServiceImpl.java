package com.lcc.ssm.serviceimpl;

import com.lcc.ssm.dao.GagDao;
import com.lcc.ssm.entity.Gag;
import com.lcc.ssm.service.GagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liangchengcheng on 2017/6/12.
 */
@Service
public class GagServiceImpl implements GagService{

    @Autowired
    private GagDao gagDao;

    @Override
    public int insertGag(Gag gag) {
        int t = gagDao.insertGag(gag);
        return t;
    }

    @Override
    public List<Gag> findByUserId(Long id) {
        List<Gag> gagList =gagDao.findByUserId(id);
        return gagList;
    }
}
