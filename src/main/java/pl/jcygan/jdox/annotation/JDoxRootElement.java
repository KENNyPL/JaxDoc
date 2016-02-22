package pl.jcygan.jdox.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface JDoxRootElement {
    public enum Indexing {
        AUTO, MANUAL
    }

    public enum Style {
        XML, OTHER
    }


    Indexing indexing() default Indexing.AUTO;

    String prefix() default "";

    String suffix() default "";

    Style style() default Style.OTHER;
}
