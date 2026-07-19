package Greedy;

import java.util.Arrays;

public class G12_fractionalKnapsack {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        double[][] profitAndIndex = new double[val.length][2];

        for(int i=0; i<val.length; i++) {
            profitAndIndex[i][0] = (double)val[i] / (double)wt[i];
            profitAndIndex[i][1] = (double) i;
        }

        Arrays.sort( profitAndIndex, (a, b) -> Double.compare(b[0], a[0]) );

        double totalProfit = 0.000000;

        for(double[] i: profitAndIndex) {
            if(capacity == 0) break;

            //calculate proportion to be taken
            double profitPerUnit = i[0];
            int index = (int) i[1];
            int availableWeight = wt[index];

            if(capacity >= availableWeight) {
                totalProfit += (double) val[index];
                capacity -= availableWeight;
            } else {
                totalProfit += (double)capacity * profitPerUnit;
                break;
            }

        }

        return totalProfit;
    }
}
