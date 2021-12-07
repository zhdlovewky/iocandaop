package spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

//使用这个注解，就不用再去手写Getter,Setter,equals,canEqual,hasCode,toString等方法了，注解后在编译时会自动加进去。
@Data
//使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@AllArgsConstructor
public class BeanDefination {
    private String beanName;
    private Class beanClass;
}
