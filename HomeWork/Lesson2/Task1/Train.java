package Lesson2.Task1;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "train")
public class Train {

    String id;
    String from;
    String to;
    String date;
    String departure;

    public Train() {
    }

    public Train(String id, String from, String to, String date, String departure) {
        setId(id);
        setTo(to);
        setFrom(from);
        setDate(date);
        setDeparture(departure);
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public void setFrom(String from) {
        this.from = from;
    }

    @XmlElement
    public void setTo(String to) {
        this.to = to;
    }

    @XmlElement
    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement
    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getDeparture() {
        return departure;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id='" + id + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", Date='" + date + '\'' +
                ", departure='" + departure + '\'' +
                '}';
    }
}
