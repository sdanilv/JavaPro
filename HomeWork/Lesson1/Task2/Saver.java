package Lesson1.Task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Saver {
    public static void main(String[] args) {
        invokeSave();
    }

    private static void invokeSave() {
        Class<?> cls = TextContainer.class;
        String path = cls.getAnnotation(SaveTo.class).path();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Save.class))
                try {
                    method.invoke(new TextContainer(), path);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
        }
    }
}
