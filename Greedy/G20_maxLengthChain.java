package Greedy;

import java.util.Arrays;

public class G20_maxLengthChain {
    public int maxChainLen(int arr[][]) {
        Arrays.sort( arr, (a, b) -> a[1]-b[1] );

        int length = 1;
        int lastIndex = arr[0][1];

        for(int i=1; i<arr.length; i++) {

            if(arr[i][0] > lastIndex) {
                length++;
                lastIndex = arr[i][1];
            }

        }

        return length;
    }
}
