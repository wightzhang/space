package com.zkg.strategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * created by kgzhang 2019/1/6
 */
public abstract class Card implements PaymentMethod {

    static Map<String, PaymentMethod> paymentMethodMap = new ConcurrentHashMap<>();

    static {
        paymentMethodMap.put("credit", new CreditCard());
        paymentMethodMap.put("debit", new DebitCard());
    }

//    public Card() {
//        paymentMethodMap.put(getType(), this);
//    }

    @Override
    public void pay(int cents) {
        System.out.println("use " + getType() + " -> payed " + cents + " cents");
        execut(cents);
    }

    abstract String getType();

    abstract void execut(int cents);
}
