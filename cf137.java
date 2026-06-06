public class cf137 {
    public static void main(String[] args) {
        String sample = "((2+3)*(5/2))";
        sample = cf134.infixToPostfix(sample);
        System.out.println(cf135.evaluatePostfix(sample));

        //FAILED TEST CASE

//        String sample2 = "(121+(101+0))";
//        sample2 = cf134.infixToPostfix(sample2);
//        System.out.println(sample2);
//        System.out.println(cf135.evaluatePostfix(sample2));
    }
}
