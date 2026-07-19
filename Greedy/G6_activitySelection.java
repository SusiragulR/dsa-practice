package Greedy;

import java.util.Arrays;

public class G6_activitySelection {
    public int activitySelection(int[] start, int[] end) {
        //store an array of startEndTimes
        //startEndTimes is an array which holds start and end times
        int l = start.length;

        int[][] startEndTimes = new int[l][2];

        for(int i=0; i<l; i++) {
            startEndTimes[i][0] = start[i];
            startEndTimes[i][1] = end[i];
        }

        Arrays.sort( startEndTimes, (a, b) -> a[1]-b[1]); //sort by end time

        //choosing activities with smallest end time
        //will make us chose activities

        int count = 0;
        int occupiedTill = -1;

        for(int i=0; i<l; i++) {
            int currStart = startEndTimes[i][0];
            int currEnd = startEndTimes[i][1];

            if(occupiedTill >= currStart) continue;
            else {
                count++;
                occupiedTill = currEnd;
            }
        }

        return count;
    }
}
