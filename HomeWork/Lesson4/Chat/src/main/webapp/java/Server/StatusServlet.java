package Server;

import Model.UserList;
import Util.Json;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatusServlet extends HttpServlet {

    UserList userList = UserList.newInstance();
    Json json;
    String login;
    String command;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req);
        if (command.equals("logout")) {
            userList.logout(login);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        init(request);
        if (command.equals("list")) {
            json.out(response, json.toJSON(userList.getUserList()));
        }
        if (command.equals("logout")) {
            userList.logout(login);
        }
        if (command.equals("in")) {
            userList.signIn(login);
        }
    }

    private void init(HttpServletRequest req) {
        json = new Json();
        login = req.getParameter("login");
        command = req.getParameter("command");
    }
}
