import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class cf17repetitive_number {
    public int findDuplicate(int[] arr) { // didn't pass all test cases

        int n = arr.length;
        int sum_of_array = 0;
        int sum_of_array_of_squares = 0;

        for (int i: arr) {
            sum_of_array += i;
            sum_of_array_of_squares += ( i*i );
        }

        int diff_of_n = (n*(n+1))/2 - sum_of_array; // actual sum - sum of array
        int diff_of_n2 = (
                ( n * (n+1) * ((2*n)+1) ) /6
        ) - sum_of_array_of_squares; // ( actual sum of sqrs - sum of array of sqrs )

        int A = diff_of_n;
        int B = diff_of_n2 / diff_of_n;

        int missing_number = (A+B)/2;
        int repetitive_number = missing_number - A;

        return (int)repetitive_number;
    }

    public int findDuplicateByBITOperators(int[] arr) {
        int n = arr.length;
        int xorOfAllValues = 0;

        // find xor of 1 to n-1 inclusive
        for (int i=1; i<=n-1; i++) {
            xorOfAllValues = xorOfAllValues ^ i;
        }
        System.out.println("xorOfN: "+ xorOfAllValues);

        // find xor of given arr
        for (int i=0; i<n; i++){
            xorOfAllValues = xorOfAllValues ^ arr[i];
        }
        System.out.println("xorOfGivenArray: "+ xorOfAllValues);

        return xorOfAllValues;
    }

    public int findRepetitiveByNegativeMarkingApproach (int[] arr) {
        for (int i: arr) {
            int index_to_be_marked = Math.abs(i)-1;

            if(arr[index_to_be_marked] < 0) return Math.abs(i);
            else arr[index_to_be_marked] *= -1;
        }

        return -1;
    }

    public static void main(String[] args) {
        try {
            // Read file contents
            BufferedReader br = new BufferedReader(new FileReader("cf17-input.txt"));
            String line = br.readLine().trim();
            br.close();

            // Remove brackets [ ] and split by commas
            line = line.substring(1, line.length() - 1);
            String[] parts = line.split(",");

            // Convert to int[]
            int[] arr = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                arr[i] = Integer.parseInt(parts[i].trim());
            }

            int[] arr2 = new int[]{1, 2, 3, 4, 3};

            // Call function
            cf17repetitive_number obj = new cf17repetitive_number();
            int result1 = obj.findDuplicate(arr);
            int result2 = obj.findDuplicateByBITOperators(arr);
            int result3 = obj.findRepetitiveByNegativeMarkingApproach(arr);

            // Print result
            System.out.println("Repetitive number: " + result1);
            System.out.println("Repetitive number: " + result2);
            System.out.println("Repetitive number: " + result3);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
