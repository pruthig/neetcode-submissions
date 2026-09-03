class Solution {
    public int countSubstrings(String s) {
        int tC = 0;
        for(int i=0;i<s.length();++i) {
            int mid = expandOut(i, i, s);
            int adj = expandOut(i, i+1, s);
            tC += (mid+adj);
        }
        return tC;
    }
    public int expandOut(int s, int e, String str) {
        int count = 0;
        while(s >= 0 && e < str.length()) {
            if(str.charAt(s) != str.charAt(e))
                break;
            ++count;
            --s;
            ++e;
        }
        return count;
    }
}
