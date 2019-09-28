package com.zkg.strategy;

import java.util.ArrayList;
import java.util.List;

/*
 * created by kgzhang 2019/1/6
 */
public class Bill {

    private List<Item> items = new ArrayList();

    public void addItem(Item item){
        items.add(item);
    }

    public void remove(Item item){
        items.remove(item);
    }

    public int getSum(){
        return  items.stream().mapToInt(x->x.getCents()).sum();
    }

    public void pay(PaymentMethod paymentMethod){
        paymentMethod.pay(getSum());
    }
}
