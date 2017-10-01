package Lesson2.Task3;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Main {
    public static JAXBContext context;
    public static URL request;
    public static Query query;

    public static void main(String[] args) throws Exception {
        init();
        parseXML();
        seeQuery();
    }

    private static void seeQuery() {
        for(Rate rate:query.results.rates){
            System.out.println(rate);
        }
    }

    private static void init() {
        try {
            request = new URL("http://query.yahooapis.com/v1/public/yql?format=xml&q=select%20*%20from%20" +
                    "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys");
            context = JAXBContext.newInstance(Query.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private static Query parseXML() {
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            query = (Query) unmarshaller.unmarshal(request);
            return query;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}