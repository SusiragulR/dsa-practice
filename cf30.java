import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class cf30 {
    static List<Integer> giveIntersection(int[] a,int[] b){
        int i=0,j=0,n1=a.length,n2=b.length;
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(a);
        Arrays.sort(b);

        while(i<n1 && j<n2){

                    if (a[i] == b[j]) {
                        ans.add(a[i]);
                        i++;
                        j++;
                    } else if (a[i]>b[j]) {
                        j++;
                    } else i++;

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] sample= new int[]{1,2,4,3,6,7,5,7,5,8,9,15,0,0,0};
        int[] sample2= new int[]{15,9,3,6,3,5,5,7};

        List<Integer> intersection = giveIntersection(sample,sample2);
        for(int i: intersection){
            System.out.print(i+" ");
        }
    }
}
