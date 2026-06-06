import java.util.ArrayList;
import java.util.List;

public class cf249 {
    public static List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        letterCasePermutationsUtil(ans, sb, s, 0);

        return ans;
    }

    public static void letterCasePermutationsUtil(
            List<String> ans,
            StringBuilder sb,
            String s,
            int i
    ) {
        if(i==s.length()){
            ans.add( sb.toString() );
            return;
        }

        char chosenCharacter = s.charAt(i);
        System.out.println("char -> "+chosenCharacter);
        boolean isAlphabet = (chosenCharacter>='a' && chosenCharacter<='z') ||
                (chosenCharacter>='A' && chosenCharacter<='Z');

        if(isAlphabet) {
            sb.append( Character.toUpperCase(chosenCharacter) );
            letterCasePermutationsUtil(ans, sb, s, i+1);
            sb.deleteCharAt(sb.length()-1);

            sb.append( Character.toLowerCase(chosenCharacter) );
            letterCasePermutationsUtil(ans, sb, s, i+1);
            sb.deleteCharAt(sb.length()-1);
        } else {
            sb.append( chosenCharacter );
            letterCasePermutationsUtil(ans, sb, s, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String s1 = "a1B2";

        System.out.println( letterCasePermutation(s1) );
    }
}
