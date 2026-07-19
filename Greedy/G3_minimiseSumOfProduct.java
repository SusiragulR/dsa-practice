package Greedy;

import java.util.Arrays;

public class G3_minimiseSumOfProduct {
    public int minProductSum(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int sum = 0;
        int l = a.length;

        for(int i=0; i<l; i++) {
            sum += a[i] * b[l-1-i];
        }

        return sum;
    }
}
