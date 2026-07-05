class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        Set<Character> set = new HashSet<>();
        int start = 0, maxLen = 0;
        for(int i=0;i<s.length();++i) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                while(s.charAt(start) != c) {
                    set.remove(s.charAt(start));
                    ++start;
                }
                ++start;
            } else {
                set.add(c);
                maxLen = Math.max(i-start+1, maxLen);
            }

        }
        return maxLen;
    }
}
