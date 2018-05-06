package com.owl.zookeeper.use.serializable;

import com.owl.zookeeper.use.regexp.RegexOwl;
import org.junit.Test;

import java.io.*;

/**
 * Created by 26383 on 2018/4/24.
 *
 * @author houping wang
 */
public class ExternalizableD {

    public static class Student implements Externalizable {

        private static final long serialVersionUID = 729522087833361984L;

        public Student() {
        }

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

        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(name);
            out.writeInt(age);
            out.flush();
        }

        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            this.name = (String)in.readObject() + "（小王)";
            this.age = in.readInt();
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        Student std = new Student("王厚平", 10);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tempExternalizable"));
            oos.writeObject(std);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tempExternalizable"));
            Student o = (Student)ois.readObject();
            System.out.println(o.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
