package com.yyt.print.query;

/**
 * Created by lenovo on 2017/2/12.
 */
public class BaseQuery {
    protected int pageIndex = 1;
    protected int pageSize = 20;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
