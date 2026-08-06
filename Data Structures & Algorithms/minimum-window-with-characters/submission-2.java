class Solution {
    public String minWindow(String s, String t) {
        int uC = 0;
        int[] tArr = new int[128];
        int len = Integer.MAX_VALUE;
        for(int i=0;i<t.length();++i) {
            if(tArr[t.charAt(i)] == 0)
                ++uC;
            ++tArr[t.charAt(i)];
        }
        String res = null;
        int[] sArr = new int[128];
        int start = 0;
        int toMatch = 0;
        for(int i=0;i<s.length();++i) {
            char ch = s.charAt(i);
            ++sArr[ch];
            if(tArr[ch] != 0 && sArr[ch] == tArr[ch])
                ++toMatch;
            if(toMatch != uC)
                continue;
            char sch = s.charAt(start);
            while(start < i && (tArr[sch] == 0) || sArr[sch] > tArr[sch]) {
                --sArr[sch];
                ++start;
                sch = s.charAt(start);
            }
            if((i-start+1) < len) {
                len = (i-start+1);
                res = s.substring(start, (i+1));
            }
        }
        return (len == Integer.MAX_VALUE)?"":res;
    }
}
