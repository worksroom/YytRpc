package com.yyt.print.product.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IStoreLocationDAO;
import com.yyt.print.product.pojo.StoreLocation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2017/2/16.
 */
@Repository("storeLocationDAO")
public class StoreLocationDAOImpl extends YytBaseDAO<StoreLocation> implements IStoreLocationDAO {
    @Override
    public int saveStoreLocation(StoreLocation storeLocation){return super.insert(storeLocation);}
    @Override
    public int updateStoreLocation(StoreLocation storeLocation){return super.update(storeLocation);}
    @Override
    public StoreLocation getStoreLocation(int id){return super.get(id);}
    @Override
    public int delStoreLocation(int id){return super.delete(id);}

    @Override
    public List<StoreLocation> findStoreLocations(int shopId) {
        return super.findBy("selectByShopId",shopId);
    }
}
