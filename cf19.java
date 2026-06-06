import java.util.HashMap;
import java.util.Map;

public class cf19 {
    public static boolean isEqual(int[] a,int[] b){
        if(a.length!=b.length){
            return false;
        }

        Map<Integer,Integer> hashchk = new HashMap<>();

        for (int i=0;i<a.length;i++) {
            if(hashchk.containsKey(a[i])){
                hashchk.put(a[i], hashchk.get(a[i])+1);
            }else{
                hashchk.put(a[i],1);
            }

            if(hashchk.containsKey(b[i])){
                hashchk.put(b[i], hashchk.get(b[i])-1);
            }else{
                hashchk.put(b[i],-1);
            }
        }

        for(int key : hashchk.keySet()){
            if(hashchk.get(key)!=0){
                return false;
            }
        }
        return true;
    }//TC:O(2N) ~ O(N)   //SC:O(2N)

    static boolean isEqualUsingXORMethod(int[] a,int[] b) { //FAILED FOR REPETITIVE NUMBERS
        int n = a.length;
        int xorResult = 0;

        for(int i = 0; i < n; i++) {
            xorResult = xorResult ^ a[i] ^ b[i];  //FAILED FOR REPETITIVE NUMBERS
        }

        return xorResult == 0; //FAILED FOR REPETITIVE NUMBERS
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,3,6,2,1,0,1,1};
        int[] b = new int[]{2,1,0,6,3,5,1,1};

        //FAILED FOR REPETITIVE NUMBERS in XOR Method CASE
        int[] c = new int[]{1,1,2,2,2};
        int[] d = new int[]{2,1,1,1,1};

        System.out.println(isEqual(a,b));
        System.out.println(isEqualUsingXORMethod(c,d));
    }
}
