import java.lang.annotation.*;

@Inherited
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@interface ParameterSource {
    String first();

    String second();
}
