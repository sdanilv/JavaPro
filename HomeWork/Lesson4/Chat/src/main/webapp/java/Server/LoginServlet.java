package Server;

import Model.MessageList;
import Model.User;
import Model.UserList;
import Util.Json;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    Json json = new Json();
    private final UserList userList = UserList.newInstance();
    private MessageList msgList = MessageList.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = json.fromJSON(request, User.class);
        if (userList.have(user)) {
            signIn(response, user);
        } else {
            if (userList.equalsName(user))
                response.getOutputStream().print(false);
            else {
                addNewUser(response, user);
            }
        }
    }

    private void addNewUser(HttpServletResponse response, User user) throws IOException {
        userList.add(user);
        msgList.addMessage("New user " + user.getLogin() + " connection");
        response.getOutputStream().print(true);
        user.setSession(true);
    }

    private void signIn(HttpServletResponse response, User user) throws IOException {
        msgList.addMessage("User " + user.getLogin() + " return");
        response.getOutputStream().print(true);
        user.setSession(true);
    }
}
