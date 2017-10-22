package Server;

import Model.MessageList;
import Util.Json;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetServlet extends HttpServlet {
    MessageList messageList = MessageList.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int position = Integer.parseInt(request.getParameter("position"));
        Json json = new Json();
        json.out(response, json.toJSON(messageList.getFromPosition(position)));
    }
}
