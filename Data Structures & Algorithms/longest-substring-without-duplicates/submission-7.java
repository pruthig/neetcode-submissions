class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] c = new int[128];
        int mx = 0;
        int start = 0;
        for(int cur = 0; cur<s.length();++cur) {
            int index = s.charAt(cur);
            ++c[index];
            while(c[s.charAt(cur)] > 1 && start<s.length()) {
                --c[s.charAt(start)];
                ++start;
            }
            mx = Math.max((cur-start+1), mx);
        }
        return mx;
    }
}
