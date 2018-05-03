package com.owl.zookeeper.use.annotation;

import com.owl.zookeeper.use.serializable.SerializableD;
import org.junit.Test;

import java.util.List;

/**
 * Created by 26383 on 2018/5/1.
 *
 * @author houping wang
 */
public class AnnotationD {

    @Test
    public void testNotBlank() {
        Student a = new Student();
        a.setName(null);
        a.setAge(17);
        a.setCode("100000000000000000000");
        List<String> error = Vaildates.getObject(a);
        System.out.println(error);
        Student b = new Student();
        b.setName("王厚平");
        b.setAge(18);
        b.setCode("10000");
        List<String> error1 = Vaildates.getObject(b);
        System.out.println(error1);
    }

    @Test
    public void testValidateUtils() {
        StudentInfo s = new StudentInfo();
        long startTime = System.currentTimeMillis();
        System.out.println(ValidateUtils.validate(s));
        System.out.println("===============耗时(毫秒)=" + (System.currentTimeMillis() - startTime));

        s.setUserName("小明");
        s.setAge("a10");
        s.setBirthday("2016-9-1");
        s.setMoney(1.00001);

        startTime = System.currentTimeMillis();
        System.out.println(ValidateUtils.validate(s));
        System.out.println("===============耗时(毫秒)=" + (System.currentTimeMillis() - startTime));
    }
}
