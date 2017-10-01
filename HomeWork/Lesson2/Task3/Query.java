package Lesson2.Task3;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "query")
public class Query {

    Results results;

    public Query() {
    }

    public Query(Results results) {
        this.results = results;
    }

    @XmlElement(name = "results")
    public void setResults(Results results) {
        this.results = results;
    }

    public Results getResults() {
        return results;
    }


}