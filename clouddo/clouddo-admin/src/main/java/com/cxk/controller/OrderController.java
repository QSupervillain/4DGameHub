package com.cxk.controller;

import com.cxk.pojo.Order;
import com.cxk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/orderindex")
    public String orderindex(Model model){
        List<Order> orderlist = orderService.orderlist();
        model.addAttribute("orderlist",orderlist);
        return "order-list";
    }
}
