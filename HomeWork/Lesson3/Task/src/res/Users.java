package res;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
public class Users {

    private static Users users;

    @XmlElement(name = "user")
    private Set<User> userList = new HashSet<>();

    public void add(User user) {
        userList.add(user);
    }

    public boolean have(User user) {
        if (user == null) return false;
        for (User u : userList) {
            if (u.equals(user)) return true;
        }
        return false;
    }

    private User backSimilar(User user) {
        for (User u : userList) {
            if (u.equals(user)) return u;
        }
        return null;
    }

    public static Users newInstance() {
        if (users == null) {
            synchronized (new Object()) {
                if (users == null) {
                    return users = Parser.fromXML();
                }
            }
        }
        return users;
    }

    public Rate rateOfAllUsers() {

        Rate rate = new Rate();
        Question q1 = rate.get(1);
        Question q2 = rate.get(2);
        Question q3 = rate.get(3);

        for (User u : userList) {
            q1 = q1.sumQuestion(u.getRate().get(1));
            q2 = q2.sumQuestion(u.getRate().get(2));
            q3 = q3.sumQuestion(u.getRate().get(3));
        }
        rate.setQuestions(q1, q2, q3);
        return rate;
    }

    public User getUser(String login, String pass) {
        User user = new User(login, pass);
        if (have(user)) {
            return backSimilar(user);
        }
        add(user);
        return user;
    }
}


