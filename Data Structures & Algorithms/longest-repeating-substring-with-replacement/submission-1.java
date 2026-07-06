class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start=0, mxC = 0;
        int max = 0;
        for(int i=0;i<s.length();++i) {
            count[s.charAt(i) - 'A']++;
            max = Math.max(max, count[s.charAt(i) - 'A']);
            while(i-start+1-max>k && start<i) {
                count[s.charAt(start) - 'A']--;
                ++start;
            }
            mxC = Math.max(mxC, i-start+1);
        }
        return mxC;
    }
}
