class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int[] count = new int[256];
        int start=0, i=0;
        for(;i<s.length();++i) {
            ++count[s.charAt(i)];
            while(count[s.charAt(i)] > 1) {
                --count[s.charAt(start)];
                ++start;
            }
            longest = Math.max(longest, i-start+1);
        }
        return longest;
    }
}
