package com.yyt.print.product.pojo;

import com.alibaba.fastjson.JSON;

import java.util.Date;
import java.util.List;

/**
 * Created by leo on 2016/11/17.
 * 首页推荐表
 */
public class MallIndex {
    private int id;
    private int rank;
    /**
     * 类别
     （管理平台显示的时候会把效果给他们标注出来）

     0 单图banner

     1 类别区(输入文字，没有跳转) ， 样式见效果图材料区 ， 设备区

     2 两图区（宣传图）      一排两张图片
     3 两图区（商品直达）  一排两张图片 ， 图片下面会有优惠价格

     4.三图区（宣传图）       一排三张图片
     5 三图区（商品直达）  一排三张图片 ， 图片下面会有优惠价格
     */
    private int type;

    /**
     * 0 不可用
     * 1 可用
     */
    private int status;
    private String name;
    private String content;
    private Date createTime;
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<MallIndexContent> transContent(){
        if(this.content!=null){
            return JSON.parseArray(this.content,MallIndexContent.class);
        }else{
            return null;
        }

    }
}
