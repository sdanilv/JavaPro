package res;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Parser {

    private static JAXBContext context;
    private static final File FILE = new File("/home/danil/IdeaProjects/JavaPro/HomeWork/Lesson3/Task/src/res/quiz.xml");

    public static void toXML(Users users){
        try {
            Marshaller marshaller =context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(users, FILE);
                } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static Users fromXML(){
        try {
            context = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Users)unmarshaller.unmarshal(FILE);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
return Users.newInstance();
    }

}
