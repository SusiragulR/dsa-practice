import java.util.*;

public class cf29 {

    //SET APPROACH
    static Set<Integer> unionOf(int[] arr1,int[] arr2){
        int l,l2,max;
        if(arr1.length> arr2.length){
            l= arr1.length;
            l2= arr2.length;
            max = 1;
        }else{
            l= arr2.length;
            l2= arr1.length;
            max = 2;
        }

        Set<Integer> union = new HashSet<>();

        for(int i=0;i<l;i++){
            if(max==1) {
                union.add(arr1[i]);
                if (i < l2) union.add(arr2[i]);
            }else{
                union.add(arr2[i]);
                if (i < l2) union.add(arr1[i]);
            }
        }

        return union;
    }

    //TWO-POINTER APPROACH
    static List<Integer> giveUnionOf(int[] a,int[] b){
        int i=0,j=0,n1=a.length,n2=b.length;
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(a);
        Arrays.sort(b);

        while(i<n1 && j<n2){
            if(i==0 || a[i]!=a[i-1]){
                if(j==0 || b[j]!=b[j-1]){
                    if(a[i]==b[j]){
                        ans.add(a[i]);
                        i++;
                        j++;
                    }
                    else if (a[i]<b[j]) {
                        ans.add(a[i]);
                        i++;
                    }
                    else{
                        ans.add(b[j]);
                        j++;
                    }
                }else j++;
            }else i++;
        }

        while(i<n1){
            if(i==0 || a[i]!=a[i-1]) {
                ans.add(a[i]);
                i++;
            }else i++;
        }

        while(j<n2){
            if(j==0 || b[j]!=b[j-1]){
                ans.add(b[j]);
                j++;
            }else j++;
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] sample= new int[]{1,2,4,3,6,7,3,5,7,5,8,9,15,0,0,0};
        int[] sample2= new int[]{0,0,0,0};

        Set<Integer> ans = unionOf(sample2,sample);
        for(int i: ans){
            System.out.print(i+" ");
        }

        System.out.println("***************");

        List<Integer> union = giveUnionOf(sample,sample2);
        for(int i: union){
            System.out.print(i+" ");
        }

    }
}

