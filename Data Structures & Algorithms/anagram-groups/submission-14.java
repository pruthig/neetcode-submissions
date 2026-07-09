class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int x=0;x<strs.length;++x) {
            String str = strs[x];
            int[] count = new int[26];
            for(int i=0;i<str.length();++i) {
                int index = str.charAt(i) - 'a';
                count[index]++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;++i) {
                sb.append(count[i]).append('#');
            }
            String key = sb.toString();
            map.computeIfAbsent(key, k->new ArrayList<String>()).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
