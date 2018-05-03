package com.owl.zookeeper.use.annotation;

/**
 * Created by 26383 on 2018/5/1.
 * 大学生信息对象.
 * @author houping wang
 */
public class Student {

    @NotBlankD
    private String name;

    @LengthD(min = 5, max = 10)
    private String code;

    @LengthD(min = 18, max = 30)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
