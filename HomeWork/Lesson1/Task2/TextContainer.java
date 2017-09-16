package Lesson1.Task2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

@SaveTo(path = "file.txt")
public class TextContainer {
    String text = "Hello worm!";

    @Save
    public void save(String path) {
        try {
            PrintWriter printWriter = new PrintWriter(path);
            printWriter.write(text);
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
