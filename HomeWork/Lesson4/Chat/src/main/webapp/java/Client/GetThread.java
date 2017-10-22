package Client;

import Util.Json;
import Util.MyURL;

import java.util.List;

public class GetThread implements Runnable {
    @Override
    public void run() {
        int position = 0;
        while (true) {
            String string = MyURL.readFromServer(MyURL.GET(position));
            List<String> message = new Json().fromJSON(string, List.class);
            position += message.size();
            for (String s : message) {
                s = stringHandling(s);
                if (s == null) continue;
                System.out.println(s);
            }
            expectation();
        }
    }

    private void expectation() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String stringHandling(String s) {
        String[] split = s.split(" ", 4);
        if (split.length > 2) {
            if (split[1].equals("-to")) {
                if (!split[2].equals(ClientConsole.getLogin())) return null;
                s = split[0] + split[3];
            }
            if (split[0].equals("@room")) {
                if (!split[1].equals(ClientConsole.getRoom())) return null;
                s = split[2] + split[3];
            }
        }
        return s;
    }

}