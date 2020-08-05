package com.example.springboot.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Description: please add the description
 * Author: zhongds
 * Date : 2020/8/5 19:58
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Privilege {
    String value();
}
