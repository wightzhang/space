package com.zkg.proxy;

import com.zkg.proxy.dbroute.Order;
import com.zkg.proxy.jdk.JDKMeipo;
import com.zkg.proxy.staticproxy.Father;
import com.zkg.proxy.staticproxy.Son;

/*
 * created by kgzhang 2018/10/7
 */
public class Test {

    public static void main(String[] args) {
        Son son = new Son();
        Father father = new Father(son);

        father.findLove();

        System.out.println();

        Person meipo = (Person)new JDKMeipo().getInstance(son);
        meipo.findLove();

    }




}
