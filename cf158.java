import java.util.*;

public class cf158 {
    static ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k)
    {
        ArrayList<Integer> chk = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i=0; i<k; i++){
            if(chk.isEmpty()) chk.add( arr[i] );

            else if (arr[i] >= chk.getLast())  chk.add( arr[i] );

            else {
                for (int j=0; j<chk.size(); j++){
                    if(arr[i] <= arr[j]) chk.add(j,arr[i]);
                }
            }
        }
        System.out.println(chk);

        ans.add(chk.getLast());

        int l=0, r=k-1;
        while (r < n-1){
            chk.remove(arr[l]); //remove l
            l++; //inc l

            r++; //inc r
            //ADD r INTO ANS IN SORTED WAY
            if(chk.isEmpty()) chk.add( arr[r] );

            else if (arr[r] >= chk.getLast())  chk.add( arr[r] );

            else {
                for (int j=0; j<chk.size(); j++){
                    if(arr[r] < arr[j]) chk.add(j,arr[r]);
                }
            }

            ans.add(chk.getLast());
            System.out.println(chk);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{1 ,2 ,3 ,1 ,4 ,5 ,2 ,3 ,6}; //n=9 k=3
        int[] sample2 = new int[]{8 ,5 ,10 ,7 ,9 ,4 ,15 ,12 ,90 ,13}; //n=10 k=4

        System.out.println(max_of_subarrays(sample,9,3));

        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(2);
        ans.add(3);


    }
}
