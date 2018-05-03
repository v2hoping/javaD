package com.owl.zookeeper.use.serializable;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by 26383 on 2018/4/24.
 *
 * @author houping wang
 */
public class SerializableD {

    public static class Student implements Serializable{
        private String name;

        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


    @Test
    public void test() {
        Student stu = new Student("王厚平", 10);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempStudent"));
            oos.writeObject(stu);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        Student stu = new Student("颖宝", 8);
        try {
            File file = new File("tempStudent");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            stu = (Student) ois.readObject();
            System.out.println(stu);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
