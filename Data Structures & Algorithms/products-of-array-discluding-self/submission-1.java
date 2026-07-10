class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int mul = nums[0];
        res[0] = 1;
        for(int i=1;i<nums.length;++i) {
            res[i] = mul;
            mul = mul*nums[i];
        }
        // reverse
        mul = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;--i) {
            res[i] *= mul;
            mul = mul*nums[i];
        }
        return res;
    }
}  
