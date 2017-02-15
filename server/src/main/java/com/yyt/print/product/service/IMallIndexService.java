package com.yyt.print.product.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.MallIndex;
import com.yyt.print.product.pojo.MallIndexContent;

import java.util.List;

/**
 * Created by lenovo on 2017/2/13.
 */
public interface IMallIndexService {
    /**
     * 添加碎片
     * @param index
     * @param content
     * @return
     */
    int addMallIndex(MallIndex index,List<MallIndexContent> content);

    /**
     * 修改碎片
     * @param index
     * @param content
     * @return
     */
    int updateMallIndex(MallIndex index,List<MallIndexContent> content);

    /**
     *  修改状态
     * @param id
     * @param status
     * @return
     */
    int updateStatus(int id,boolean status);


    /**
     * 获取首页碎片
     * @param id
     * @return
     */
    MallIndex getMallIndex(int id);

    /**
     * 管理平台使用
     * @param status
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageHolder<MallIndex> queryMallIndex(int status,int pageIndex,int pageSize);

    /**
     * 前端使用
     * @return
     */
    List<MallIndex> queryUserMallIndex();


}
