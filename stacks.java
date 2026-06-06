import java.util.HashSet;
import java.util.Objects;
import java.util.Stack;

public class stacks {
    static int giveAns(String[] str){
        int count=0;

        for(String i:str){
            if(Objects.equals(i, "X++") || Objects.equals(i, "++X")) count++;
            else count--;
        }

        return count;
    }

    static void shuffle(int[] arr,int n){
        int i=1,j=n;

        while(i<2*n-2 && j<2*n){
            System.out.println("i:"+(i+1)+"-->i+1:"+(i+2));


            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;

            if(i+1!=j && j<2*n-1) {
                System.out.println("i:"+(i+1)+"-->j:"+(j+1));
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }

            i+=2;
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        
        System.out.println(!stk.empty() ? stk.pop() : -1);
        stk.push(8);
        stk.push(-1000);
        System.out.println(stk.peek());

//        String[] str = new String[]{"--X","X++","X++"};

//        int[] sample = new int[]{1,2,3,4,5,6,7,8,9,10};
//        shuffle(sample,5);
//        for(int i:sample) System.out.print(i+" ");
    }
}
