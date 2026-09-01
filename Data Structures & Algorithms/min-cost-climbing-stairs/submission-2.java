class Solution {
    Integer[] memo = null;
    public int helper(int[] cost, int step) {
        if(step == 0 || step == 1)
            return 0;
        if(memo[step] != null)
            return memo[step];
        int res = Math.min(cost[step-1] + helper(cost, step-1), 
                cost[step-2] + helper(cost, step-2));
        memo[step] = res;
        return res;
    }
    public int minCostClimbingStairs(int[] cost) {
        // cost(last) or cost(second_last)
        memo = new Integer[cost.length+1];
        return helper(cost, cost.length);
    }
}
