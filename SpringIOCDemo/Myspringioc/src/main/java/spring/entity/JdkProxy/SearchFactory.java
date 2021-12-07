package spring.entity.JdkProxy;

import spring.entity.MyAnnotationConfigApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

//import static java.awt.Container.log;

public class SearchFactory implements SearchIntf {

    private Object priMydatabase;

    public Object handler() {
        MyAnnotationConfigApplicationContext applicationContext = new MyAnnotationConfigApplicationContext("spring.entity");
        //      Object testobject = applicationContext.getbean("zhdbean");
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        //inject class is called statudentgrade as a bean
        int beanindex = Arrays.asList(beanDefinitionNames).indexOf("studentgrade");
        String beanName = beanDefinitionNames[beanindex];
//        System.out.println(applicationContext.getBean(beanName));
        Object objgrade = applicationContext.getBean(beanName);
        return applicationContext.getBean(beanName);
    }

    @Override
    public String searchbyname(String name) {

//        System.out.println("目标类执行了方法");
//        System.out.println(getFieldValueByName("Math",priMydatabase));
//    String a = (String) getGradeMap("math").get("xiaoming");
        this.priMydatabase = handler();
        //这里选择查数学成绩
        Object mathgrade = getFieldValueByName("math",priMydatabase);
        //拼凑数学成绩的key:value映射
        Map<String,String> mapret = CreatResultMap(mathgrade);
//        mathgrade.getClass().getDeclaredFields()
//        System.out.println(mapret);
        String ret = mapret.get(name);
        System.out.println("成绩为"+ret);
        return ret;
    }
    //这里本来用反射机制可以组成key:value的map,但出现了Todo的问题
    public Map<String,String> CreatResultMap(Object gradeobj) {
        Pattern pattern = Pattern.compile("(?<=\\()[^\\)]+");
        Matcher matcher = pattern.matcher(gradeobj.toString());
        Map<String,String> gradesubmap = new HashMap<String,String>();
        if (matcher.find()) {
            String ret = matcher.group();
            String res[] = ret.split(",");
            for (int i = 0; i < res.length; i++) {
                String targetstr = res[i];
                String namestr = targetstr.split("=")[0].trim();
                String valuestr = targetstr.split("=")[1].trim();
                gradesubmap.put(namestr, valuestr);
            }
//            System.out.println(gradesubmap);
        }
//        System.out.println(gradesubmap);
        return gradesubmap;
    }
    public Map getGradeMap(String subject)
    {
        //Todo:why use getFiledsInfo show
        // {serialPersistentFields=null, CASE_INSENSITIVE_ORDER=null,
        // coder=null, serialVersionUID=null, hashIsZero=null,
        // LATIN1=null, REPL=null, UTF16=null, COMPACT_STRINGS=null, value=null, hash=null}
//        System.out.println(gradeMap);
        return null;
    }

    private Map getFiledsInfo(Object o){
        Field[] fields=o.getClass().getDeclaredFields();
//        dataField = jsonClass.getDeclaredField("data");
        String[] fieldNames=new String[fields.length];
        List list = new ArrayList();
        Map infoMap=null;
        infoMap = new HashMap();
        for(int i=0;i<fields.length;i++){
//            infoMap.put("type", fields[i].getType().toString());
            System.out.println(fields[i]);
            String mapkey = fields[i].getName();
            Object mapvalue = getFieldValueByName(fields[i].getName(), o);
            infoMap.put(mapkey,mapvalue);
        }
        return infoMap;
    }

    /**
     * 根据属性名获取属性值
     * */
    private Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[] {});
            Object value = method.invoke(o, new Object[] {});
            return value.toString();
        } catch (Exception e) {
            //Todo:write messages
            return null;
        }
    }


}
