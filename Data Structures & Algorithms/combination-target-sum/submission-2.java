class Solution {
    List<List<Integer>> res;
    public void helper(int[] nums, int target, int cur, int idx, List<Integer> lst) {
        if(cur == target) {
            res.add(new ArrayList<>(lst));
            return;
        }
        if(cur > target || idx >= nums.length)
            return;
        for(int i=idx;i<nums.length;++i) {
            if(i>idx && nums[i] == nums[i-1])
                continue;
            lst.add(nums[i]);
            helper(nums, target, cur+nums[i], i, lst);
            lst.remove(lst.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> lst = new ArrayList<>();
        res = new ArrayList<>();
        helper(nums, target, 0, 0, lst);
        return res;
    }
}
