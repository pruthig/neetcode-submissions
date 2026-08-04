class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int mul=1;
        // 1, 1, 2, 8
        //48   24.   12,   1     
        for(int i=0;i<nums.length;++i) {
            res[i] = mul;
            System.out.println("res i " + res[i]);
            mul = mul*nums[i];
        }
        System.out.println("res end " + res[nums.length-1]);
        mul = 1;
        for(int i=nums.length-1;i>=0;--i) {
            res[i] *= mul;
            mul = nums[i]*mul;
        }
        return res;
    }
}  
