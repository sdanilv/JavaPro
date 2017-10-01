package Lesson2.Task1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "trains")
public class Trains {

    @XmlElement(name = "train")
    List <Train> trains = new ArrayList<>();

    public void add(Train train){
        trains.add(train);
    }

    public void seeTrainForDeparture(String from, String to){
        for (Train train:trains){
            if(train.departure.compareTo(from)>=0&&train.departure.compareTo(to)<=0)
                System.out.println(train);
        }
    }

    @Override
    public String toString() {
        return Arrays.deepToString(trains.toArray());
    }
}
