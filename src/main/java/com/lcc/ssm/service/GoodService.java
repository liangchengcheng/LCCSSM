package com.lcc.ssm.service;

import com.lcc.ssm.entity.GoodDetails;

import java.util.List;

/**
 * Created by liangchengcheng on 2017/6/12.
 */
public interface GoodService {

    List<GoodDetails> findGoodByClassifyName(String ClassifyName) throws Exception;

    List<GoodDetails> findIndex(String keyword, int start, int row);

    GoodDetails findGoodAllDetailsById(String realGoodid);

    List<GoodDetails> getGoodList(String location);

    List<Integer> methodOfWarn(List<GoodDetails> goodDetailsList) throws Exception;
}
