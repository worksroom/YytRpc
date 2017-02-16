package com.yyt.print.product.dao.impl;

import com.yyt.print.base.YytBaseDAO;
import com.yyt.print.product.dao.IFareMouldDAO;
import com.yyt.print.product.pojo.FareMould;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2017/2/16.
 */
@Repository("fareMouldDAO")
public class FareMouldDAOImpl extends YytBaseDAO<FareMould> implements IFareMouldDAO {

    @Override
    public int saveFareMould(FareMould fareMould){return super.insert(fareMould);}

    @Override
    public int updateFareMould(FareMould fareMould){return super.update(fareMould);}

    @Override
    public FareMould getFareMould(int id){return super.get(id);}


    @Override
    public int delFareMould(int id){return super.delete(id);}

    @Override
    public List<FareMould> findFareMoulds(int shopId) {
        return super.findBy("selectByShopId",shopId);
    }
}
