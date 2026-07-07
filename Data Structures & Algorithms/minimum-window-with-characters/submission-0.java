class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length())
            return "";
        int matched=0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<t.length();++i) {
            char c= t.charAt(i);
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        int start = 0;
        int st=0,et=0;
        for(int i=0;i<s.length();++i) {
            char c = s.charAt(i);
            window.put(c, window.getOrDefault(c, 0)+1);
            if(need.containsKey(c) && window.get(c) == need.get(c))
                ++matched;
            if(matched == need.size()) {
                // try shortening it
                char startc = s.charAt(start);
                while(!need.containsKey(startc) || (window.get(startc)>need.get(startc))) {
                    window.put(startc, window.get(startc)-1);
                    ++start;
                    startc = s.charAt(start);
                }
                if(i-start+1 < minLen) {
                    st = start;
                    et = i;
                    minLen = i-start+1;
                }
                minLen = Math.min(i-start+1, minLen);
            }
        }
        if(minLen == Integer.MAX_VALUE)
            return "";
        else
            return s.substring(st, et+1);
    }
}
