class Solution {
    List<List<Integer>> res;
    public void csHelper(int[] nums, int target, int idx, int cur, List<Integer> list) {
        if(cur == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(idx >= nums.length || cur>target)
            return;
        for(int i=idx;i<nums.length;++i) {
            if(i>idx && i>=1 && nums[i] == nums[i-1])
                continue;
            list.add(nums[i]);
            csHelper(nums, target, i, cur + nums[i], list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> lst = new ArrayList<>();
        csHelper(nums, target, 0, 0, lst);
        return res;
    }
}
