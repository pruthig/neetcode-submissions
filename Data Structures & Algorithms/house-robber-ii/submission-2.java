class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int mx_2 = nums[0];
        int mx_1 = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length-1;++i) {
            int cur = Math.max(nums[i] + mx_2, mx_1);
            mx_2 = mx_1;
            mx_1 = cur;
        }
        int mx = mx_1;

        mx_2 = 0;
        mx_1 = nums[1];
        for(int i=2;i<nums.length;++i) {
            int cur = Math.max(nums[i] + mx_2, mx_1);
            mx_2 = mx_1;
            mx_1 = cur;
        }
        mx = Math.max(mx, mx_1);
        return mx;
    }
}
