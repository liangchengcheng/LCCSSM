package com.lcc.ssm.entity;

import java.io.Serializable;

/**
 * Created by liangchengcheng on 2017/6/8.
 */
public class GoodClassify implements Serializable {
    private Integer classifyId;
    private String goodkindsName;
    private Integer upperID;
    private String upperName;
    private String description;

    //商品信息

    public GoodClassify() {

    }

    public GoodClassify(Integer classifyId, String goodkindsName,
                        Integer upperID, String upperName, String description) {
        super();
        this.classifyId = classifyId;
        this.goodkindsName = goodkindsName;
        this.upperID = upperID;
        this.upperName = upperName;
        this.description = description;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getGoodkindsName() {
        return goodkindsName;
    }

    public void setGoodkindsName(String goodkindsName) {
        this.goodkindsName = goodkindsName;
    }

    public Integer getUpperID() {
        return upperID;
    }

    public void setUpperID(Integer upperID) {
        this.upperID = upperID;
    }

    public String getUpperName() {
        return upperName;
    }

    public void setUpperName(String upperName) {
        this.upperName = upperName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
