package com.zkg.proxy.dbroute.proxy;

import com.zkg.proxy.dbroute.IOrderService;
import com.zkg.proxy.dbroute.Order;
import com.zkg.proxy.dbroute.db.DynamicDataSourceEntity;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * created by kgzhang 2019/3/10
 */
public class OrderServiceStaticProxy implements IOrderService {
    private SimpleDateFormat yearFormat =
            new SimpleDateFormat("");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService){
        this.orderService = orderService;
    }

    public int createOrder(Order order){
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        DynamicDataSourceEntity.set(dbRouter);


        return 0;
    }


}
