package com.yyt.print.rpc.client.product;

import com.yyt.print.product.pojo.MallProductCategory;
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
}