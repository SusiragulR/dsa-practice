import java.util.ArrayList;
import java.util.List;

public class pattern {
    static void printPat(int n) {
        for(int i=n;i>=1;i--){
            for(int j=n;j>=1;j--){
                for(int k=0;k<i;k++) {
                    System.out.print(j+" ");
                }
            }
            System.out.print("$");
        }
    }

    public static List<Integer> pattern(int N){

        List<Integer> ans = new ArrayList<>();

        printIncrement(printDecrement(N,ans)+5, N, ans);

        return ans;
    }

    static int printDecrement( int N, List<Integer> ans ){
        ans.add(N);
        if(N<0) return N;
        return printDecrement( N-5, ans );
    }

    static void printIncrement( int N, int target, List<Integer> ans ){
        ans.add(N);
        if(N==target) return;
        else printIncrement( N+5, target, ans);
    }

    public static void main(String[] args) {
        List<Integer> ans = pattern(15);
        System.out.println(ans);
    }
}
