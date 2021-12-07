package spring.entity.JdkProxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

//must do it for finish proxy class
public class EnhanceProxy implements InvocationHandler {

    private Object target = null;

    public EnhanceProxy(Object factory) {
        this.target = factory;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object ret = null;
        ret = method.invoke(target, args);
        Integer integerret = null;
        //功能增强
        //如果在数据库里查到成绩
        if (ret != null) {
            integerret = Integer.valueOf(ret.toString());
        }
        else
        {
            System.out.println("查无此人");
        }
        //增强功能，判断成绩是否及格
        if (integerret != null) {
            if (integerret>60)
            {
                System.out.println("此人已及格");
            }
            else
            {
                System.out.println("此人没及格");
            }
        }
//            System.out.println("已加5");
//            return ret;
//        }
//        System.out.println(ret+"11");
        return ret;
    }
}
