package com.zkg.strategy;

/*
 * created by kgzhang 2019/1/6
 */
public class Item {

    private String desc;
    private int cents;

    public Item(String desc, int cents) {
        this.desc = desc;
        this.cents = cents;
    }

    public String getDesc() {
        return desc;
    }

    public int getCents() {
        return cents;
    }
}
