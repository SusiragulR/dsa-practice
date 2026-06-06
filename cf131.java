public class cf131 {
    static int trapRainWater(int[] arr){
        int n = arr.length;
        int lMax=0, rMax=0, l=0, r=n-1;
        long total = 0;

        while(l<r){
            if(arr[r]>=arr[l]){
                if(lMax>=arr[l]) total += (lMax - arr[l]);
                else lMax=arr[l];
                l+=1;
            }
            else{
                if(rMax>=arr[r]) total += (rMax - arr[r]);
                else rMax=arr[r];
                r-=1;
            }
        }

        return (int)total;
    }

    public static void main(String[] args) {
        int[] sample = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        int[] sample2 = new int[]{4,2,0,3,2,5};

        System.out.println(trapRainWater(sample2));
    }
}
