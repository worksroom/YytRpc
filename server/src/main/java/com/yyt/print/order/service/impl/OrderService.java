package com.yyt.print.order.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youguu.core.util.PageHolder;
import com.yyt.print.order.dao.*;
import com.yyt.print.order.front.OrderProductFront;
import com.yyt.print.order.front.OrderProductPojo;
import com.yyt.print.order.pojo.*;
import com.yyt.print.order.query.OrdersQuery;
import com.yyt.print.order.service.IOrderService;
import com.yyt.print.order.util.OrderUtil;
import com.yyt.print.product.dao.IFareMouldDAO;
import com.yyt.print.product.dao.IMallGoodsDAO;
import com.yyt.print.product.dao.IMallProductDAO;
import com.yyt.print.product.dao.IUserShopDAO;
import com.yyt.print.product.pojo.*;
import com.yyt.print.product.service.IMallProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by leo on 2016/11/21.
 */
@Service("orderService")
public class OrderService implements IOrderService {

    @Resource
    private IOrderAddrDAO orderAddrDAO;

    @Resource
    private IMallProductDAO productDAO;

    @Resource
    private IMallGoodsDAO mallGoodsDAO;

    @Resource
    private IShoppingCartDAO shoppingCartDAO;

    @Resource
    private IMallProductService mallProductService;

    @Resource
    private IFareMouldDAO fareMouldDAO;

    @Resource
    private IOrdersDAO ordersDAO;

    @Resource
    private IPayOrdersDAO payOrdersDAO;

    @Resource
    private IOrderExpressDAO orderExpressDAO;

    @Resource
    private ICollectShopDAO collectShopDAO;

    @Resource
    private IUserShopDAO userShopDAO;

    @Resource
    private ICollectTreasureDAO collectTreasureDAO;




    @Transactional
    @Override
    public PayOrders makeOrder(int buyUserId,int addrId,List<OrderProductFront> product,JSONObject ext) {
        PayOrders po = PayOrders.getByIds();
        JSONArray ja = new JSONArray();

        //key为店铺的id list 为这个店铺下的商品
        Map<Integer,List<OrderProductFront>> map = this.resetData(product);
        NumberFormat df = new DecimalFormat("###0.000");
        //货品临时缓存
        Map<Integer,MallGoods> goodsCache = new HashMap<>();
        for(Map.Entry<Integer,List<OrderProductFront>> entry:map.entrySet()){
            Orders order = new Orders(buyUserId);
            double p_money = 0;
            double p_fee = 0;
            List<OrderProductPojo> pojos = new ArrayList<>();
            for(OrderProductFront opf:entry.getValue()){
                MallProductSet set = mallProductService.getMallProductSet(opf.getProductId());
                FareMould fm = mallProductService.getFromGoodsId(set.getMallProduct().getGoodsId());
                MallGoods goods = this.getMallGoodsCache(goodsCache,set.getMallProduct().getGoodsId());
                double temp_money = OrderUtil.getProductMoney(set.getMallProduct(),opf.getNum());
                double temp_fee = OrderUtil.getFreightMoney(fm,opf.getNum());
                p_money += temp_money;
                p_fee += temp_fee;

                //组织 - ProductDesc
                OrderProductPojo pojo = new OrderProductPojo();
                //TODO
                pojo.setProduct_pro_value("红色;大的");
                pojo.setFee(df.format(temp_fee));
                pojo.setPrice(df.format(temp_money));
                pojo.setNum(opf.getNum());
                pojo.setProduct_name(goods.getName());
                pojo.setProduct_img(goods.getImg());
                pojos.add(pojo);
            }
            order.setProductMoney(p_money);
            order.setFee(p_fee);
            order.setTotalMoney(p_money + p_fee);
            order.setShopId(entry.getKey());
            order.setAddressId(addrId);
            order.setProductDesc(JSON.toJSONString(pojos));
            ordersDAO.saveOrders(order);
            ja.add(order.getId());
        }
        po.setOrderIdSet(ja.toJSONString());
        payOrdersDAO.savePayOrders(po);
        return po;
    }

    private MallGoods getMallGoodsCache(Map<Integer,MallGoods> goodsCache,int goodsId){
        MallGoods goods = goodsCache.get(goodsId);
        if(goods==null){
            goods = mallGoodsDAO.getMallGoods(goodsId);
            goodsCache.put(goodsId,goods);
        }
        return goods;
    }
    private Map<Integer,List<OrderProductFront>> resetData(List<OrderProductFront> product){
        Map<Integer,List<OrderProductFront>> map = new HashMap<>();
        for(OrderProductFront opf:product){
            List<OrderProductFront> list = map.get(opf.getShopId());
            if(list==null){
                list = new ArrayList<>();
                map.put(opf.getShopId(),list);
            }
            list.add(opf);
        }
        return map;
    }

