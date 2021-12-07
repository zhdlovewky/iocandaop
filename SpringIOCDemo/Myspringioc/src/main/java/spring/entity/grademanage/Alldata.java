package spring.entity.grademanage;

import lombok.Data;
import spring.entity.testentity1.Resource;
import spring.entity.testentity1.Service;
import spring.entity.testentity1.Value;

@Data
@Service("allStudentData")
public class Alldata {
    @Value("222")
    private String orderId;
    @Value("1000")
    private String price;
//    @Resource("aaa")
//    private Mygrade grade;
}
