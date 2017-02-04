package com.yyt.print.product.service;

import com.yyt.print.product.pojo.MallProductSalePro;

import java.util.List;

/**
 * Created by leo on 2016/11/24.
 */
public interface IMallProductSaleProService {

    /**
     * 新建商品销售属性
     * @param productSalePro
     * @return
     */
    public int saveMallProductSalePro(MallProductSalePro productSalePro);

    /**
     * 修改商品销售属性
     * @param productSalePro
     * @return
     */
    public int updateMallProductSalePro(MallProductSalePro productSalePro);

    /**
     * 删除商品销售属性
     * @param id
     * @return
     */
    public int deleteMallProductSalePro(int id);

    /**
     * 查询商品销售属性
     * @param id
     * @return
     */
    public int getMallProductSalePro(int id);

    /**
     * 根据商品ID查询
     * @param productId 商品ID
     * @return
     */
    public List<MallProductSalePro> findMallProductSalePro(int productId);
}
