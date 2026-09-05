class Solution {
    public int maxProduct(int[] nums) {
        int pos = 1, neg = 1, mx = 1;
        int curMax = nums[0], curMin = nums[0], result = nums[0];
        for(int i=1;i<nums.length;++i) {
            if(nums[i]<0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(curMax*nums[i], nums[i]);
            curMin = Math.min(curMin*nums[i], nums[i]);
            result = Math.max(result, curMax);
        }
        return result;
    }
}
