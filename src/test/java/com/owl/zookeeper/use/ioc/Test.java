package com.owl.zookeeper.use.ioc;

/**
 * Created by wanghouping on 2018/5/14.
 *
 * @author houping wang
 */
public class Test {

    @org.junit.Test
    public void test() {
        ApplicationContext a = new ClassPathXMLApplicationContext("bean.xml");
        StudentService studentService = (StudentService)a.getBean("StudentService");
        Student student = studentService.getStudent();
    }
}
