package com.yyt.print.fragment.pojo;

import java.util.Date;
import java.util.List;

/**
 * 首页碎片
 * Created by SomeBody on 2016/9/23.
 */
public class FragmentHome {
    private int	id;
    private int	rank;//排序，数字越小排序越靠前
    private int	type;//类型，1 类别区（展示样式为）；2 一行一图区域；3 一行两图区域；4 一行三图区域
    private List<FragmentContent> content;//'内容，格式：[{"img":"...","url":"..."},{"img":"...","url":"..."}]
    private int	used;//是否有效，0 有效；-1 无效
    private Date createTime;

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

    public List<FragmentContent> getContent() {
        return content;
    }

    public void setContent(List<FragmentContent> content) {
        this.content = content;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
