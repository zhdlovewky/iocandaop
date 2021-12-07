package com.ljx.service.impl;

import com.ljx.annotation.spring.ExtService;
import com.ljx.service.OrderService;

/**
 * author: LinjianXiong
 * Date: 2019/4/26
 * Time: 23:30
 */
@ExtService
public class OrderServiceImpl implements OrderService {
    @Override
    public void addOrder() {
        System.out.println("addOrder");
    }
}
