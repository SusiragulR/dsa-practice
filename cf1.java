public class cf1 {
    public static boolean isEven(int n) {
        return (n%2==0);
    }

    public static void main(String[] args) {
        if (isEven(7)) {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}
