package target;

//切面类：  增强代码与切入点结合
public class MyAspect {
    public void before() {
        System.out.println("开启事务");
    }

    public void after() {
        System.out.println("提交事务");
    }
}
