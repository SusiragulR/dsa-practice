package heaps;

import java.util.ArrayList;

public class h1_minHeapImplementation {
    static class MinHeap {

        ArrayList<Integer> heap;

        //swap-util
        private void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set( i, heap.get(j) );
            heap.set( j, temp );
        }

        //percolate up
        //move up till root or parent is smaller
        private void percolateUp(int i) {
            while(i>0) {
                int parentIndex = (i-1)/2;

                if(heap.get(i) < heap.get(parentIndex)) {
                    swap(i, parentIndex);
                    i = parentIndex;
                } else {
                    break;
                }
            }
        }

        //percolate down
        //move down till reaching a leaf or children are larger
        private void percolateDown(int i) {
            int size = heap.size();

            while(true) {
                int currentSmallest = i;

                int leftChild = 2*i+1;
                int rightChild = 2*i+2;

                if(leftChild < size &&
                        heap.get(leftChild) < heap.get(currentSmallest)
                ) {
                    currentSmallest = leftChild;
                }

                if(rightChild < size &&
                        heap.get(rightChild) < heap.get(currentSmallest)
                ) {
                    currentSmallest = rightChild;
                }

                if(currentSmallest == i) {
                    break;
                } else {
                    swap(i, currentSmallest);
                    i = currentSmallest;
                }
            }
        }

        // Constructor for the class.
        MinHeap(int size) {
            this.heap = new ArrayList<>(size);
        }

        // Implement the function to remove minimum element.
        int extractMinElement() {
            if(heap.size()==0) return -1;


            int minEle = heap.get(0);

            if(heap.size()==1) {
                heap.remove(heap.size()-1);
                return minEle;
            }

            int ind = 0;

            int lastEle = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            heap.set(0, lastEle);

            percolateDown(0);

            return minEle;
        }

        // Implement the function to delete an element.
        void deleteElement(int ind) {
            if(ind >= heap.size()) return;

            int lastEle = heap.get(heap.size()-1);
            heap.remove(heap.size()-1);
            heap.set(ind, lastEle);

            percolateDown(ind);
            percolateUp(ind);
        }

        // Implement the function to insert 'val' in the heap.
        void insert(int val) {
            heap.add(val);

            int i = heap.size()-1;

            percolateUp(i);
        }
    }
}
