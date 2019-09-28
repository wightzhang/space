package com.zkg.strategy;

/*
 * created by kgzhang 2019/1/6
 */
public class CreditCard extends Card {

//    public CreditCard() {
//        super();
//    }

    @Override
    String getType() {
        return "credit";
    }



    @Override
    void execut(int cents) {
        System.out.println("credit "+cents);
    }
}
