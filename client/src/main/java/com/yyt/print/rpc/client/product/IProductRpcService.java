package com.yyt.print.rpc.client.product;

import com.youguu.core.pojo.Response;
import com.youguu.core.util.PageHolder;
import com.yyt.print.product.pojo.*;
import com.yyt.print.product.query.MallGoodsQuery;
import com.yyt.print.product.query.UserShopQuery;

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

    /**
     * 通过分类id查询分类属性
     * @param classId
     * @return
     */
    List<MallProductCategoryPro> findProByClassId(int classId);

    /**
     * 通过分类属性id查询分类属性值
     * @param proId
     * @return
     */
    List<MallProductCategoryProValue> findProValueByProId(int proId);

    /**
     * 增加分类属性
     * @param pro
     * @return
     */
    int addPro(MallProductCategoryPro pro);

    /**
     * 增加分类属性值
     * @param values
     * @return
     */
    int addProValue(List<MallProductCategoryProValue> values);

    /**
     * 修改分类属性
     * @param pro
     * @return
     */
    int modifyPro(MallProductCategoryPro pro);

    /**
     * 修改分类属性值
     * @param value
     * @return
     */
    int modifyProValue(MallProductCategoryProValue value);

    /**
     * 批量删除分类属性
     * @param list
     * @return
     */
    Response<String> delPros(List<Integer> list);

    /**
     * 批量删除分类属性值
     * @param list
     * @return
     */
    Response<String> delProValues(List<Integer> list);

    /**
     * 查询未审核的货品
     * @param query -1 代表查询全部
     * @return
     */
    PageHolder<MallGoods> findMallGoods(MallGoodsQuery query);

    /**
     * 审核货品
     * @param status
     * @return
     */
    int reviewMallGoods(int id,boolean status);


    /**
     * 查询未审核的货品
     * @param query -1 代表查询全部
     * @return
     */
    PageHolder<UserShop> findUserShops(UserShopQuery query);

    /**
     * 审核货品
     * @param status
     * @return
     */
    int reviewUserShop(int id, boolean status);


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


    /**
     * 上架货品 ，
     * @param sets
     * @return
     */
    int shelves(MallGoodsSet sets);


    /**
     * 为货品增加新的商品
     * @param sets
     * @return
     */
    int goodAddProduct(MallGoodsSet sets);

    /**
     * 获取货品明细
     * @param goodsId
     * @return
     */
    MallGoodsSet getMallGoodsSetByGood(int goodsId);

    /**
     * 获取货品明细
     * @param productId
     * @return
     */
    MallGoodsSet getMallGoodsSetByProduct(int productId);


    /**
     * 添加库存为止
     * @param storeLocation
     * @return
     */
    int saveStoreLocation(StoreLocation storeLocation);

    /**
     * 获取库存位置
     * @param id
     * @return
     */
    StoreLocation getStoreLocation(int id);

    /**
     * 删除库存位置
     * @param id
     * @return
     */
    int delStoreLocation(int id);

    /**
     * 修改库存位置
     * @param storeLocation
     * @return
     */
    int updateStoreLocation(StoreLocation storeLocation);

    /**
     * 查询商铺的所有库存位置
     * @param shopId
     * @return
     */
    List<StoreLocation> findStoreLocations(int shopId);


    //=====================运费模板=============================
    int saveFareMould(FareMould fareMould);

    FareMould getFareMould(int id);

    int updateFareMould(FareMould fareMould);

    int delFareMould(int id);

    List<FareMould> findFareMoulds(int shopId);


    /**
     * 增加一条评论
     * @return
     */
    int commentGoods(ProductEvaluateRecord pvr);

    /**
     * 查询货品的评论
     * @param goodIds
     * @param seq
     * @param num
     * @return
     */
    List<ProductEvaluateRecord> findProductEvaluateList(int goodIds,int seq,int num);


    /**
     * 店铺设置用户
     * @param shopUser
     * @return
     */
    int addShopUser(ShopUser shopUser);

    /**
     * 获取用户的店铺id
     * @param uid
     * @return
     */
    ShopUser getShopIdFromUid(int uid);

    /**
     * 获取店铺的创建者
     * @param shopId
     * @return
     */
    ShopUser getCreateShopUid(int shopId);

    /**
     * 获取店铺的所有员工
     * @param shopId
     * @return
     */
    List<ShopUser> findShopUids(int shopId);

}
