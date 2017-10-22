package Model;

import java.util.ArrayList;
import java.util.List;

public class MessageList {
    private static MessageList ourInstance = new MessageList();

    private ArrayList<String> client = new ArrayList<>();

    public void addMessage(String string) {
        client.add(string);
    }

    public List<String> getFromPosition(int position) {

        List<String> clients = client.subList(position, client.size());
        for (String s : clients) {
            System.out.println(s);
        }
        return client.subList(position, client.size());
    }

    public static MessageList getInstance() {
        return ourInstance;
    }

    private MessageList() {
    }
}
