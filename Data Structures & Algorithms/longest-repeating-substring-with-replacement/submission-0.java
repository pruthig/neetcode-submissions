class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start=0, mxC = 0;
        for(int i=0;i<s.length();++i) {
            count[s.charAt(i) - 'A']++;
            int max = Arrays.stream(count).max().orElse(0);
            while(i-start+1-max>k && start<i) {
                count[s.charAt(start) - 'A']--;
                ++start;
                max = Arrays.stream(count).max().orElse(0);
            }
            mxC = Math.max(mxC, i-start+1);
        }
        return mxC;
    }
}
