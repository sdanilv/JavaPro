package Client;

import Model.User;
import Util.Json;
import Util.MyURL;

public class StatusThread extends Thread {
    String login;
    String message;

    public StatusThread(String login, String message) {
        this.login = login;
        this.message = message;
    }

    @Override
    public void run() {
        String[] command = message.split(" ");
        String string;
        try {
            string = MyURL.readFromServer(MyURL.STATUS(login, command[1]));
            User[] status = new Json().fromJSON(string, User[].class);
            for (User user : status) {
                System.out.println(user);
            }
        }catch (NullPointerException e){
        }
    }
}
