class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int totalMax = 1;
        for(int i=1;i<nums.length;++i) {
            // for each number.. go below loop
            int max = 1;
            for(int j=0;j<i;++j) {
                if(nums[i]>nums[j]) {
                    max = Math.max(dp[j]+1, max);
                }
            }
            dp[i] = max;
            totalMax = Math.max(dp[i], totalMax);

        }
        return totalMax;
    }
}
