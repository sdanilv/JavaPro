package res;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class User {
    private String login;
    private String pass;
    private Rate rate;

    private User() {
    }

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
        rate = new Rate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return pass != null ? pass.equals(user.pass) : user.pass == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        return result;
    }

    @XmlElement
    public void setRate(Rate rate) {
        this.rate = rate;
    }

    @XmlElement
    private void setLogin(String login) {
        this.login = login;
    }

    @XmlElement
    private void setPass(String pass) {
        this.pass = pass;
    }

    public Rate getRate() {
        return rate;
    }

    private String getLogin() {
        return login;
    }

    private String getPass() {
        return pass;
    }
}

