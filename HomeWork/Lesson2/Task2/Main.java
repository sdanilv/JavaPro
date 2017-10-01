package Lesson2.Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Main {
    static FileReader reader;
    static Gson gson;


    public static void main(String[] args) {
        init();
        JSON json = getJson();
        System.out.println(json);
    }

    private static JSON getJson() {
        return  gson.fromJson(reader, JSON.class);
    }

    private static void init() {
        File file = new File("HomeWork/Lesson2/Task2/a.json");
        gson = new GsonBuilder().create();
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
