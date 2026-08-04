class Solution {
    List<List<Integer>> res = null;
    public void combinationSumHelper(int[] nums, int target, int idx, int curSum, List<Integer> lst) {
        if (curSum > target || idx >= nums.length) {
            return;
        }
        if(curSum == target) {
            res.add(new ArrayList<>(lst));
            return;
         }

        for(int i=idx;i<nums.length;++i) {
            if(i>idx && nums[i] == nums[i-1])
                continue;
            lst.add(nums[i]);
            combinationSumHelper(nums, target, i, curSum+nums[i], lst);
            lst.remove(lst.size()-1);
        }
        
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        combinationSumHelper(nums, target, 0, 0, new ArrayList<Integer>());
        return res;
    }
}
