class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sC = new int[26];
        int[] tC = new int[26];
        char[] sS = s.toCharArray();
        char[] tS = t.toCharArray();
        Arrays.sort(sS); Arrays.sort(tS);
        return Arrays.equals(sS, tS);

        // if(s.length() != t.length())
        //     return false;
        // for(int i=0;i<s.length();++i) {
        //     ++sC[s.charAt(i)-'a'];
        // }
        // for(int i=0;i<t.length();++i) {
        //     ++tC[t.charAt(i)-'a'];
        // }
        // for(int i=0;i<26;++i) {
        //     if(sC[i] != tC[i])
        //         return false;
        // }
        // return true;
    }
}
