class Solution {
    List<List<Integer>> res;
    public void helper(int[] c, int cur, int idx, int t, List<Integer> list) {
        if(t == cur) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(cur > t || idx >= c.length)
            return;
        for(int i=idx;i<c.length;++i) {
            if(i>idx && c[i] == c[i-1])
                continue;
            list.add(c[i]);
            helper(c, cur+c[i], i+1, t, list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] c, int target) {
        Arrays.sort(c);
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(c, 0, 0, target, list);
        return res;
    }
}
