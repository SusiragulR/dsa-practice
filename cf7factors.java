public class cf7factors {
    public static void factorsOf(int n){
        int i=1;
        while (i<=n/2){
            if (n%i==0){
                System.out.println(i);
            }
            i++;
        }
    }

    public static void main(String[] args) {
        factorsOf(1000);
    }
}
