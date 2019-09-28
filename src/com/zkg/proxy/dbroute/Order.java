package com.zkg.proxy.dbroute;

import java.io.ObjectOutputStream;

/*
 * created by kgzhang 2019/3/10
 */
public class Order {
    private Object orderName;
    private Long createTime;
    private String id;

    public Object getOrderName() {
        return orderName;
    }

    public void setOrderName(Object orderName) {
        this.orderName = orderName;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
