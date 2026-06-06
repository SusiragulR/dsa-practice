import java.util.ArrayList;
import java.util.List;

public class stringPerms {
    static void givePossiblePerms (String str, List<List<Character>> ans, boolean[] isTaken, List<Character> toAdd){
        //base
        if(toAdd.size()==str.length()){
            ans.add(new ArrayList<>(toAdd));
            return;
        }

        //recur
        for (int i=0; i<str.length(); i++){
            if(!isTaken[i]){
                isTaken[i] = true;
                toAdd.add(str.charAt(i));
                givePossiblePerms(str, ans, isTaken, toAdd);
                toAdd.remove(toAdd.size()-1);
                isTaken[i] = false;
            }
        }
    }

    static void printPerms(String str){
        List<List<Character>> ans = new ArrayList<>();
        List<Character> toAdd = new ArrayList<>();
        boolean[] isTaken = new boolean[str.length()];

        givePossiblePerms(str, ans, isTaken, toAdd);

        for (List<Character> i : ans) System.out.println(i);
    }

    public static void main(String[] args) {
        printPerms("abcd");
    }
}
