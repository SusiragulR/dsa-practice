package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class G7_nMeetingsInRoom {
    public ArrayList<Integer> maxMeetings(int[] start, int[] end) {
        int l = start.length;

        int[][] startEndTimes = new int[l][3];

        for(int i=0; i<l; i++) {
            startEndTimes[i][0] = start[i];
            startEndTimes[i][1] = end[i];
            startEndTimes[i][2] = i;
        }

        Arrays.sort( startEndTimes,
                (a,b) ->  a[1]!=b[1] ? a[1]-b[1]
                        : a[2]-b[2]
        ); //sort by end time and index

        int count = 0;
        int occupiedTill = -1;

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<l; i++) {
            int currStart = startEndTimes[i][0];
            int currEnd = startEndTimes[i][1];

            if(occupiedTill >= currStart) continue;
            else {
                count++;
                ans.add( startEndTimes[i][2] + 1 ); //1 based index is required in ans
                occupiedTill = currEnd;
            }
        }

        Collections.sort( ans );

        return ans;
    }
}
