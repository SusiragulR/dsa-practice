package heaps;

public class h2_minToMaxHeap { //min-heap to max-heap conversion

//    private boolean percolateUp(int[] nums, int i) {
//        boolean hadSwappedPosition = false;
//        int l = nums.length;
//
//        while(i>0) {
//            int parentIndex = (i-1)/2;
//
//            if(parentIndex<l && nums[i]>nums[parentIndex]) {
//                int temp = nums[i];
//                nums[i] = nums[parentIndex];
//                nums[parentIndex] = temp;
//
//                i = parentIndex;
//
//                hadSwappedPosition = true;
//            } else {
//                break;
//            }
//        }
//
//        return hadSwappedPosition;
//    }

    private static void percolateUp(int[] nums, int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (nums[i] > nums[parent]) {
                int temp = nums[i];
                nums[i] = nums[parent];
                nums[parent] = temp;
                i = parent;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int[] nums, int i) {
        int size = nums.length;

        while(true) {
            int currentLargest = i;

            int leftChild = 2*i+1;
            int rightChild = 2*i+2;

            if(leftChild < size &&
                    nums[leftChild] > nums[currentLargest]
            ) {
                currentLargest = leftChild;
            }

            if(rightChild < size &&
                    nums[rightChild] > nums[currentLargest]
            ) {
                currentLargest = rightChild;
            }

            if(currentLargest == i) {
                break;
            } else {
                int temp = nums[i];
                nums[i] = nums[currentLargest];
                nums[currentLargest] = temp;

                i = currentLargest;
            }
        }
    }

    public int[] minToMaxHeap(int[] nums) {
        int l = nums.length;

        //Sifting up every element takes O(n * log n) time. Sifting down only internal nodes takes O(n) time.
        // for(int i=l-1; i>=0; i--) {
        //     boolean shouldPercolateUp = true;

        //     while(shouldPercolateUp) {
        //         shouldPercolateUp = percolateUp(nums, i);
        //     }
        // }

        for(int i=(l/2)-1; i>=0; i--) { // only internal nodes are percolated down
            percolateDown(nums, i);
        }

        return nums;
    }
}