    @Override
    public PageHolder<Orders> findOrders(OrdersQuery query) {
        return ordersDAO.findOrders(query);
    }

    @Override
    public int updateOrderPrice(String id, double price) {
        Orders orders = ordersDAO.getOrders(id);
        if(orders.getStatus()!=0){
            return -99;
        }else{
            return ordersDAO.updateMoney(id, price);
        }

    }

    @Transactional
    @Override
    public int confirmExpress(String orderId, int expressCom, String expressNum) {
        Orders orders = ordersDAO.getOrders(orderId);
        if(orders.getStatus()!=1){
            return -99;
        }else{
            ordersDAO.updateExpress(orderId);

            OrderExpress orderExpress = new OrderExpress();
            orderExpress.setOrderId(orderId);
            orderExpress.setCode(expressCom);
            orderExpress.setNum(expressNum);
            orderExpressDAO.saveOrderExpress(orderExpress);

        }



        return 1;
    }

    @Override
    public String payOrder(int buyUserId, String orderId) {
        return null;
    }

    @Override
    public int rate(int buyUserId, String orderId, String goodsId, int score, String content, String imgs) {
        return 0;
    }

    @Override
    public int receive(int buyUserId, String orderId) {
        return 0;
    }

    @Override
    public int queryExpress(int buyUserId, String orderId) {
        return 0;
    }

    @Override
    public int addShopCart(int uid, int skuId, int buyNum) {

        MallProduct product = productDAO.getMallProduct(skuId);
        if(product==null) return -1;
        MallGoods goods = mallGoodsDAO.getMallGoods(product.getGoodsId());
        if(goods==null) return -1;

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUserId(uid);
        shoppingCart.setProductId(skuId);
        shoppingCart.setBuyNum(buyNum);
        shoppingCart.setGoodsId(goods.getId());
        shoppingCart.setPrice(product.getPrice());
        shoppingCart.setSalePrice(product.getSalePrice());
        shoppingCart.setProductName(goods.getName());
        shoppingCart.setShopId(goods.getShopId());
        shoppingCart.setImg(goods.getImg());
        return shoppingCartDAO.saveShoppingCart(shoppingCart);
    }

    @Override
    public int delShopCart(int id) {
        return shoppingCartDAO.delShoppingCart(id);
    }

    @Override
    public int updateShopNum(int id, int num) {
        ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCart(id);
        if(shoppingCart==null) return -1;
        shoppingCart.setBuyNum(num);
        return shoppingCartDAO.updateShoppingCart(shoppingCart);
    }

    @Override
    public List<ShoppingCartSet> findUserShopCart(int uid) {
        List<ShoppingCartSet> result = new ArrayList<>();
        List<ShoppingCart> list = shoppingCartDAO.findByUser(uid);
        for(ShoppingCart sc:list){
            ShoppingCartSet set = new ShoppingCartSet();
            set.setShoppingCart(sc);
            set.setProductset(mallProductService.getMallProductSet(sc.getProductId()));
            result.add(set);
        }
        return result;
    }


    @Override
    public int addCollectShop(int uid, int shopId) {
        CollectShop collectShop = new CollectShop();
        collectShop.setShopId(shopId);
        collectShop.setUserId(uid);

        return collectShopDAO.saveCollectShop(collectShop);
    }

    @Override
    public int delCollectShop(int id) {
        return collectShopDAO.delCollectShop(id);
    }

    @Override
    public List<UserShop> findCollectShop(int uid,int pageIndex,int pageSize) {
        return userShopDAO.findCollectShop(uid, pageIndex, pageSize);
    }

    @Override
    public int addCollectGoods(int uid, int goodsId) {
        CollectTreasure ct = new CollectTreasure();
        ct.setUserId(uid);
        ct.setGoodsId(goodsId);
        return collectTreasureDAO.saveCollectTreasure(ct);
    }

    @Override
    public int delCollectGoods(int id) {
        return collectTreasureDAO.delCollectTreasure(id);
    }

    @Override
    public List<MallGoods> findCollectGoods(int uid, int pageIndex, int pageSize) {
        return mallGoodsDAO.findCollectGoods(uid, pageIndex, pageSize);
    }

    @Override
    public Map<String, Integer> getCollectCount(int uid) {
        Map<String, Integer> map = new HashMap<>();
        map.put("shop",collectShopDAO.getCount(uid));
        map.put("goods",collectTreasureDAO.getCount(uid));
        return map;
    }

    @Override
    public Map<Integer, Integer> getOrderCount(int uid) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, ordersDAO.getCount(uid, 0));
        map.put(1,ordersDAO.getCount(uid,1));
        return map;
    }

    @Override
    public CollectShop isCollectShop(int uid, int shopId) {
        return collectShopDAO.isCollect(uid, shopId);
    }

    @Override
    public CollectTreasure isCollectGoods(int uid, int goodsId) {
        return collectTreasureDAO.isCollect(uid, goodsId);
    }
}
