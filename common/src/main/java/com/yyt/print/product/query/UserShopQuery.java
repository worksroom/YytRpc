package com.yyt.print.product.query;

import com.yyt.print.query.BaseQuery;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/2/12.
 */
public class UserShopQuery extends BaseQuery{
    private int status = -1;
    private String name;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String,Object> getMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("status",this.status);
        if(this.name!=null){
            map.put("name",this.name);
        }

        return map;
    }
}
