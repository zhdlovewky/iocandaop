package spring.entity;

import spring.entity.testentity1.Resource;
import spring.entity.testentity1.Service;

//@Service("zhdbean")
public class ordertest1 {

//    @Resource("zhd")
//    private String test1;


    public ordertest1()
    {
//        System.out.println("注入zhdbean");
    }
    public static String find()
    {
        System.out.println("111");
        return "80";
    }
}
