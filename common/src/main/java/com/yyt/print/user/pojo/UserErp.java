package com.yyt.print.user.pojo;

import java.util.Date;

/**
 * Created by leo on 2017/2/8.
 */
public class UserErp {
    private int id;
    private int erpUid;
    private String phone;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getErpUid() {
        return erpUid;
    }

    public void setErpUid(int erpUid) {
        this.erpUid = erpUid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
