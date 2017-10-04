package Servlet;

import res.Rate;
import res.User;
import res.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", urlPatterns = "/authorization")
public class AuthorizationServlet extends HttpServlet {
    private final Users users = Users.newInstance();
    HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = users.getUser(request.getParameter("login"), request.getParameter("pass"));
        session.setAttribute("user", user);
        response.sendRedirect(request.getContextPath() + "/quiz.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession(true);
        session.setMaxInactiveInterval(20 * 60);
        User user = (User) session.getAttribute("user");
        if (!users.have(user)) {
            response.sendRedirect(request.getContextPath() + "/authorization.jsp");
        } else response.sendRedirect(request.getContextPath() + "/quiz.jsp");
    }
}
