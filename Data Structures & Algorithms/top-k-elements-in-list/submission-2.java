class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //reverse map
        Map<Integer, List<Integer>> reverseMap = new HashMap<>();
        
        for(Integer key : map.keySet()) {
            reverseMap.computeIfAbsent(map.get(key), b->new ArrayList<Integer>()).add(key);
        }
        int kindex = -1;
        int count = k;
        int[] karr = new int[k];
        for(int i=nums.length;i>=0;--i) {
            List<Integer> lst = reverseMap.get(i);
            if(lst == null)
                continue;
            for(Integer ix : lst) {
                karr[++kindex] = ix;
                --count;
                if(count == 0)
                    break;
            }
            if(count == 0)
                break;
        }
        return karr;

    }
}
