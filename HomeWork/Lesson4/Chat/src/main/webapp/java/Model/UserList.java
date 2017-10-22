package Model;


import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static UserList userList;
    private ArrayList<User> users = new ArrayList<>();

    private UserList() {
    }

    public static UserList newInstance() {
        if (userList == null)
            synchronized (new Object()) {
                if (userList == null) {
                    userList = new UserList();
                }
            }
        return userList;
    }

    synchronized public void add(User user) {
        users.add(user);
    }


    public boolean have(Object user) {
        for (User u : users) {
            if (u.equals(user)) return true;
        }
        return false;
    }

    public List getUserList() {
        return users;
    }

    public boolean equalsName(User user) {
        for (User u : users) {
            if (u.getLogin().equals(user.getLogin())) return true;
        }
        return false;
    }

    public void logout(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                user.setSession(false);
            }
        }
    }

    public void signIn(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                user.setSession(true);
            }
        }
    }
}
