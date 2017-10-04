package Servlet;

import res.Parser;
import res.Rate;
import res.User;
import res.Users;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "QuestionServlet", urlPatterns = "/QuestionServlet")
public class QuestionServlet extends javax.servlet.http.HttpServlet {

    static Rate rate;
    private Users users = Users.newInstance();
    private final String TAMPLE = "<html><head><title>Rating</title></head><body>" +
            "<center><table cellspacing=10pt border= 1pt cellpadding=10pt><tr><td>" +
            "<h1>You rating of answers</h1>%s</td><td><h1>Rating of all users</h1>%s" +
            "</tr></td></table> <a href=/quiz.jsp>To question</a></center></body></html>";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        rate = user.getRate();
        rate.answerForThreeQuestions(req.getParameter("Q1"),
                req.getParameter("Q2"), req.getParameter("Q3"));
        user.setRate(rate);
        users.add(user);
        Parser.toXML(users);
        resp.getWriter().printf(TAMPLE, user.getRate(), users.rateOfAllUsers());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
