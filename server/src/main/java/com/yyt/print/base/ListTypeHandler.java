package com.yyt.print.base;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.yyt.print.fragment.pojo.FragmentContent;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.List;


public class ListTypeHandler extends BaseTypeHandler<List<FragmentContent>> {
    private static final String DEFAULT_CHARSET = "utf-8";

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<FragmentContent> parameter, JdbcType jdbcType) throws SQLException {

        if (parameter != null && parameter.size() > 0) {
            String json = JSONObject.toJSONString(parameter);
            ByteArrayInputStream bis;
            try {
                bis = new ByteArrayInputStream(json.getBytes(DEFAULT_CHARSET));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("Blob Encoding Error!");
            }
            ps.setBinaryStream(i, bis, json.length());
        }

    }

    @Override
    public List<FragmentContent> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        Blob blob = rs.getBlob(columnName);
        byte[] returnValue = null;
        String result = null;
        if (null != blob) {
            returnValue = blob.getBytes(1, (int) blob.length());
        }
        try {
            if (null != returnValue) {
                result = new String(returnValue, DEFAULT_CHARSET);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Blob Encoding Error!");
        }

        if(result!=null && !"".equals(result.trim())){
            return JSONObject.parseObject(result, new TypeReference<List<FragmentContent>>(){});
        }
        return null;
    }

    @Override
    public List<FragmentContent> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String result = null;
        Blob blob = rs.getBlob(columnIndex);
        byte[] returnValue = null;
        if (null != blob) {
            returnValue = blob.getBytes(1, (int) blob.length());
        }
        try {
            if (null != returnValue) {
                result = new String(returnValue, DEFAULT_CHARSET);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Blob Encoding Error!");
        }
        if(result!=null && !"".equals(result.trim())){
            return JSONObject.parseObject(result, new TypeReference<List<FragmentContent>>(){});
        }
        return null;
    }

    @Override
    public List<FragmentContent> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        Blob blob = cs.getBlob(columnIndex);
        byte[] returnValue = null;
        String result = null;
        if (null != blob) {
            returnValue = blob.getBytes(1, (int) blob.length());
        }
        try {
            if (null != returnValue) {
                result = new String(returnValue, DEFAULT_CHARSET);
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Blob Encoding Error!");
        }
        if(result!=null && !"".equals(result.trim())){
            return JSONObject.parseObject(result, new TypeReference<List<FragmentContent>>(){});
        }
        return null;
    }
}
