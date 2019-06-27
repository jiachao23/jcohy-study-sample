package jcohy.study.ansyc.service;


import jcohy.study.ansyc.Order;

import java.util.List;

/**
 * Created by jiac on 2019/3/27.
 * ClassName  : jcohy.study.ansyc.service
 * Description  :
 */
public interface OrderService {
    Order query(Integer orderId);

    List<Order> query(List<Integer> ordersId);
}
