package com.example.springboot.annotation;

import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Description: 自定义参数校验注解
 * <p>
 * Author: zhongds
 * Date : 2020/8/1 16:02
 */
@Target({ElementType.PARAMETER, ElementType.FIELD})
public @interface DValidate {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
