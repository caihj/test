package com.fighter.annotation;

import java.lang.annotation.*;

/**
 * Created by chj on 2015/12/22.
 */


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited()
public @interface Fruit {
    public String name() default "fruit";
    public String color() default "null";
}
