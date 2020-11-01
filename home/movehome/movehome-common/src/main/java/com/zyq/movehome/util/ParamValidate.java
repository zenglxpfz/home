package com.zyq.movehome.util;

import javax.validation.groups.Default;
import java.lang.annotation.*;

/**
 * @program:
 * @description:
 * @author: ZengYunQi
 * @time: 2020/2/26 - 9:42
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamValidate {
    int[] argsIndexs() default {0};

    Class<?>[] groups() default {Default.class};

}
