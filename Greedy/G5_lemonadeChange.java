package Greedy;

public class G5_lemonadeChange {
    public boolean canServe(int[] arr) {
        int[] counts = new int[]{0, 0, 0}; //counts of 5, 10 and 20

        for(int amt: arr) {
            if(
                    !checkAndGiveChange(amt, counts)
            ) return false;
        }

        return true;
    }

    public boolean checkAndGiveChange (
            int amount,
            int[] counts
    ) {
        if(amount == 5){
            //handle 5
            counts[0]++;
            return true;
        }
        else if (amount == 10){
            //handle 10
            if(counts[0] > 0) {
                counts[1]++;
                counts[0]--;
                return true;
            } else return false;
        }
        else {
            //handle 20
            if(counts[0]>0 && counts[1]>0) {
                counts[2]++;
                counts[1]--;
                counts[0]--;
                return true;
            } else if (counts[0]>=3) {
                counts[0]--;
                counts[0]--;
                counts[0]--;
                return true;
            } else return false;
        }
    }
}
