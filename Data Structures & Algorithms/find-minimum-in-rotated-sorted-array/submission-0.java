class Solution {
    public int findMin(int[] nums) {
        int i=0, j=nums.length-1;
        int mid = 0;
        while(i<=j) {
            if(i == j)
                return nums[i];
            mid = (i+j)/2;
            if(mid-1 >= 0 && nums[mid-1]>nums[mid])
                break;
            else if(nums[mid]<nums[j]) {
                j = mid-1;
            } else {
                i = mid+1;
            }
        }
        return nums[mid];
    }
}
