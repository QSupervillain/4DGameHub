package com.cxk.dao;

import com.cxk.pojo.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    public List<Order>orderlist();
}
