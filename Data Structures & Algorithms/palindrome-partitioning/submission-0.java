class Solution {
    List<List<String>> res = null;
    public void helper(int idx, String s, List<String> lst) {
        if(idx>=s.length()) {
            System.out.println("list size is: " + lst.size());
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i=idx;i<s.length();++i) {
            String substr = s.substring(idx, i+1);
            String reversed = new StringBuilder(substr).reverse().toString();
            if(substr.equals(reversed)) {
                lst.add(substr);
                helper(i+1, s, lst);
                lst.remove(lst.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<String> lst = new ArrayList<>();
        res = new ArrayList<>();
        helper(0, s, lst);
        return res;
    }
}
