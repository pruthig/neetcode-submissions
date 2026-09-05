class Solution {
    Set<String> set = null;
    Set<Integer> absent = null;
    public boolean helper(String s, int idx) {
        if(idx == s.length()) {
            System.out.println("ret with index " + idx);
            return true;
        }
        if(absent.contains(idx))
            return false;
        boolean res = false;
        for(int i=idx;i<s.length();++i) {
            String sub = s.substring(idx, i+1);
            if(set.contains(sub)) {
                res = helper(s, i+1);
                if(res)
                    break;
                System.out.println("res is: " + res);
            }
        }
        if(!res) {
            System.out.println("Added " + idx);
            absent.add(idx);
        }
        return res;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>();
        absent = new HashSet<>();
        for(String str : wordDict) {
            set.add(str);
        }
        return helper(s, 0);
    }
}
