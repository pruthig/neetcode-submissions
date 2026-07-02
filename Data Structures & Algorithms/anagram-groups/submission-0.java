class Solution {
    public boolean compAnagram(String str1, String str2) {
        int[] ic = new int[26];
        int[] jc = new int[26];
        for(int i=0;i<str1.length();++i) {
            ++ic[str1.charAt(i) - 'a'];
        }
        for(int j=0;j<str2.length();++j) {
            ++jc[str2.charAt(j) - 'a'];
        }
        for(int i=0;i<26;++i)
            if(ic[i] != jc[i])
                return false;
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lst = new ArrayList<>();
        for(int i=0;i<strs.length;++i) {
            String s = strs[i];
            boolean matched = false;
            for(int j=0;j<lst.size();++j) {
                List<String> temp = lst.get(j);
                if(compAnagram(temp.get(0), s)) {
                    temp.add(s);
                    matched = true;
                    break;
                }
            }
            if(!matched) {
                List<String> t = new ArrayList<>();
                t.add(s);
                lst.add(t);
            }
        }
        return lst;
    }
}
