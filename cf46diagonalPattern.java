import java.util.*;

public class cf46diagonalPattern {
    static int[] matrixDiagonally(int[][] mat) {

        Map<Integer, List<Integer>> hashChk = new HashMap<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                int sum=i+j;
                if(hashChk.containsKey(sum)){
                    List<Integer> addend = hashChk.get(sum);
                    addend.add(mat[i][j]);
                    hashChk.put( sum,addend );
                }
                else{
                    List<Integer> addend = new ArrayList<>();
                    addend.add(mat[i][j]);
                    hashChk.put( sum,addend );
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<=( (mat.length-1)+(mat[0].length-1) );i++){
            if(i%2==0){
                List<Integer> toAdd = hashChk.get(i);
                Collections.reverse(toAdd);
                ans.addAll(toAdd);
            }
            else{
                List<Integer> toAdd = hashChk.get(i);
                ans.addAll(toAdd);
            }
        }

        int[] ansArray = new int[ans.size()];

        for(int i=0;i<ans.size();i++){
            ansArray[i]=ans.get(i);
        }

        return ansArray;
    }

    public static void main(String[] args) {
        int[][] sample = new int[][]{{0,1,2},{3,4,5},{6,7,8}};

        int[] ans = matrixDiagonally(sample);

        for(int i: ans){
            System.out.print(i+" ");
        }
    }
}
