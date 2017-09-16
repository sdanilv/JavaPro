package Lesson1.Task3;

public class Test {
    @Save
    int a;
    @Save
    String b;
    @Save
    RecursiveTest recursiveTest = new RecursiveTest();

    public Test() {
    }

    public Test(int a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Test{" +
                "a=" + a +
                ", b=" + b +
                recursiveTest +
                '}';
    }
}
