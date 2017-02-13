package com.yyt.print.product.dao;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.MallIndex;

import java.util.List;

/**
 * Created by lenovo on 2017/2/13.
 */
public interface IMallIndexDAO {

    int saveMallIndex(MallIndex index);

    int updateMallIndex(MallIndex index);

    int updateStatus(int id,boolean isUsed);

    /**
     * 管理平台使用
     * status < 0 查询全部
     * @param status
     * @return
     */
    PageHolder<MallIndex> queryMallIndex(int status,int pageIndex,int pageSize);

    /**
     * 前端使用
     * @return
     */
    List<MallIndex> queryUserMallIndex();
}
