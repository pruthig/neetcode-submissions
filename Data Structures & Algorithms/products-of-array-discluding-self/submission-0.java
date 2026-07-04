class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        if(nums.length == 1)
            return nums;
        // 2 passes
        // 1st pass
        int len = nums.length;
        output[0] = 1;
        int lastMul = nums[0];
        for(int i=1;i<len;++i) {
            output[i] = lastMul;
            lastMul *= nums[i];
        }
        // 2nd pass
        lastMul = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;--i) {
            output[i] *= lastMul;
            lastMul = lastMul*nums[i];
        }
        return output;
    }
}  
