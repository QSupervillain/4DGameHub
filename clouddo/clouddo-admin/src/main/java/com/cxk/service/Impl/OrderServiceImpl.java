package com.cxk.service.Impl;

import com.cxk.dao.OrderDao;
import com.cxk.pojo.Order;
import com.cxk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired(required = false)
    private OrderDao orderDao;
    @Override
    public List<Order> orderlist() {
        return orderDao.orderlist();
    }
}
