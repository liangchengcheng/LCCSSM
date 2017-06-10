package com.lcc.ssm.dao;

import com.lcc.ssm.entity.Gag;

import java.util.List;

/**
 * Created by liangchengcheng on 2017/6/10.
 */
public interface GagDao {
    public int insertGag(Gag gag);
    List<Gag> findByUserId(Long id);
}
