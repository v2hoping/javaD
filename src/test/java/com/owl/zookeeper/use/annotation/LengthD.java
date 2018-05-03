package com.owl.zookeeper.use.annotation;

import java.lang.annotation.*;

/**
 * Created by 26383 on 2018/5/1.
 * 用于限定Integer类型位数。
 * 或者用于限定字符位数。
 * @author houping wang
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(value = ElementType.FIELD)
@Inherited
public @interface LengthD {

    int min();

    int max();

}
