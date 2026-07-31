class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // count -> number list
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        for(Map.Entry<Integer, Integer> me : map.entrySet()) {
            map2.computeIfAbsent(me.getValue(), v -> new ArrayList<>()).add(me.getKey());
        }
        int kindex = -1;
        int[] res = new int[k];
        for(int c=nums.length;c>=0;--c) {
            if(map2.containsKey(c)) {
                boolean done = false;
                List<Integer> list = map2.get(c);
                if(list == null)
                    continue;
                for(int n : list) {
                    res[++kindex] = n;
                    if(kindex == k-1) {
                        done = true;
                        break;
                    }
                }
                if(done)
                    break;
            }
        }
        return res;
    }
}
