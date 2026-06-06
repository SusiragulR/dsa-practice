public class cf37countInversions {
    static int numOfInversions(int[] arr){
        int count=0;

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]) count++;
            }
        }

        return count;
    }//TC:O(N^2) SC:O(1)

    public static void main(String[] args) {
        int[] sample = new int[]{5,4,7};
        int[] sample2 = new int[]{10,10,10};

        System.out.println(numOfInversions(sample2));
    }
}
