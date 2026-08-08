class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if(nums.length == 0)
            return res;
        helper(nums, 0);
        return res;
    }
    public void swap(int[] nums, int i, int j) {
        int r = nums[i];
        nums[i] = nums[j];
        nums[j] = r;
    }
    public void helper(int[] nums, int idx) {
        if(idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int num : nums)
                list.add(num);
            res.add(list);
            return;
        }
        for(int i=idx; i<nums.length;++i) {
            swap(nums, i, idx);
            helper(nums, idx+1);
            swap(nums, i, idx);
        }
    }
}
