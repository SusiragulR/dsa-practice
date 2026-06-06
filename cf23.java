import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class cf23 {
    public static void frequencyCount(int[] arr, int N, int P)
    {
        int[] hashchk = new int[P+1];

        for(int i:arr){
            hashchk[i]++;
        }

        for(int i=0;i<N;i++){
            arr[i]=hashchk[i+1];
        }
    }//TC:O(2N) SC:O(P)

    public static void getFreqCount(int[] arr, int N, int P){
        int i=0;
        while(i<N){
            int e = arr[i];

            System.out.println(i+"->"+e);
            if(e>N || e>P || e<=0) {
                System.out.println(i+"->"+e);
                i++;
                continue;
            };

            if(arr[e-1]>0){
                int temp=arr[e-1];
                arr[e-1]=-1;
                e=temp;
                System.out.println(i+"->"+e);
            }

            if(arr[e-1]==0){
                arr[e-1]=-1;
                e=0;
                System.out.println(i+"->"+e);
                i++;

            }

            if(arr[e-1]<0){
                arr[e-1]--;
                e=0;
                System.out.println(i+"->"+e);
                i++;

            }
            i++;
            System.out.println("****");
        }
    }

    public static void main(String[] args) {
        int[] sample= new int[]{2,3,2,3,5};
        //frequencyCount(sample,5,5);
        getFreqCount(sample,5,5);

        for(int i: sample){
            System.out.print(i+" ");
        }
    }
}
