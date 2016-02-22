package pl.jcygan.jdox.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) //can use in method only.
public @interface JDoxElement {

    long index() default 0;

    String prefix() default "";

    String suffix() default "";

    String name() default "";
}
