class Solution {
        List<List<Integer>> res;
    public void helper(int[] nums, int target, int cur, int idx, List<Integer> list) {
        if(cur == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(idx >= nums.length || cur > target)
            return;
        for(int i=idx;i<nums.length;++i) {
            if(i>idx && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            helper(nums, target, cur+nums[i], i+1, list);
            list.remove(list.size()-1);
        }
    }


    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        helper(nums, target, 0, 0, list);
        return res;
    }
}
