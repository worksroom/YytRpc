package com.yyt.print.rpc.client.product;

import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.*;
import com.yyt.print.product.query.MallGoodsQuery;
import com.yyt.print.product.query.UserShopQuery;
import com.yyt.print.rpc.client.YytRpcClientFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Test
    public void testFindProByClassId(){
        List<MallProductCategoryPro> list =  productRpcService.findProByClassId(1);
        System.out.println(list);
    }

//    /**
//     * 通过分类属性id查询分类属性值
//     * @param proId
//     * @return
//     */
    @Test
    public void  findProValueByProId(){
        List<MallProductCategoryProValue> list = productRpcService.findProValueByProId(1);
        System.out.println(list);
    }
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

      @Test
      public void findMallGoods(){
          MallGoodsQuery query = new MallGoodsQuery();
          query.setName("裤子1");
          PageHolder<MallGoods> list = productRpcService.findMallGoods(query);
          System.out.println(list.size());
      }

    @Test
    public void reviewMallGoods(){
        productRpcService.reviewMallGoods(1,true);
    }

    @Test
    public void findUserShops(){
        UserShopQuery query = new UserShopQuery();
        query.setName("他的小店");
        PageHolder<UserShop> list = productRpcService.findUserShops(query);
        System.out.println(list.size());
    }

    @Test
    public void reviewUserShop(){
        productRpcService.reviewUserShop(1,true);
    }

    @Test
    public void addMallIndex(){
        MallIndex index = new MallIndex();
        index.setName("第一排");
        index.setType(0);
        index.setRank(1);
        index.setStatus(0);

        List<MallIndexContent> list = new ArrayList<>();
        MallIndexContent content = new MallIndexContent();
        content.setName("油桶");
        content.setImg("http://www.youguu.com/cms/attached/image/20170213/sp/20170213121338_2.jpg");
        list.add(content);
        productRpcService.addMallIndex(index,list);

    }

    @Test
    public void updateMallIndex(){
        MallIndex index = new MallIndex();
        index.setName("第2排");
        index.setType(0);
        index.setRank(1);
        index.setStatus(0);
        index.setId(1);

        List<MallIndexContent> list = new ArrayList<>();
        MallIndexContent content = new MallIndexContent();
        content.setName("纸张");
        content.setImg("http://www.youguu.com/cms/attached/image/20170213/sp/20170213121338_2.jpg");

        list.add(content);

        content = new MallIndexContent();
        content.setName("墨水");
        content.setImg("http://www.youguu.com/cms/attached/image/20170213/sp/20170213121338_2.jpg");
        list.add(content);

        productRpcService.updateMallIndex(index,list);
    }

    @Test
    public void updateStatus(){
        productRpcService.updateStatus(1,true);
    }

    @Test
    public void queryMallIndex(){
        PageHolder<MallIndex> list = productRpcService.queryMallIndex(-1,1,10);
        System.out.println(list.size());
    }

    @Test
    public void queryUserMallIndex(){
        List<MallIndex> list = productRpcService.queryUserMallIndex();
        System.out.println(list.get(0).transContent());
    }

    @Test
    public void getMallIndex(){
        System.out.println(productRpcService.getMallIndex(1));
    }

    private MallGoods getMallGoods(){
        MallGoods good = new MallGoods();
        good.setName("墨水");
        good.setShopId(1);
        good.setShopName("leo小店");
        good.setCreateTime(new Date());
        good.setClassId(1);
        good.setDes("墨水");
        good.setStatus(0);
        good.setUpdateTime(new Date());
        return good;
    }
    private List<MallProductExt> getMallProductExts(){
        List<MallProductExt> list = new ArrayList<>();
        MallProductExt mpe = new MallProductExt();
        mpe.setType(0);
        mpe.setThridId(2);
        list.add(mpe);

        mpe = new MallProductExt();
        mpe.setType(1);
        mpe.setThridId(2);
        list.add(mpe);
        return list;
    }
    private MallProductSet getMallProductSet(){
        MallProductSet set = new MallProductSet();
        MallProduct product = new MallProduct();
        product.setName("黑色墨水");
        product.setPrice(128.00);
        product.setSalePrice(128.00);

        List<MallProductSalePro> list = new ArrayList<>();
        MallProductSalePro pro = new MallProductSalePro();
        pro.setClassProId(1);
        pro.setClassProValueId(1);
        list.add(pro);

        pro = new MallProductSalePro();
        pro.setClassProId(1);
        pro.setClassProValueId(2);
        list.add(pro);

        pro = new MallProductSalePro();
        pro.setClassProId(1);
        pro.setClassProValueId(3);
        list.add(pro);

        pro = new MallProductSalePro();
        pro.setClassProId(1);
        pro.setClassProValueId(4);
        list.add(pro);

        set.setMallProduct(product);
        set.setSalePro(list);
        return set;
    }

    @Test
    public void shelves(){
        List<MallProductSet> list = new ArrayList<>();
        list.add(getMallProductSet());
        productRpcService.shelves(getMallGoods(),list,getMallProductExts());
    }

    @Test
    public void goodAddProduct(){
        List<MallProductSet> list = new ArrayList<>();
        list.add(getMallProductSet());
        productRpcService.goodAddProduct(10,list,getMallProductExts());
    }

    @Test
    public void getMallGoodsSetByGood(){
        MallGoodsSet set = productRpcService.getMallGoodsSetByGood(10);
        System.out.println(set);
    }

    @Test
    public void getMallGoodsSetByProduct(){
        MallGoodsSet set = productRpcService.getMallGoodsSetByProduct(4);
        System.out.println(set);

    }

    private ProductEvaluateRecord getProductEvaluateRecord(){
        ProductEvaluateRecord record = new ProductEvaluateRecord();
        record.setGoodsId(1);
        record.setBuyUserId(224);
        record.setContent("不错呀");
        record.setDes("tinghao");
        record.setOrderId("099018981");
        record.setStar(5);
        record.setSellUserId(23);
        return record;
    }

    @Test
    public void commentGoods(){
        productRpcService.commentGoods(getProductEvaluateRecord());
    }

    @Test
    public void findProductEvaluateList(){
        System.out.println(productRpcService.findProductEvaluateList(1,1000,10));
    }

    private ShopUser getShopUser(){
        ShopUser su = new ShopUser();
        su.setUserId(6);
        su.setShopId(1);
        su.setType(2);
        return su;
    }

    @Test
    public void addShopUser(){
        productRpcService.addShopUser(getShopUser());
    }

    @Test
    public void getShopIdFromUid(){
        System.out.println(productRpcService.getShopIdFromUid(2));
    }

    @Test
    public void getCreateShopUid(){
        System.out.println(productRpcService.getCreateShopUid(1));
    }

    @Test
    public void findShopUids(){
        System.out.println(productRpcService.findShopUids(1));
    }

}