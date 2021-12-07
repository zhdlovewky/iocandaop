package com.ljx.service;

import com.ljx.annotation.spring.ExtResource;
import com.ljx.annotation.spring.ExtService;

/**
 * author: LinjianXiong
 * Date: 2019/4/26
 * Time: 23:07
 */
@ExtService
public class UserService {
    @ExtResource
    private OrderService orderServiceImpl;       //不能用orderService只能用orderServiceImpl，需改进

    public void  addUser(){
        orderServiceImpl.addOrder();
        System.out.println("使用反射机制初始化对象");
    }
}
