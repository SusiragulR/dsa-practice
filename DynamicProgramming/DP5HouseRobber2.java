package DynamicProgramming;

public class DP5HouseRobber2 {
    public static int rob(int[] nums) {
        int l = nums.length;

        int prev = 0;
        int prev2 = 0;

        for (int i = 0; i<=l-2; i++) {
            int picked = nums[i] + prev2; //if picked, second prev has to be picked. prev will be adjacent
            int not_picked = prev; //if not picked it's prev element can be picked

            int curr = Math.max(picked, not_picked);
            prev2 = prev;
            prev = curr;
        }

        int skipLast = prev;

        prev = 0;
        prev2 = 0;

        for (int i = 1; i<=l-1; i++) {
            int picked = nums[i] + prev2; //if picked, second prev has to be picked. prev will be adjacent
            int not_picked = prev; //if not picked it's prev element can be picked

            int curr = Math.max(picked, not_picked);
            prev2 = prev;
            prev = curr;
        }

        int skipFirst = prev;

        return Math.max(skipFirst, skipLast);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println( rob(nums) );
    }
}
