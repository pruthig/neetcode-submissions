class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> mp = new HashMap<>();
        int[] count = new int[26];
        int start = 0;
        int maxLen = 0;
        int maxf = 0;
        for(int i=0;i<s.length();++i) {
            int index = s.charAt(i) - 'A';
            count[index]++;
            maxf = Math.max(maxf, count[index]);
            //int mx = Arrays.stream(count).max().orElse(0);
            while(start < s.length() && i-start+1-maxf > k) {
                int indexs = s.charAt(start) - 'A';
                count[indexs]--;
                //mx = Arrays.stream(count).max().orElse(0);
                ++start;
            }
            maxLen = Math.max(maxLen, i-start+1);
        }
        return maxLen;
    }
}
