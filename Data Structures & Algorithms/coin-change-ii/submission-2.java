class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int helper(int remaining, int[] coins, int idx) {
        if(remaining == 0) {
            return 1;
        }
        if(remaining < 0)
            return 0;
        String key = String.valueOf(remaining) + '#' + String.valueOf(idx);
        int total = 0;
        if(map.containsKey(key))
            return map.get(key);
        for(int i=idx;i<coins.length;++i) {
            total += helper(remaining-coins[i], coins, i);
        }
        map.put(key, total);
        return total;
    }
    public int change(int amount, int[] coins) {
        return helper(amount, coins, 0);
    }
}
