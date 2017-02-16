package com.yyt.print.product.pojo;

import java.util.List;

/**
 * Created by lenovo on 2017/2/15.
 */
public class MallGoodsSet {
    private MallGoods mallGoods;
    private List<MallProductSet> list;
    private List<MallProductExt> exts;

    public MallGoods getMallGoods() {
        return mallGoods;
    }

    public void setMallGoods(MallGoods mallGoods) {
        this.mallGoods = mallGoods;
    }

    public List<MallProductSet> getList() {
        return list;
    }

    public void setList(List<MallProductSet> list) {
        this.list = list;
    }

    public List<MallProductExt> getExts() {
        return exts;
    }

    public void setExts(List<MallProductExt> exts) {
        this.exts = exts;
    }
}
