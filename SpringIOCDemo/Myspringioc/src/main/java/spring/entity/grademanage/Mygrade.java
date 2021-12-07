package spring.entity.grademanage;

import lombok.Data;
import spring.entity.testentity1.Service;
import spring.entity.testentity1.Value;
import spring.entity.testentity1.Resource;
//import javax

import java.util.HashMap;
import java.util.Map;

@Data
@Service
public class Mygrade {

    @Value("123")
    private String xiao;


//    @Resource("aaa")
    public static final Map Grademaps = new HashMap() {
        {
            this.put("zhd", 60);
            this.put("jack", 70);
            this.put("admin", 80);
        }
    };

    public Mygrade() {
    }

    public static int returngrade(String name) {
        int ret = 0;

        try {
            ret = (Integer) Grademaps.get(name);
        } catch (Exception var6) {
            System.out.println("查询失败");
        } finally {
            System.out.println("查询结束");
        }

        return ret;
    }
}
