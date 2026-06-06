public class cf168 {
    static int countOccurencesOfAnagrams(String pat, String txt) {
        int nTxt = txt.length();
        int nPat = pat.length();

        int[] freqPat = new int[26];
        int[] freqText = new int[26];

        for(int i=0; i<nPat; i++) {
            int indxOfChar = pat.charAt(i) - 'a';
            freqPat[indxOfChar]++;
        }

        int required = nPat;
        int formed = 0;

        int ansCount = 0;

        int l=0;
        for(int r=0; r<nTxt; r++) {
            char cAtr = txt.charAt(r);
            int indxOfcAtr = cAtr - 'a';
            freqText[indxOfcAtr]++;

            formed++;

            while(freqText[indxOfcAtr] > freqPat[indxOfcAtr]) {
                freqText[txt.charAt(l) - 'a']--;
                l++;
                formed--;
            }


            if (r>=l && formed==required) {
                ansCount++;
            }
        }

        return ansCount;
    }

    public static void main(String[] args) {
        String pat1 = "for";
        String txt1 = "forxxorfxdofr";

        String pat2 = "aaba";
        String txt2 = "aabaabaa";

        String pat3 = "fr";
        String txt3 = "ffffffffffffffffr";

        String pat4 = "aba";
        String txt4 = "aaba";

        System.out.println(countOccurencesOfAnagrams(pat1, txt1));
        System.out.println(countOccurencesOfAnagrams(pat2, txt2));
        System.out.println(countOccurencesOfAnagrams(pat3, txt3));
        System.out.println(countOccurencesOfAnagrams(pat4, txt4));
    }
}
