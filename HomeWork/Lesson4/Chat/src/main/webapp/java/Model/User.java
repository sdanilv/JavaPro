package Model;

public class User {
    private String login;
    private String pass;
    private boolean session;


    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (!login.equals(user.login)) return false;
        return pass.equals(user.pass);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + pass.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", session=" + session +
                '}';
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public void setSession(boolean session) {
        this.session = session;
    }

}
