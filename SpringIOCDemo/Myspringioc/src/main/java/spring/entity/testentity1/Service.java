package spring.entity.testentity1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//标记使用方式
@Target(ElementType.TYPE)
//运行时的注解
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {
    //注解默认为空
    String value() default "";
}
