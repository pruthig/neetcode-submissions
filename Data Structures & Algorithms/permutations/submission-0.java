class Solution {
    List<List<Integer>> res;
    public void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public void helper(int[] nums, int idx) {
        if(idx == nums.length) {
            List<Integer> list = Arrays.stream(nums)
                           .boxed()
                           .collect(Collectors.toList());
            res.add(list);
            return;
        }
        for(int i=idx; i<nums.length;++i) {
            swap(nums, i, idx);
            helper(nums, idx+1);
            swap(nums, i, idx);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        res = new ArrayList<>();
        helper(nums, 0);
        return res;
    }
}
