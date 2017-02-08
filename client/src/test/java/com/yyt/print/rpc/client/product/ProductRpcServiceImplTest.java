package com.yyt.print.rpc.client.product;

import com.youguu.core.pojo.Response;
import com.yyt.print.product.pojo.MallProductCategory;
import com.yyt.print.product.pojo.MallProductCategoryPro;
import com.yyt.print.product.pojo.MallProductCategoryProValue;
import com.yyt.print.rpc.client.YytRpcClientFactory;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ProductRpcServiceImplTest {

    IProductRpcService productRpcService = YytRpcClientFactory.getProductRpcService();

    @Test
    public void testSaveMallProductCategory() throws Exception {
        MallProductCategory category = new MallProductCategory();
        category.setId(1);
        category.setName("油墨");
        category.setLogo("");
        category.setIsEnd(1);
        category.setDes("油墨类");
        category.setCreateTime(new Date());
        category.setParentId(-1);
        category.setRank(1);
        category.setUpdateTime(new Date());

        productRpcService.saveMallProductCategory(category);
    }

    @Test
    public void testUpdateMallProductCategory() throws Exception {

    }

    @Test
    public void testDeleteMallProductCategory() throws Exception {

    }

    @Test
    public void testGetMallProductCategory() throws Exception {
        MallProductCategory category = productRpcService.getMallProductCategory(1);
        System.out.println(category.getName());
    }



    @Test
    public void testQueryAllMallProductCategory() throws Exception {

    }

    @Test
    public void testFindMallProductCategoryList() throws Exception {
        List<MallProductCategory> list = productRpcService.findMallProductCategoryList(-1);
        System.out.println(list.size());
    }

    private MallProductCategoryPro getBean(){
        MallProductCategoryPro pro = new MallProductCategoryPro();
        pro.setClassId(1);
        pro.setCreateTime(new Date());
        pro.setIsNeed(0);
        pro.setIsSearch(0);
        pro.setName("颜色");
        pro.setType(1);
        pro.setRank(1);
        pro.setUpdateTime(new Date());
        return pro;
    }

    void testFindProByClassId(){
        List<MallProductCategoryPro> list =  productRpcService.findProByClassId(1);
        System.out.println(list);
    }

//    /**
//     * 通过分类属性id查询分类属性值
//     * @param proId
//     * @return
//     */
//    List<MallProductCategoryProValue> findProValueByProId(int proId);
//
//    /**
//     * 增加分类属性
//     * @param pro
//     * @return
//     */
//    int addPro(MallProductCategoryPro pro);
//
//    /**
//     * 增加分类属性值
//     * @param values
//     * @return
//     */
//    int addProValue(List<MallProductCategoryProValue> values);
//
//    /**
//     * 修改分类属性
//     * @param pro
//     * @return
//     */
//    int modifyPro(MallProductCategoryPro pro);
//
//    /**
//     * 修改分类属性值
//     * @param value
//     * @return
//     */
//    int modifyProValue(MallProductCategoryProValue value);
//
//    /**
//     * 批量删除分类属性
//     * @param list
//     * @return
//     */
//    Response<String> delPros(List<Integer> list);
//
//    /**
//     * 批量删除分类属性值
//     * @param list
//     * @return
//     */
//    Response<String> delProValues(List<Integer> list);


}