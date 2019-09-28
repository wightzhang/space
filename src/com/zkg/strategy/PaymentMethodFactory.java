package com.zkg.strategy;

/*
 * created by kgzhang 2019/1/6
 */
public class PaymentMethodFactory {

    public static  PaymentMethod getPaymentMethod(String type){
        switch (type){
            case "credit":
                return new CreditCard();
            case "debit":
                return new DebitCard();
            default:
                return null;
        }
    }
}
