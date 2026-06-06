public class cf13maxminofarray {
    public static void maxminOf(int[] arr){
        int max=arr[0],min=arr[0],i=0;

        while (i<arr.length){
            if(arr[i]<min) min=arr[i];
            if(arr[i]>max) max=arr[i];
            i++;
        }

        System.out.println("max:"+max);
        System.out.println("min:"+min);
    }

    public static void main(String[] args) {
        int[] myArr = new int[]{50,22,41,14,3};

        maxminOf(myArr);
    }
}
