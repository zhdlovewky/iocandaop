package com.ljx.test;

import com.ljx.entity.User;
import com.ljx.xml.spring.ExtClassPathXmlApplicationContext;

/**
 * author: LinjianXiong
 * Date: 2019/4/26
 * Time: 22:39
 *
 * xml注入方式
 *
 */
public class Test01 {
    public static void main(String[] args) throws Exception{
        ExtClassPathXmlApplicationContext applicationContext = new ExtClassPathXmlApplicationContext("spring.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }
}
