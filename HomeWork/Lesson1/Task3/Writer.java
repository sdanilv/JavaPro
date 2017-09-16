package Lesson1.Task3;

import java.io.*;
import java.lang.reflect.Field;


public class Writer {

    static PrintWriter printWriter;
    static BufferedReader bufferedReader;

    public static void main(String[] args) throws IOException, IllegalAccessException {
        printWriter = new PrintWriter("Serializable.txt");
        bufferedReader = new BufferedReader(new FileReader("Serializable.txt"));
        save(new Test(1, "Hello"));
        Test test = (Test) load(new Test());
        System.out.println(test);
    }


    public static void save(Object object) throws FileNotFoundException, IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class))
                if (field.getType().isPrimitive())
                    printWriter.write(field.get(object).toString() + "\n");
                else if (field.getType() == String.class)
                    printWriter.write(field.get(object) + "\n");
                else save(field.get(object));
        }
        printWriter.flush();
    }


    public static Object load(Object object) throws IOException, IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                if (field.getType() == String.class)
                    field.set(object, bufferedReader.readLine());
                if (field.getType() == int.class)
                    field.set(object, Integer.parseInt(bufferedReader.readLine()));
                else {
                    load(field.get(object));
                }

            }
        }
        return object;
    }
}
