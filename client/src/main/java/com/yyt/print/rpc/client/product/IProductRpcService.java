package com.yyt.print.rpc.client.product;

import com.yyt.print.product.pojo.CategoryPro;
import com.yyt.print.product.pojo.MallProductCategory;
import com.yyt.print.product.pojo.MallProductCategoryPro;
import com.yyt.print.product.pojo.MallProductCategoryProValue;

import java.util.List;

/**
 * Created by lenovo on 2016/12/29.
 */
public interface IProductRpcService {
    /**
     * 新建商品类别
     * @param category
     * @return
     */
    public int saveMallProductCategory(MallProductCategory category);

    /**
     * 修改商品类别
     * @param category
     * @return
     */
    public int updateMallProductCategory(MallProductCategory category);

    /**
     * 删除商品类别
     * @param id 类别ID
     * @return
     */
    public int deleteMallProductCategory(int id);

    /**
     * 查询商品类别
     * @param id
     * @return
     */
    public MallProductCategory getMallProductCategory(int id);

    /**
     * 获取全部分类
     * @return
     */
    public List<MallProductCategory> queryAllMallProductCategory();

    /**
     * 查询父分类下的子分类列表
     * @param parentId 父节点ID
     * @return
     */
    public List<MallProductCategory> findMallProductCategoryList(int parentId);


    /**
     * 通过分类id查询分类属性和值
     * @param classId
     * @return
     */
    List<CategoryPro> findProValueByClassId(int classId);

    /**
     * 添加属性和属性值
     * @param classId
     * @param pro
     * @param values
     * @return
     */
    int addProAndValues(int classId,MallProductCategoryPro pro,List<MallProductCategoryProValue> values);
}
