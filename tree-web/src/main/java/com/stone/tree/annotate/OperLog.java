package com.stone.tree.annotate;

/**
 * @author dbw
 * @date 2021/01/03/2:23 下午
 * @Description
 */

import java.lang.annotation.*;

@Target(ElementType.METHOD) //注解放置的目标位置,METHOD是可注解在方法级别上
@Retention(RetentionPolicy.RUNTIME) //注解在哪个阶段执行
@Documented
public @interface OperLog {
    /**
     * 操作模块
     */
    String operModule() default "";

    /**
     * 操作类型
     */
    String operType() default "";

    /**
     * 操作说明
     */
    String operDesc() default "";
}
