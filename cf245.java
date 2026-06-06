import java.util.ArrayList;

public class cf245 {
    public static String kthPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> possibilities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            possibilities.add(i+1);
        }

        kthPermutationUtil(possibilities, sb, k-1);

        return sb.toString();
    }

//    private static void kthPermutationUtil(
//            ArrayList<Integer> possibilities,
//            StringBuilder sb,
//            int nthPermutation
//    ) {
//        int possibleSets = factorial(nthPermutation-1);
//        int indexChosen = nthPermutation / possibleSets;
//        sb.append( possibilities.get(indexChosen) );
//        possibilities.remove( indexChosen );
//
//        if(possibilities.isEmpty()) return;
//
//        kthPermutationUtil(possibilities, sb, nthPermutation % possibleSets);
//    }

    private static void kthPermutationUtil(
            ArrayList<Integer> possibilities,
            StringBuilder sb,
            int k
    ) {
        if (possibilities.isEmpty()) return;

        int blockSize = factorial(possibilities.size() - 1);

        int indexChosen = k / blockSize;

        sb.append(possibilities.get(indexChosen));
        possibilities.remove(indexChosen);

        kthPermutationUtil(possibilities, sb, k % blockSize);
    }

    private static int factorial(int n) {
        if(n==1 || n==0) return 1;

        return n * factorial(n-1);
    }

    public static void main(String[] args) {
        int n1=4, k1=3;
        int n2=4, k2=17;
        int n3=3, k3=5;

        System.out.println(kthPermutation(n1, k1));
        System.out.println(kthPermutation(n2, k2));
        System.out.println(kthPermutation(n3, k3));
    }
}
