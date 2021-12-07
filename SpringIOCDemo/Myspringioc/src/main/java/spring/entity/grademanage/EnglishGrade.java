package spring.entity.grademanage;

import lombok.Data;
import spring.entity.testentity1.Resource;
import spring.entity.testentity1.Service;
import spring.entity.testentity1.Value;

@Data
@Service("english")
public class EnglishGrade {

    @Value("90")
    private String xiaozhang;
    @Value("80")
    private String xiaoming;
    @Value("70")
    private String xiaohong;
    @Value("60")
    private String xiaoxue;
    @Value("50")
    private String xiaoli;
}
