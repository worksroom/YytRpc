package com.yyt.print.info.query;

import com.yyt.print.query.BaseQuery;

/**
 * Created by leo on 2017/3/3.
 */
public class InfoQuery extends BaseQuery {
    private int userId = -1;
    private int type = -1;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("InfoQuery{");
        sb.append("userId=").append(userId);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
