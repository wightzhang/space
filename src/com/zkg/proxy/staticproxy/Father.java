package com.zkg.proxy.staticproxy;

import com.zkg.proxy.Person;

/*
 * created by kgzhang 2019/3/10
 */
public class Father {
    private Person son;

    public Father(Person son) {
        this.son = son;
    }

    public void findLove(){
        System.out.println("我是父亲，开始对象");
        son.findLove();
        System.out.println("我是父亲，结束对象");
    }
}
