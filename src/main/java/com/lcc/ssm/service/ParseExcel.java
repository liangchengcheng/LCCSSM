package com.lcc.ssm.service;

import com.lcc.ssm.entity.GoodDetails;

import java.io.File;
import java.util.List;

/**
 * Created by liangchengcheng on 2017/6/12.
 */
public interface ParseExcel {
    List<GoodDetails> parseExcel(File xlsFile, String filename);
}
