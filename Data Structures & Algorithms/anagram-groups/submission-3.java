class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lst = new ArrayList<>();
        Map<String, List<String>> mp = new HashMap<>();
                
        for(int i=0;i<strs.length;++i) {
            String s = strs[i];
            int[] ic = new int[26];
            for(char c : s.toCharArray()) {
                ++ic[c - 'a'];
            }
            String key = Arrays.toString(ic);
            boolean matched = mp.containsKey(key);
            if(matched)
                mp.get(key).add(s);
            else {
                List<String> n = new ArrayList<>();
                n.add(s);
                mp.put(key, n);
            }
        }
        return new ArrayList<>(mp.values());
    }
}
