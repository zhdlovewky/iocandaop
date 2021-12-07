package spring.entity.grademanage;

import lombok.Data;
import spring.entity.testentity1.Resource;
import spring.entity.testentity1.Service;
import spring.entity.testentity1.Value;

@Data
@Service("studentgrade")
public class inject {
//    @Resource("allStudentData")
//    @Value("90")
//    private String Chinese;
//    @Value("80")
//    private Float Math;
//    @Value("70")
//    private Integer English;
//inject(english=null)11Alldata(orderId=222, price=1000)
    @Resource("math")
    private MathGrade Math;
    @Resource("english")
    private EnglishGrade English;


}
