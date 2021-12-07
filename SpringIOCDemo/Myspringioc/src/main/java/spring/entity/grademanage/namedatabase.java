package spring.entity.grademanage;

import lombok.Data;
import spring.entity.testentity1.Service;

@Data
@Service("studentnamegrade")
public class namedatabase {
    private String xiaoming;
    private String xiaohong;
    private String xiaodong;

    public namedatabase(){
        xiaoming = "60";
        xiaohong = "70";
        xiaodong = "80";

    }
}
