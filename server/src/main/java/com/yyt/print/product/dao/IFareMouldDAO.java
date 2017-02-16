package com.yyt.print.product.dao;

import com.yyt.print.product.pojo.FareMould;

import java.util.List;

/**
 * Created by lenovo on 2017/2/16.
 */
public interface IFareMouldDAO {
    int saveFareMould(FareMould fareMould);

    FareMould getFareMould(int id);

    int updateFareMould(FareMould fareMould);

    int delFareMould(int id);

    List<FareMould> findFareMoulds(int shopId);
}
