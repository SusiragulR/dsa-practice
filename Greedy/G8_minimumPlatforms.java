package Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class G8_minimumPlatforms {
    //PQ approach I thought of
    public int minPlatform(int arr[], int dep[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int numOfPlatformsRequired = 1;

        Arrays.sort(arr);
        Arrays.sort(dep);
        /*
         * LEARNING HINT & INTUITION:
         * 1. For counting total concurrent platforms, train "identities" do not matter.
         *    We only care about global event timelines (how many trains are in the station).
         * 2. Sorting arr[] and dep[] independently turns them into parallel streams of events.
         * 3. By processing chronologically, we match the number of arrivals against the
         *    number of departures up to that exact moment in time.
         * 4. The PriorityQueue (or a 2-pointer approach) acts as our timeline manager,
         *    tracking peak platform overlaps seamlessly!
         */

        for(int i=0; i<arr.length; i++) {
            while( !pq.isEmpty() ) {
                if(pq.peek() < arr[i]) pq.poll();
                else break;
            }

            pq.add( dep[i] );

            //System.out.println( pq );

            numOfPlatformsRequired = Math.max( numOfPlatformsRequired, pq.size() );
        }

        return numOfPlatformsRequired;
    }

    //learnt - 2 pointer approach
    public int minPlatformThroughTwoPinterApproach(int arr[], int dep[]) {
        // 1. Sort both timelines chronologically
        Arrays.sort(arr);
        Arrays.sort(dep);

        int currentPlatforms = 0;
        int maxPlatforms = 0;

        int i = 0; // Pointer for arr[]
        int j = 0; // Pointer for dep[]

        // 2. Walk through time until all trains have arrived
        while (i < arr.length) {

            // If the next event is an arrival
            // (Using <= ensures that if arrival == departure, we process arrival first)
            if (arr[i] <= dep[j]) {
                currentPlatforms++;
                i++; // Move to next arrival
            }
            // If the next event is a departure
            else {
                currentPlatforms--;
                j++; // Move to next departure
            }

            // Track the peak platform count
            maxPlatforms = Math.max(maxPlatforms, currentPlatforms);
        }

        return maxPlatforms;
    }
}
