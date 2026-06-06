import java.util.HashMap;
import java.util.Map;

public class cf22 {
    static String isSubset(int[] a,int[] b){
        Map<Integer,Integer> hashchk = new HashMap<>();

        for(int i:a){
            if(hashchk.containsKey(i)){
                hashchk.put(i,hashchk.get(i)+1);
            }else{
                hashchk.put(i,1);
            }
        }

        for(int i:b){
            if(hashchk.containsKey(i)){
                hashchk.put(i,hashchk.get(i)-1);
                if(hashchk.get(i)<0){
                    return "No";
                }
            }else{
                return "No";
            }
        }

        return "Yes";
    }//SC:O(a) TC:O(a+b)

    public static void main(String[] args) {
        int[] a=new int[]{1,3,6,9,3,7,4,9,0,22,3,5};
        int[] b=new int[]{1,22,6,9,9,3,4};

        System.out.println(isSubset(a,b));
    }
}
