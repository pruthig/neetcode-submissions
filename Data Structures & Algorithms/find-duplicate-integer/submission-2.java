class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;++i) {
            int curP = Math.abs(nums[i]);
            if(nums[curP-1] < 0)
                return curP;
            nums[curP-1] = -nums[curP-1];
        }
        return 0;
    }
}
