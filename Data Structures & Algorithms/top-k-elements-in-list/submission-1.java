class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int maxVal = 0;
        for(int i=0;i<nums.length;++i) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            maxVal = Math.max(maxVal, mp.get(nums[i]));
        }
        Map<Integer, List<Integer>> mq = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            mq.computeIfAbsent(val, l->new ArrayList<Integer>()).add(key);
        }
        int kidx = 0;
        boolean flagged = false;
        int[] kmost = new int[k];
        for(int i = maxVal; i>=1; --i) {
            List<Integer> lst = mq.get(i);
            if(lst == null)
                continue;
            for(Integer intr : lst) {
                kmost[kidx] = intr;
                ++kidx;
                if(kidx >= k) {
                    flagged = true;
                    break;
                }

            }
            if(flagged)
                break;
        }
        return kmost;
    }
}
