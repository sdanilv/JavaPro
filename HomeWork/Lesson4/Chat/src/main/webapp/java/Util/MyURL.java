package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MyURL {

    public static final URL ADD() {
        try {
            return new URL(Properties.getURL() + "/add");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL GET(int position) {
        try {
            return new URL(Properties.getURL() + "/get?position=" + position);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final URL LOGIN() {
        try {
            return new URL(Properties.getURL() + "/login");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static final URL LOGOUT(String login) {
        try {
            return new URL(Properties.getURL() + "/logout?login=" + login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL STATUS(String login, String command) {
        try {
            return new URL(Properties.getURL() + "/status?login=" + login + "&command=" + command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String readFromServer(URL url) {
        BufferedReader reader;
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.getResponseCode();
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String string = reader.readLine();
            reader.close();
            return string;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeToServer(URL url, String message) {
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.getOutputStream().write(message.getBytes());
            connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

