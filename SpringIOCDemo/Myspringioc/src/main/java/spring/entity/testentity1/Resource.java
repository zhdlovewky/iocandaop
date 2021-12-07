package spring.entity.testentity1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
//此注解用于根据beanname找到bean然后注入被注解的bean
public @interface Resource {
    //不能不带value,只指定@Resource注解的type属性，
    // 则从上下文中找到类型匹配的唯一bean进行装配，找不到或者找到多个，都会抛出异常
    String value();
}
