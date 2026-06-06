import java.util.ArrayList;

public class cf243 {
    public ArrayList<String> generateIp(String s) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> ans = new ArrayList<>();

        if(s.length() > 12) return ans;

        generateIpUtil(0, 0, sb, s, ans);

        return ans;
    }

    public static void generateIpUtil (
            int indx,
            int numOfDots,
            StringBuilder sb,
            String s,
            ArrayList<String> ans
    ) {
        //base
        if (numOfDots == 4 && indx == s.length()) {
            ans.add(sb.substring(0, sb.length() - 1));
            return;
        }

        if(numOfDots > 4) return;

        for (
                int j = indx;
                j < Math.min(indx+3, s.length());
                j++
        ) {
            String presentNum = s.substring(indx, j+1);
            int presentNumInt = Integer.parseInt(presentNum);

            if (
                (j==indx || presentNum.charAt(0)!='0') &&
                presentNumInt<=255
            ) {
                int len = sb.length();
                sb.append(presentNum).append('.');
                generateIpUtil(j+1, numOfDots+1, sb, s, ans);
                sb.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
        cf243 solution = new cf243();

        String s1 = "255678166";
        String s2 = "25505011535";
        String s3 = "25525511135";

        System.out.println( solution.generateIp(s1) );
    }
}
