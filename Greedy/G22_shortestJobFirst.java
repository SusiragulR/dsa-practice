package Greedy;

import java.util.Arrays;

public class G22_shortestJobFirst {
    static int solve(int bt[]) {
        Arrays.sort(bt);

        int waitTime = 0;
        int sumOfWaitTime = 0;

        for(int i=0; i<bt.length; i++) {
            sumOfWaitTime += waitTime;
            waitTime += bt[i];
        }

        return sumOfWaitTime/bt.length;
    }
}
