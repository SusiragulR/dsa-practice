import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class cf127 {
    static int[] nextGreaterElements(int[] nums) {
        int l=nums.length;
        int[] ans = new int[l];
        int chk;

        for(int i=0; i<l; i++){
            boolean found = false;

            for(int j=i+1; j<(l+i); j++){
                if(j>l-1) chk=j%l; else chk=j;
                if(nums[chk]>nums[i]){
                    ans[i]=nums[chk];
                    found=true;
                    break;
                }
            }

            if(!found) ans[i]=-1;
        }

        return ans;
    }//TC:O(N^2) SC:O(N)

    static int[] giveNextGreatEle(int[] nums){
        int l = nums.length;
        int[] ans = new int[l];
        Stack<Integer> stk = new Stack<>();

        for(int i=2*l-1;i>=0;i--){
            int index = i%l;

            while(!stk.empty() && stk.getLast()<=nums[index]) stk.pop();

            if(i<l) ans[index] = stk.empty() ? -1 : stk.getLast();

            stk.push(nums[index]);
        }

        return ans;
    }//TC:O(4N) SC:O(2N + N)

    public static void main(String[] args) {
        int[] sample = new int[]{1,2,1};
        int[] sample2 = new int[]{1,2,3,4,3};

        int[] ans = nextGreaterElements(sample2);
        for (int i: ans) System.out.print(i+" ");

        System.out.println();

        int[] ans1 = giveNextGreatEle(sample2);
        for (int i: ans1) System.out.print(i+" ");
    }
}
