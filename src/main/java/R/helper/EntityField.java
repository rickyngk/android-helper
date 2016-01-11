package R.helper;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME) @Target(FIELD)
public @interface EntityField {
    String value();
    Class<?> type() default String.class;
    Class<?> collectionType() default void.class;
}