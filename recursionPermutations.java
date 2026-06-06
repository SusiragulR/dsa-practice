import java.util.ArrayList;
import java.util.List;

public class recursionPermutations {
    static void givePossiblePermutations( int[] nums, boolean[] isTaken, List<Integer> perm, List<List<Integer>> ans ){
        //BASE CASE
        if(perm.size()==nums.length){
            ans.add( new ArrayList<>(perm) );
            return;
        }

        //IN THE ABOVE BASE CASE IF WE USE ans.add(perm) IT WON'T GIVE EXPECTED ANSWER, BECAUSE

//        Here’s what happens in detail:
//
//        perm Reference: When you do ans.add(perm), you are adding a reference to the same perm list in ans.
//
//                Modifying perm: During the recursive process, elements are added to and removed from perm as the function
//                explores different permutations.
//
//                Backtracking: Eventually, the recursion backtracks by removing elements from perm until it becomes empty.
//
//                Result: Since all entries in ans point to the same perm list, by the time the function has finished executing, perm is empty,
//                and all references in ans show an empty list.
//
//        To avoid this, you must create a new list (new ArrayList<>(perm)) each time you add a permutation to ans. This way, each entry in ans is independent and does not change when perm is modified in subsequent recursive calls.

        //RECURSIVE CASE
        for( int i=0; i< nums.length; i++){
            if(!isTaken[i]){
                isTaken[i] = true; //note the element as taken
                perm.add( nums[i] ); //add the element to perm

                givePossiblePermutations( nums, isTaken, perm, ans); //recursive call
                perm.remove(perm.size()-1); //remove the inserted element
                isTaken[i] = false; //note the element as not taken
            }
        }
    }

    static List<List<Integer>> givePerms(int[] nums) {
        boolean[] isTaken = new boolean[nums.length];
        List<Integer> perm = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        givePossiblePermutations( nums, isTaken, perm, ans );

        return ans;
    }

    //*************************************************
    //*************************************************
    //*************************************************
    //***************** SWAP APPROACH *****************
    static void giveSwapMethodPermutations( int[] nums, List<List<Integer>> ans, int ptr ){
        //BASE CASE
        if(ptr == nums.length-1){
            List<Integer> copy = new ArrayList<>();
            for(int i : nums) copy.add(i);
            ans.add( copy );
            return;
        }

        //RECURSIVE CASE
        for( int i=ptr; i<nums.length; i++){
            swap( nums, i, ptr ); //swap
            giveSwapMethodPermutations( nums, ans, ptr+1); //recursive call
            swap( nums, i, ptr ); //re-swap
        }
    }

    static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{3,2,1};

        //using extra space
        List<List<Integer>> ans = givePerms(sample);
        for( List<Integer> i : ans ) System.out.println(i);

        //without extra space
        //using swap method
        List<List<Integer>> ans1 = new ArrayList<>();
        giveSwapMethodPermutations( sample, ans1, 0);
        for ( List<Integer> i : ans1 ) System.out.println(i);
    }
}
