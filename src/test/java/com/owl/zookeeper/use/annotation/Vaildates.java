package com.owl.zookeeper.use.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26383 on 2018/5/1.
 *
 * @author houping wang
 */
public class Vaildates {

    public static List<String> getObject(Object obj) {
        try{
            Field[] fields = obj.getClass().getDeclaredFields();
            List<String> results = new ArrayList<String>();
            for(Field field : fields) {
                if(field.isAnnotationPresent(NotBlankD.class)) {
                    field.setAccessible(true);
                    Object o = field.get(obj);
                    if(o == null || o.equals("")) {
                        results.add(field.getName() + "不能为Null或者为空");
                    }
                }
                if(field.isAnnotationPresent(LengthD.class)) {
                    LengthD lengthD = field.getAnnotation(LengthD.class);
                    field.setAccessible(true);
                    Object o = field.get(obj);
                    if(o instanceof String) {
                        String o1 = (String) o;
                        if(o1.length() < lengthD.min() || o1.length() > lengthD.max()) {
                            results.add(field.getName() + "不在" + lengthD.min() + "至" + lengthD.max() + "范围之内");
                        }
                    }
                    if(o instanceof Integer) {
                        Integer o1 = (Integer) o;
                        if(o1 < lengthD.min() || o1 > lengthD.max()) {
                            results.add(field.getName() + "不在" + lengthD.min() + "至" + lengthD.max() + "范围之内");
                        }
                    }
                }
            }
            return results;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
