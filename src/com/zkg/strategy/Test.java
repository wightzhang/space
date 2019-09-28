package com.zkg.strategy;

/*
 * created by kgzhang 2019/1/6
 */
public class Test {

    public static void main(String[] args) {
        Bill bill  = new Bill();
        bill.addItem(new Item("书",50000));
        bill.addItem(new Item("手机",1000000));
//        new CreditCard();
//        new DebitCard();
        //bill.pay(PaymentMethodFactory.getPaymentMethod("debit"));
        bill.pay(Card.paymentMethodMap.get("credit"));
        System.out.println(Card.paymentMethodMap);
    }
}
