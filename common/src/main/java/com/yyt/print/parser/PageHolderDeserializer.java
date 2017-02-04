package com.yyt.print.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.youguu.core.util.PageHolder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class PageHolderDeserializer implements ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object fieldName) {
        PageHolder pageHolder = new PageHolder<>();

        //如果是泛型参数的类型
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Class genericClazz = (Class) pt.getActualTypeArguments()[0]; //得到泛型里的class类型对象。

            JSONObject jsonObject = parser.parseObject();

            pageHolder.setPageIndex(jsonObject.getIntValue("pageIndex"));
            pageHolder.setPageSize(jsonObject.getIntValue("pageSize"));
            pageHolder.setTotalCount(jsonObject.getIntValue("totalCount"));
            pageHolder.setCode(jsonObject.getString("code"));
            String str = jsonObject.getString("list");
            List listData = JSONArray.parseArray(str, genericClazz);
            pageHolder.addAll(listData);
        }

        return (T) pageHolder;
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }
}