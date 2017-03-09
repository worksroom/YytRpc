package com.yyt.print.info.pojo;

/**
 * 厂家供应信息，转JSON存入InfoContent的content字段
 * Created by leo on 2017/3/3.
 */
public class InfoVender {
    /**
     * 供应商名称
     */
    private String venderName;
    /**
     * 供应商主营业务
     */
    private String mainBusiness;

    /**
     * 特殊优势
     */
    private String superiority;

    /**
     * 供应商区域
     */
    private String area;

    /**
     * 供应商地址
     */
    private String address;

    public String getVenderName() {
        return venderName;
    }

    public void setVenderName(String venderName) {
        this.venderName = venderName;
    }

    public String getMainBusiness() {
        return mainBusiness;
    }

    public void setMainBusiness(String mainBusiness) {
        this.mainBusiness = mainBusiness;
    }

    public String getSuperiority() {
        return superiority;
    }

    public void setSuperiority(String superiority) {
        this.superiority = superiority;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
