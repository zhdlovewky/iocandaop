package com.ljx.test;

/**
 * author: LinjianXiong
 * Date: 2019/4/26
 * Time: 23:05
 */

import com.ljx.annotation.spring.ExtClassPathXmlApplicationContext;
import com.ljx.entity.User;

/**
 * author: LinjianXiong
 * Date: 2019/4/26
 * Time: 22:39
 *
 * 注解注入方式
 *
 */
public class Test02 {
    public static void main(String[] args) throws Exception{
        ExtClassPathXmlApplicationContext applicationContext = new ExtClassPathXmlApplicationContext("com.ljx.service");
        Object o = applicationContext.getBean("userService");
        System.out.println(o);
    }
}