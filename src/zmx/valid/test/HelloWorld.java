package zmx.valid.test;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface HelloWorld {
    public String name()default "";
}

