public class cf14thirdLargest {
    public static int thirdLargestOf(int[] arr){
        //ONLY NON-REPETITIVE ELEMENT ARRAY CAN BE USED
        int i=0;
        int[] newArr = new int[arr.length];

        while(i<arr.length){
            int j=0,gc=0;
            System.out.println(arr[i]);

            while (j<arr.length){
                if(arr[j]>arr[i]){
                    gc+=1;
                }
                j++;
            }

            newArr[newArr.length-1-gc]=arr[i];

            //To print the greatCount and modifed newArr[]
            System.out.println("//"+gc+"//");
            for(int z=0;z<newArr.length;z++){
                System.out.print(newArr[z]+" ");
            }
            System.out.println();
            //////////////////////////////////////////////

            i++;
        }
        return newArr[arr.length-3];//To make it easier return when gc=2
    }

    public static void main(String[] args) {
        int[] myArr = new int[]{9,2,5,3,6,4,7,1};

        System.out.println(thirdLargestOf(myArr));
    }
}
