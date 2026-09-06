class Solution {
    private Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return helper(nums, target, 0, 0);
    }

    private int helper(int[] nums, int target, int current, int index) {
        if (index == nums.length) {
            return current == target ? 1 : 0;
        }

        String key = index + "," + current;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result =
            helper(nums, target, current + nums[index], index + 1)
          + helper(nums, target, current - nums[index], index + 1);

        memo.put(key, result);
        return result;
    }
}