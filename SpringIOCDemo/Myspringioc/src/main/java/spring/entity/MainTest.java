package spring.entity;

import lombok.Data;
import spring.entity.JdkProxy.EnhanceProxy;
import spring.entity.JdkProxy.SearchFactory;
import spring.entity.JdkProxy.SearchIntf;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MainTest {
    public static <canner> void main(String[] args)
    {

        //创建目标对象
        SearchIntf factory = new SearchFactory();
        //creat
        InvocationHandler handler = new EnhanceProxy(factory);
        //creat agent proxy object
        SearchIntf searchproxy = (SearchIntf) Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(),
                handler);
        Scanner input=new Scanner(System.in);
        String inputstr = input.next();
        searchproxy.searchbyname(inputstr);


//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(applicationContext.getBean(beanDefinitionName));
//            System.out.println(beanDefinitionName);

//            if (applicationContext.getBean(beanDefinitionName).getClass().getName())
////            {
////                System.out.println(111);
////            }
        }
//        System.out.println(Arrays.stream(beanDefinitionNames).sorted());

//        System.out.println(applicationContext.getBeanDefinitionCount());
    }
