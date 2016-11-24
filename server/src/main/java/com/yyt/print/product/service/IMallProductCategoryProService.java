package com.yyt.print.product.service;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.MallProductCategoryPro;

import java.util.List;

/**
 * Created by leo on 2016/11/23.
 */
public interface IMallProductCategoryProService {

    /**
     * 新建分类属性
     * @param categoryPro
     * @return
     */
    public int saveMallProductCategoryPro(MallProductCategoryPro categoryPro);

    /**
     * 修改分类属性
     * @param categoryPro
     * @return
     */
    public int updateMallProductCategoryPro(MallProductCategoryPro categoryPro);

    /**
     * 删除分类属性
     * @param id
     * @return
     */
    public int deleteMallProductCategoryPro(int id);

    /**
     * 查询分类属性
     * @param id
     * @return
     */
    public MallProductCategoryPro getMallProductCategoryPro(int id);

    /**
     * 分页查询，仅限管理后台调用此接口
     * @param classId 分类ID
     * @param type 类型
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public PageHolder<MallProductCategoryPro> queryMallProductCategoryPro(int classId, int type, int pageIndex, int pageSize);

    /**
     * 根据分类ID查询分类属性
     * @param classId
     * @return
     */
    public List<MallProductCategoryPro> findMallProductCategoryPro(int classId);
}
