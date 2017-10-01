package Lesson2.Task3;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rate")
public class Rate {

    @XmlAttribute
    public String id;
    public String Name;
    public String Rate;
    public String Date;
    public String Time;
    public String Ask;
    public String Bid;

    public Rate(){}

    public Rate(String id, String name, String date, String time, String ask, String bid, String rate) {
        this.id = id;
        this.Name = name;
        this.Date = date;
        this.Time = time;
        this.Ask = ask;
        this.Bid = bid;
        this.Rate = rate;
    }
//
//    public String getRate() {
//        return Rate;
//    }
//
//    public void setRate(String rate) {
//        Rate = rate;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String name) {
//        this.Name = name;
//    }
//
//    public String getDate() {
//        return Date;
//    }
//
//    public void setDate(String date) {
//        this.Date = date;
//    }
//
//    public String getTime() {
//        return Time;
//    }
//
//    public void setTime(String time) {
//        this.Time = time;
//    }
//
//    public String getAsk() {
//        return Ask;
//    }
//
//    public void setAsk(String ask) {
//        this.Ask = ask;
//    }
//
//    public String getBid() {
//        return Bid;
//    }
//
//    public void setBid(String bid) {
//        this.Bid = bid;
//    }


    @Override
    public String toString() {
        return "rate{" +
                "id='" + id + '\'' +
                ", Name='" + Name + '\'' +
                ", Date='" + Date + '\'' +
                ", Time='" + Time + '\'' +
                ", Ask='" + Ask + '\'' +
                ", Bid='" + Bid + '\'' +
                '}';
    }
}


