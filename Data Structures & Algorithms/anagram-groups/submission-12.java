class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] cnt = new int[26];
        Map<String, List<String>> mp = new HashMap<>();
        for(String str : strs) {
            Arrays.fill(cnt, 0);
            for(int i=0;i<str.length();++i) {
                ++cnt[str.charAt(i)-'a'];
            }
            StringBuilder s = new StringBuilder();
            for(int i=0;i<26;++i) {
                s.append(cnt[i]).append('#');
            }
            String key = s.toString();
            mp.computeIfAbsent(key, k -> new ArrayList<String>()).add(str);
        }
        System.out.println("map size is: " + mp.size());
        return new ArrayList<List<String>>(mp.values());
    }
}
