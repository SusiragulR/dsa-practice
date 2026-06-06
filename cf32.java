public class cf32 {
    static long kthElement(int k, int[] arr1, int[] arr2) {

        int i=0, j=0, count=0, el=-1;

        while( i<arr1.length && j<arr2.length ){
            if( arr1[i] <= arr2[j] ){
                count++;
                el = arr1[i];
                if(count == k) return el;
                i++;
            }

            else{
                count++;
                el = arr2[j];
                if(count == k) return el;
                j++;
            }
        }

        while( i<arr1.length ){
            count++;
            el = arr1[i];
            if(count == k) return el;
            i++;
        }

        while( j<arr2.length ){
            count++;
            el = arr2[j];
            if(count == k) return el;
            j++;
        }

        return el;
    }
}
