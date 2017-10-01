package Lesson2.Task3;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "results")
public class Results {

    public Results(Rate rate) {
        add(rate);
    }


    public Results() {
    }

    @XmlElement(name = "rate")
    public List<Rate> rates = new ArrayList<>();

    public void add(Rate rate) {
        rates.add(rate);
    }

}
