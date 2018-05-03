package com.owl.zookeeper.use.annotation;

import java.lang.annotation.*;

/**
 * Created by 26383 on 2018/5/1.
 *
 * @author houping wang
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(value = ElementType.FIELD)
@Inherited
public @interface NotBlankD {
}
