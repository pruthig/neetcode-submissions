class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length()<s1.length())
            return false;
        Map<Character, Integer> mp1 = new HashMap<>();
        Map<Character, Integer> mp2 = new HashMap<>();
        int k=s1.length();
        for(int i=0;i<s1.length();++i) {
            mp1.put(s1.charAt(i), mp1.getOrDefault(s1.charAt(i), 0)+1);
        }
        int matched = 0;
        for(int i=0;i<s2.length();++i) {
            char curc = s2.charAt(i);
            
            mp2.put(curc, mp2.getOrDefault(curc, 0)+1);
            if(mp1.containsKey(curc)) {
                if(mp1.get(curc) == mp2.get(curc))
                    ++matched;
                else if(mp2.get(curc) == mp1.get(curc) + 1)
                    --matched;
            }
            if(i>=k) {
                char startc = s2.charAt(i-k);
                mp2.put(startc, mp2.get(startc)-1);
                if(mp1.containsKey(startc)) {
                    if(mp2.get(startc) == mp1.get(startc)-1)
                        --matched;
                    else if(mp2.get(startc) == mp1.get(startc))
                        ++matched;
                }
            }
            if(matched == mp1.size())
               return true;
        }
        return false;
    }
}
