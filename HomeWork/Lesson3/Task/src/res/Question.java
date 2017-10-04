package res;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "question")
public class Question {
    @XmlElement
    private String name;
//    @XmlElement
//    private AtomicInteger a = new AtomicInteger();
//    @XmlElement
//    private AtomicInteger b = new AtomicInteger();
//    @XmlElement
//    private AtomicInteger c = new AtomicInteger();
//    @XmlElement
//    private AtomicInteger d = new AtomicInteger();
    private int a;
    private int b;
    private int c;
    private int d;

    private Question(){};
    public Question(String name) {
        this.name = name;

    }

    synchronized public void answer(String answer) {

        switch (answer) {
            case "A":
                a++;
//                a.incrementAndGet();
                break;
            case "B":
                b++;
//                b.incrementAndGet();
                break;
            case "C":
                c++;
//                c.incrementAndGet();
                break;
            case "D":
                d++;
//                d.incrementAndGet();
                break;
        }
    }

    public  Question sumQuestion(Question question){
        Question q =new Question(this.name);
        q.a =this.a+question.a;
        q.b =this.b+question.b;
        q.c =this.c+question.c;
        q.d =this.d+question.d;

        return q;
    }
    @Override
    public String toString() {
        return "<p><h3> For " + name + " question </h3></p>" +
                " <p> A answered " + a + " times </p>" + " <p> B answer " + b + " times </p>" +
                " <p> C answered " + c + " times </p>" + " <p> D answered " + d + " times </p>";
    }
}

