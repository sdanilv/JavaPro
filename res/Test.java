public class Test {

    @ParameterSource(first = "first", second = " second")
    private void seePararmeter(String first, String second) {
        System.out.print(first);
        System.out.println(second);
    }

}
