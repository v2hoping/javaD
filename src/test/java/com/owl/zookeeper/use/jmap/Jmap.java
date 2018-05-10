package com.owl.zookeeper.use.jmap;

import com.owl.zookeeper.use.serializable.SerializableD;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 26383 on 2018/5/9.
 *
 * @author houping wang
 */
public class Jmap {

    public static void main(String[] args) {
        Student s1 = new Student("whp", 1);
        Student s2 = new Student("whp", 2);
        Student s3 = new Student("whp", 3);
        Student s4 = new Student("whp", 4);
        Student s5 = new Student("whp", 5);
        Student s6 = new Student("whp", 6);
        Student s7 = new Student("whp", 7);
        Student s8 = new Student("whp", 8);
        Student s9 = new Student("whp", 9);
        List<Student> array = new ArrayList<Student>();
        array.add(s1);
        array.add(s2);
        array.add(s3);
        array.add(s4);
        array.add(s5);
        array.add(s6);
        array.add(s7);
        array.add(s8);
        array.add(s9);
        try {
            Thread.sleep(1000 * 60 * 60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
