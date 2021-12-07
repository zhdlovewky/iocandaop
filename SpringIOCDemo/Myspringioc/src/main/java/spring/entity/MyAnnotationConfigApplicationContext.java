package spring.entity;

import spring.entity.testentity1.Resource;
import spring.entity.testentity1.Service;
import spring.entity.testentity1.Value;
import spring.entity.tools.MyTools;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

//构造器中传入要扫描的包
public class MyAnnotationConfigApplicationContext {

    //(beanname,object)
    private Map<String,Object> ioc = new HashMap<>();
    //存bean数组
    private List<String> beanNames = new ArrayList<>();

    //无继承时 静态代码块 > 构造代码块 > 构造器
    //有继承时 父类静态代码块 > 子类静态代码块 > 父类构造代码块 > 父类构造器 > 子类构造代码块 > 子类构造器
    public MyAnnotationConfigApplicationContext(String pack) {
        //遍历包，找到目标类(原材料)
        Set<BeanDefination> beanDefinitions = findBeanDefinations(pack);
        //根据原材料创建bean
        createObject(beanDefinitions);
        //根据@Resource注解把属性注入给bean
        injectResourceParm(beanDefinitions);

    }

    public Object getallbeannames()
    {
        return ioc.values();
    }

    public Object getBean(String beanName){
        return ioc.get(beanName);
    }
    public String[] getBeanDefinitionNames(){
        return beanNames.toArray(new String[0]);
    }

    public Integer getBeanDefinitionCount(){
        return beanNames.size();
    }

    public void injectResourceParm(Set<BeanDefination>beanDefinations){
        Iterator<BeanDefination> iterator = beanDefinations.iterator();
        while (iterator.hasNext())
        {
            BeanDefination beanDefination = iterator.next();
            Class clazz = beanDefination.getBeanClass();
            Field[] sourcefield = clazz.getDeclaredFields();
//            System.out.println(sourcefield+"///");
            //通过反射获得类对象
            for (Field field : sourcefield)
            {
                Resource annafield = field.getAnnotation(Resource.class);
//                System.out.println(annafield);
                if (annafield!=null) {
                    //by beanname search
                    try {
                        //获取被注入的beanname名
                        String injectbean = annafield.value();

                        //获取beanname对应的对象
//                        System.out.println(injectbean);
                        Object bean = getBean(injectbean);
                        String fieldname = field.getName();
                        String methodName = "set" + fieldname.substring(0, 1).toUpperCase() + fieldname.substring(1);
                        Method method = clazz.getMethod(methodName, field.getType());
                        Object object = getBean(beanDefination.getBeanName());
//                        System.out.println(object);
//                        System.out.println(bean);
                        if (bean!=null) {
//                            System.out.println(object+"11"+bean);
                            method.invoke(object, bean);
                        }
//                        field.set(object,bean);
//                        System.out.println(object.getClass());
//                        field.set(Object,bean);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    //Todo:search by type
//                }else{
//                    Object beantype = annafield;
//                    String fieldtype = field.getType().getTypeName();
//                    String typestring = fieldtype.substring(10);
//                    for (Object beanobject : ioc.values())
//                    {
//                        System.out.println(beanobject);
//                    }
                    }
                }
        }
    }

    public void createObject(Set<BeanDefination> beanDefinations){
        Iterator<BeanDefination> iterator = beanDefinations.iterator();
        while (iterator.hasNext()) {
            BeanDefination beanDefinition = iterator.next();
            Class clazz = beanDefinition.getBeanClass();
            String beanName = beanDefinition.getBeanName();
            try {
                //创建的对象
                Object object = clazz.getConstructor().newInstance();
                //完成属性的赋值
                //此处为无参构造
                Field[] declaredFields = clazz.getDeclaredFields();
                for (Field declaredField : declaredFields) {
                    //对象有使用value注解,
                    Value valueAnnotation = declaredField.getAnnotation(Value.class);
                    if(valueAnnotation!=null){
                        String value = valueAnnotation.value();
                        String fieldName = declaredField.getName();
                        String methodName = "set"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
                        //获取方法名
                        Method method = clazz.getMethod(methodName,declaredField.getType());
                        //完成数据类型转换
                        Object val = null;
                        //根据属性类型 完成返回值转换 不然会dismatch报错
                        switch (declaredField.getType().getName()){
                            case "java.lang.Integer":
                                val = Integer.parseInt(value);
                                break;
                            case "java.lang.String":
                                val = value;
                                break;
                            case "java.lang.Float":
                                val = Float.parseFloat(value);
                                break;
                        }
                        //给对象赋值
                        method.invoke(object, val);
                    }
                }
                //存入ioc容器
                ioc.put(beanName, object);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
    public Set<BeanDefination> findBeanDefinations(String pack)
    {
        //不确定类的类型
        Set<Class<?>> classes = MyTools.getClasses(pack);
        Iterator<Class<?>> iterator = classes.iterator();
        Set<BeanDefination> beanDefinations = new HashSet<>();
        while (iterator.hasNext())
        {
            Class<?> clazz = iterator.next();
            Service Ser = clazz.getAnnotation(Service.class);
            if (Ser!=null)
            {
                //如果有注解
                String beanname = Ser.value();
//                System.out.println(beanname);
                if ("".equals(beanname))
                {
                    String beanName = Ser.value();
                    //把前缀替换了得到类名
                    String fieldName = clazz.getName().replaceAll(clazz.getPackage().getName()+".","");
                    //首字母变小写
                    beanname = fieldName.substring(0,1).toLowerCase()+fieldName.substring(1);
                }
                //such as BeanDefination(beanName=aaaa, beanClass=class spring.entity.Mygrade)
                beanDefinations.add(new BeanDefination(beanname, clazz));
                beanNames.add(beanname);
            }
//            System.out.println(Com+"//"+clazz);
        }
        return  beanDefinations;
    }


}
