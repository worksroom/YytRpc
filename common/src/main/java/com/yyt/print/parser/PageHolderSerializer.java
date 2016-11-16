package com.yyt.print.parser;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.youguu.core.util.PageHolder;

import java.io.IOException;
import java.lang.reflect.Type;

public class PageHolderSerializer implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.getWriter();
        if (object == null) {
            serializer.getWriter().writeNull();
            return;
        }
        PageHolder pageHolder = (PageHolder)object;
        JSONObject ob = new JSONObject();
        ob.put("pageSize", pageHolder.getPageSize());
        ob.put("pageIndex", pageHolder.getPageIndex());
        ob.put("totalCount", pageHolder.getTotalCount());
        ob.put("code", pageHolder.getCode());
        ob.put("list", pageHolder.getList());

        out.write(ob.toJSONString());
    }
}