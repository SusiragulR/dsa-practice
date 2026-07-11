package heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class h16_medianOfAstream {
    public ArrayList<Double> getMedian(int[] arr) {
        //have 2 heaps
        //smallHeap - a max heap
        //largeHeap - a min heap

        //all elements in smallHeap <= all elements in LargeHeap

        //for each insertion, the above condition have to be met

        //The length difference between the heaps should be 0 or 1

        ArrayList<Double> ans = new ArrayList<>();

        PriorityQueue<Integer> smallPq = new PriorityQueue<>( (a, b) -> b-a ); //max heap
        PriorityQueue<Integer> largePq = new PriorityQueue<>(); //min heap

        for(int i=0; i<arr.length; i++) {
            //insert blindly into smallHeap
            smallPq.add(arr[i]);

            //check condition
            if(
                    !smallPq.isEmpty() &&
                            !largePq.isEmpty() &&
                            smallPq.peek() > largePq.peek()
            ) {
                largePq.add( smallPq.poll() );
            }

            //check length difference
            if(smallPq.size() - largePq.size() > 1) {
                largePq.add( smallPq.poll() );
            }

            if(largePq.size() - smallPq.size() > 1) {
                smallPq.add( largePq.poll() );
            }

            if(largePq.size() == smallPq.size()) {
                ans.add(
                        ((double) smallPq.peek() + (double) largePq.peek()) / 2
                );
            } else if (smallPq.size() > largePq.size()) {
                ans.add((double) smallPq.peek());
            } else {
                ans.add((double) largePq.peek());
            }
        }

        return ans;
    }
}
