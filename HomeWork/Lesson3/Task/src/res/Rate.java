package res;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Rate {

    @XmlElement(name = "question")
    private List<Question> questions = new ArrayList<>();

    public Rate() {
        add( new Question("first"));
        add( new Question("second"));
        add( new Question("third"));
    }

    public void setQuestions(Question q1, Question q2, Question q3){
        questions.set(0,q1);
        questions.set(1,q2);
        questions.set(2,q3);
    }

//    public void answerForQuestion(int number, String answer){
//        get(number).answer(answer);
//    }

    public void answerForThreeQuestions(String a, String b, String c){
        get(1).answer(a);
        get(2).answer(b);
        get(3).answer(c);
    };
    public void add(Question question) {
        questions.add(question);
    }

    public Question get(int i){
       return questions.get(i-1);
    }

    @Override
    public String toString() {
        return new String(""+get(1) + get(2) + get(3));
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
