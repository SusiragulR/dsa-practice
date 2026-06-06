public class cf81 {
    static double medianOfArrays(int n, int m, int[] a, int[] b)
    {
        if(m>n) return medianOfArrays(m,n,b,a);

        int numOfElementsOnLeft = (m+n+1)/2;
        int total=m+n;

        int low=0, high=m;

        while(low<=high){
            int mid1=low+(high-low)/2;
            int mid2=numOfElementsOnLeft-mid1;

            int l1=Integer.MIN_VALUE;
            int l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int r2=Integer.MAX_VALUE;

            if(mid1<m) r1=a[mid1];
            if(mid2<n) r2=b[mid2];

            if(mid1-1 >=0) l1=a[mid1-1];
            if(mid2-1 >=0) l2=b[mid2-1];

            if(l1<=r2 && l2<=r1) {
                if(total%2==1) return Math.max(l1,l2);
                else return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
            else if(l1>r2) high=mid1-1;
            else low=mid1+1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] sample11 = new int[]{1,5,9};
        int[] sample12 = new int[]{2,3,6,7};
        int[] sample21 = new int[]{2,4,5,6};
        int[] sample22 = new int[]{1,3};

        System.out.println(medianOfArrays(4,3,sample11,sample12));
    }
}
