package com.yyt.print.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yyt.print.order.dao.IOrderAddrDAO;
import com.yyt.print.order.dao.IShoppingCartDAO;
import com.yyt.print.order.front.OrderProductFront;
import com.yyt.print.order.pojo.Orders;
import com.yyt.print.order.pojo.ShoppingCart;
import com.yyt.print.order.pojo.ShoppingCartSet;
import com.yyt.print.order.service.IOrderService;
import com.yyt.print.product.dao.IMallGoodsDAO;
import com.yyt.print.product.dao.IMallProductDAO;
import com.yyt.print.product.pojo.MallGoods;
import com.yyt.print.product.pojo.MallProduct;
import com.yyt.print.product.pojo.MallProductSet;
import com.yyt.print.product.service.IMallProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Orders makeOrder(int buyUserId,int addrId,List<OrderProductFront> product,JSONObject ext) {
        Orders order = new Orders(buyUserId);
        double totalMoney = 0;
        for(OrderProductFront opf:product){
            MallProductSet mps = mallProductService.getMallProductSet(opf.getProductId());
            totalMoney = totalMoney + mps.getMallProduct().getSalePrice();

        }

        return null;
    }

    @Override
    public List<Orders> queryOrders(int buyUserId, int type) {
        return null;
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
}
