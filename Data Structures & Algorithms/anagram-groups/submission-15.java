class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            int[] c = new int[26];
            for(int i=0;i<str.length();++i)
                ++c[str.charAt(i)-'a'];
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;++i)
                sb.append(c[i]).append('#');
            String key = sb.toString();
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
