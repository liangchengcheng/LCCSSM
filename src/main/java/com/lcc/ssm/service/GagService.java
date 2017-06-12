package com.lcc.ssm.service;

import com.lcc.ssm.entity.Gag;

import java.util.List;

/**
 * Created by liangchengcheng on 2017/6/12.
 */
public interface GagService {
    int insertGag(Gag gag);

    List<Gag> findByUserId(Long id);
}
