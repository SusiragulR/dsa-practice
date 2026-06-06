public class cf15 {
    static int search(int arr[], int x) {

        int oi=-1,i=0;
        while(i<arr.length){
            if (arr[i]==x){
                return i;
            }
            i++;
        }

        return oi;
    }

    public static void main(String[] args) {
        int[] myArr = new int[]{1,2,3,4,6,7};

        System.out.println(search(myArr,3));
    }
}
