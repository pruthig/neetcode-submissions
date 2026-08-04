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
            if(cur + nums[i] > target)
                break;
            lst.add(nums[i]);
            helper(nums, target, cur+nums[i], i+1, lst);
            lst.remove(lst.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<Integer> lst = new ArrayList<>();
        Arrays.sort(nums);
        res = new ArrayList<>();
        helper(nums, target, 0, 0, lst);
        return res;
    }
}
