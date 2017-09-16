package Lesson1.Task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationAndReflect {

    public static void main(String[] args) {
        AnnotationAndReflect a = new AnnotationAndReflect();
        searchAndInvokeMethodForAnnotation(new Test());
        searchAndInvokeMethodForAnnotation(a);
    }

    @ParameterSource(first = "Hello", second = " Word!")
    private void seePararmeter(String first, String second) {
        System.out.print(first);
        System.out.println(second);
    }

    private static void searchAndInvokeMethodForAnnotation(Object object) {
        Class<?> cls = object.getClass();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ParameterSource.class)) {
                startMethodWithParameters(object, method);
            }
        }
    }

    private static void startMethodWithParameters(Object object, Method method) {
        method.setAccessible(true);
        ParameterSource parameterSource = method.getAnnotation(ParameterSource.class);
        try {
            method.invoke(object, parameterSource.first(), parameterSource.second());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}




