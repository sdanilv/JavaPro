package Client;

import Util.Json;
import Model.User;
import Util.MyURL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class ClientConsole {
    private static Json json;
    private static BufferedReader reader;
    private static String login;
    private static String room;

    public static void getLoginAndPass() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            json = new Json();
            System.out.println("Enter your login: ");
            login = readFromConsole();
            System.out.println("Enter your password: ");
            String pass = readFromConsole();
            User user = new User(login, pass);
            json.sendJSON(MyURL.LOGIN(), "POST", user);
            if (getBooleanFromServer()) break;
            System.out.println("Wrong login or password");
        }
    }

    private static boolean getBooleanFromServer() {
        String string = json.readString();
        return Boolean.parseBoolean(string);
    }

    public static void startSendingMessage() {
        try {
            while (true) {
                String string = readFromConsole();
                if (string.equals("")) {
                    break;
                } else if (string.startsWith("-cmd")) {
                    new StatusThread(login, string).start();
                } else if (string.startsWith("-room")) {
                    room = string.replace("-room ", "");
                }else if (room != null) {
                    MyURL.writeToServer(MyURL.ADD(), "@room " + room + " " + login + ": " + string);
                } else
                    MyURL.writeToServer(MyURL.ADD(), login + ": " + string);
            }
        } finally {
            close();
        }
        disconnected();
    }

    private  static void disconnected() {
        MyURL.writeToServer(MyURL.STATUS(login,"logout"), "");
        MyURL.writeToServer(MyURL.ADD(), login + " disconnected.");
    }

    private static String readFromConsole() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void close() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getLogin() {
        return login;
    }

    public static String getRoom() {
        return room;
    }
}
