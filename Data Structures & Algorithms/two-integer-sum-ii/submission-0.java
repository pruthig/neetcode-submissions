class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int i=0, j = nums.length-1;
        while(i<j) {
            int sum = nums[i] + nums[j];
            if(sum > target) {
                --j; continue;
            } else if(sum < target) {
                ++i; continue;
            } else {
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
        }
        return res;
    }
}
