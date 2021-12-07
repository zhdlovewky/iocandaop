package factory;

//public class Beanfactory {

//    /**
//     * JDk实现的代理
//     * @return
//     */
//    public static <IUserService> IUserService createUserService(){
//        //1创建对象
//        final IUserService userService= new IUserviceImpl();
//        System.out.println(userService);
//
//        //2声明切面类对象
//        final   MyAspect aspect=new MyAspect();
//        //3把切面类2个方法 应用 到目标类
//
//        //3.1创建jdk代理
//   /*    newProxyInstance(
//                 ClassLoader loader,  //类加载器
//                Class<?>[] interfaces, 接口
//                InvocationHandler h) 处理
//        */
//        IUserService proxyService = (IUserService) Proxy.newProxyInstance(
//                MyBeanFactory.class.getClassLoader(),
//                userService.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        //开启事务
//                        aspect.before();
//                        //方法返回值是 业务方法的返回值
//                        Object retObj = method.invoke(userService, args);
//                        System.out.println("拦截的返回值" + retObj);
//                        //提交事务
//                        aspect.after();
//                        return retObj;
//                    }
//                }
//        );
//        //返回代理
//        return proxyService;
//    }
//}
