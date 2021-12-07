package com.ljx.test;

import com.ljx.annotation.spring.ExtClassPathXmlApplicationContext;
import com.ljx.service.UserService;

/**
 * author: LinjianXiong
 * Date: 2019/4/26
 * Time: 23:36
 *
 * 依赖注入
 */
public class Test03 {
    public static void main(String[] args) throws Exception{
        ExtClassPathXmlApplicationContext applicationContext = new ExtClassPathXmlApplicationContext("com.ljx.service");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.addUser();
        System.out.println(userService);
    }
}
