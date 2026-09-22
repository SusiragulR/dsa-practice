package DynamicProgramming;

public class DP6NinjaTraining {
    //Recursion
//    public static int ninjaTraining(int n, int points[][]) {
//        return ninjaTrainingUtil(n-1, 3, points);
//    }
//
//    public static int ninjaTrainingUtil(int i, int prevActivity, int[][] points) {
//        if(i==0) {
//            int maxi = 0;
//            for(int j=0; j<=2; j++) {
//                if(j!=prevActivity) {
//                    maxi = Math.max( maxi, points[i][j] );
//                }
//            }
//
//            return maxi;
//        }
//
//        int maxi = 0;
//        for(int j=0; j<=2; j++) {
//            if(j!=prevActivity) {
//                maxi = Math.max(
//                        maxi,
//                        points[i][j] +  ninjaTrainingUtil(i-1, j, points)
//                );
//            }
//        }
//
//        return maxi;
//    }

    //------------------------

    //Memoisation
//    public static int ninjaTraining(int n, int points[][]) {
//        int[][] dp = new int[n][3];
//
//        return ninjaTrainingUtil(n-1, 3, points, dp);
//    }
//
//    public static int ninjaTrainingUtil(int i, int prevActivity, int[][] points, int[][] dp) {
//        if(i==0) {
//            int maxi = 0;
//            for(int j=0; j<=2; j++) {
//                if(j!=prevActivity) {
//                    maxi = Math.max( maxi, points[i][j] );
//                }
//            }
//
//            if(prevActivity<3) dp[0][prevActivity] = maxi;
//            return maxi;
//        }
//
//        int maxi = 0;
//        for(int j=0; j<=2; j++) {
//            if(j!=prevActivity) {
//                maxi = Math.max(
//                        maxi,
//                        points[i][j] + ( dp[i-1][j]!=0 ? dp[i-1][j] : ninjaTrainingUtil(i-1, j, points, dp) )
//                );
//            }
//        }
//
//        if(prevActivity<3) dp[i][prevActivity] = maxi;
//        return maxi;
//    }

    //-------------------------

    //Tabulation
//    public static int ninjaTraining(int n, int points[][]) {
//        int[][] dp = new int[n][3];
//
//        dp[0] = points[0];
//
//        //for each day
//        for(int day=1; day<n; day++) {
//            //for each activity
//            for(int currActivity=0; currActivity<3; currActivity++) {
//                //get max point ninja can get from the past sequence
//                //if that activity is selected
//                int maxIfThisActivityIsChosen = 0;
//
//                for(int prevDayActivity=0; prevDayActivity<3; prevDayActivity++) {
//                    if(currActivity != prevDayActivity) {
//                        maxIfThisActivityIsChosen = Math.max( dp[day-1][prevDayActivity], maxIfThisActivityIsChosen );
//                    }
//                }
//
//                dp[day][currActivity] = points[day][currActivity] + maxIfThisActivityIsChosen;
//            }
//        }
//
//        return Math.max(
//                dp[n-1][0],
//                Math.max( dp[n-1][1], dp[n-1][2] )
//        );
//    }

    //------------------------

    //Space reduction
    public static int ninjaTraining(int n, int[][] points) {
        int[] today = new int[3];
        int[] prevDay = new int[3];

        prevDay = points[0].clone();

        //for each day
        for(int day=1; day<n; day++) {
            //for each activity
            for(int currActivity=0; currActivity<3; currActivity++) {
                //get max point ninja can get from the past sequence
                //if that activity is selected
                int maxIfThisActivityIsChosen = 0;

                for(int prevDayActivity=0; prevDayActivity<3; prevDayActivity++) {
                    if(currActivity != prevDayActivity) {
                        maxIfThisActivityIsChosen = Math.max(
                                prevDay[prevDayActivity],
                                maxIfThisActivityIsChosen
                        );
                    }
                }

                today[currActivity] = points[day][currActivity] + maxIfThisActivityIsChosen;
            }

            prevDay = today.clone();
        }

        return Math.max(
                prevDay[0],
                Math.max( prevDay[1], prevDay[2] )
        );
    }


    public static void main(String[] args) {
        int[][] points1 = {
                {83, 66, 76},
                {40, 15, 72},
                {14, 61, 88},
                {63, 35, 21},
                {58, 24, 61},
                {91, 10, 33},
                {14, 3, 10},
                {54, 84, 39},
                {53, 32, 54},
                {66, 85, 70},
                {77, 2, 22},
                {56, 56, 80},
                {59, 17, 99},
                {5, 43, 38},
                {65, 67, 7},
                {72, 46, 81},
                {45, 78, 74},
                {8, 41, 56},
                {50, 25, 55},
                {8, 47, 57},
                {93, 36, 36},
                {98, 51, 99},
                {16, 90, 14},
                {64, 60, 14},
                {94, 66, 59},
                {45, 78, 19},
                {18, 90, 15},
                {95, 90, 79},
                {64, 26, 5},
                {13, 80, 67},
                {22, 0, 0},
                {62, 27, 82},
                {9, 89, 67},
                {24, 74, 100},
                {35, 35, 46},
                {71, 77, 82},
                {86, 8, 23},
                {61, 99, 55},
                {34, 63, 42},
                {91, 96, 61},
                {96, 69, 53},
                {2, 74, 25},
                {92, 83, 84},
                {58, 22, 11},
                {71, 54, 28},
                {48, 93, 94},
                {82, 86, 81},
                {58, 48, 71},
                {23, 69, 37},
                {58, 85, 20},
                {17, 2, 64},
                {55, 68, 81},
                {83, 56, 12},
                {23, 0, 0},
                {83, 79, 33},
                {46, 19, 13},
                {36, 51, 70},
                {11, 60, 85},
                {96, 26, 74},
                {65, 47, 87},
                {64, 77, 84},
                {50, 81, 75},
                {26, 7, 53},
                {14, 78, 73},
                {1, 34, 74},
                {73, 55, 49},
                {3, 94, 72},
                {13, 5, 79},
                {66, 13, 79},
                {60, 51, 68},
                {65, 47, 14},
                {81, 1, 34},
                {75, 47, 84},
                {83, 71, 95},
                {2, 30, 23},
                {20, 19, 28},
                {25, 35, 23},
                {24, 0, 0},
                {76, 83, 28},
                {75, 2, 60},
                {64, 82, 64},
                {92, 33, 9},
                {81, 9, 12},
                {9, 95, 95},
                {70, 64, 56},
                {25, 54, 4},
                {97, 65, 45},
                {42, 97, 48},
                {32, 1, 53},
                {71, 82, 47},
                {9, 29, 30},
                {28, 53, 18},
                {4, 87, 73},
                {83, 25, 16},
                {97, 78, 69},
                {27, 71, 44},
                {22, 11, 57},
                {56, 43, 9},
                {3, 96, 57},
                {81, 79, 36},
                {92, 75, 11},
                {34, 32, 24}
        };

        System.out.println( ninjaTraining(30, points1) );
    }
}
