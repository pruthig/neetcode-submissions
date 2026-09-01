class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] max_values = new int[nums.length];
        max_values[0] = nums[0];
        max_values[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length-1;++i) {
            max_values[i] = Math.max(nums[i] + max_values[i-2], max_values[i-1]);
        }
        int mx = max_values[nums.length-2];
        max_values[0] = 0;
        max_values[1] = nums[1];
        for(int i=2;i<nums.length;++i) {
            max_values[i] = Math.max(nums[i] + max_values[i-2], max_values[i-1]);
        }
        mx = Math.max(mx, max_values[nums.length-1]);
        return mx;
    }
}
