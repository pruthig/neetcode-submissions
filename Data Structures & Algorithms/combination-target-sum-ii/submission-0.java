class Solution {
    List<List<Integer>> res;
    public void helper(int[] c, int target, int idx, int cur, List<Integer> lst) {
                if(cur == target) {
            res.add(new ArrayList<>(lst));
            return;
        }
        if(idx >= c.length || cur > target)
            return;

        for(int i=idx; i<c.length;++i) {
            if(i>idx && i >=1 && c[i] == c[i-1])
                continue;
            lst.add(c[i]);
            helper(c, target, i+1, cur+c[i], lst);
            lst.remove(lst.size()-1);
        }

    }
    public List<List<Integer>> combinationSum2(int[] c, int target) {
        res = new ArrayList<>();
        Arrays.sort(c);
        List<Integer> l = new ArrayList<>();
        helper(c, target, 0, 0, l);
        return res;
    }
}
