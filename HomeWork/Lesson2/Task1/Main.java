package Lesson2.Task1;

import javax.xml.bind.*;
import java.io.File;

public class Main {
    static File file;
    static Trains trains;
    static JAXBContext jaxbContext;

    public static void main(String[] args) {
        Train train = new Train("3", "a", "b", "12.09.2017", "15:36");

        try {
            init();
            getTrainsFromXML();
            addTrainInXML(train);
            trains.seeTrainForDeparture("15:00", "19:00");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private static void init() throws JAXBException {
        file = new File("HomeWork/Lesson2/Task1/train.xml");
        jaxbContext = JAXBContext.newInstance(Trains.class);
    }

    private static Trains getTrainsFromXML() throws JAXBException {
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        trains = (Trains) unmarshaller.unmarshal(file);
        return trains;
    }

    private static void addTrainInXML(Train train) throws JAXBException {
        Marshaller marshaller = jaxbContext.createMarshaller();
        trains.add(train);
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(trains, file);
    }
}
