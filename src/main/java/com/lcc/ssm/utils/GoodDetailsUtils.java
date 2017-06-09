package com.lcc.ssm.utils;

import com.lcc.ssm.entity.GoodDetails;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;

/**
 * Created by liangchengcheng on 2017/6/9.
 */
public class GoodDetailsUtils {

    /*
     * 将GoodDetails 转换成document 将GoodDetails 的值设置到document里面去...
     */
    public static Document GoodDetailsToDocument(GoodDetails goodDetails){
        Document document = new Document();
        StringField idField = new StringField("id",goodDetails.getGoodId(), Field.Store.YES);
        TextField goodNameField = new TextField("goodName", goodDetails.getGoodName(), Field.Store.YES);
        document.add(idField);
        document.add(goodNameField);

        return document;
    }
}
