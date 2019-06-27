package jcohy.study.ansyc.service;

import jcohy.study.ansyc.Order;

import java.util.List;

/**
 * Created by jiac on 2019/3/27.
 * ClassName  : jcohy.study.ansyc.service
 * Description  :
 */
public class OrderServiceImpl implements OrderService{
    @Override
    public Order query(Integer orderId) {
        return new Order(orderId,"name = order"+orderId);
    }

    @Override
    public List<Order> query(List<Integer> ordersId) {
        return null;
    }
}
