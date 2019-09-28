package com.zkg.strategy;

/*
 * created by kgzhang 2019/1/6
 */
public class DebitCard extends Card {

//    public DebitCard() {
//        super();
//    }

    @Override
    String getType() {
        return "debit";
    }

    @Override
    void execut(int cents) {
        System.out.println("debit "+cents);
    }
}
