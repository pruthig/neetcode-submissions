class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        int maxSeq = 1;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;++i) {
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;++i) {
            if(set.contains(nums[i]+1))
                continue;
            else {
                int curElem = nums[i]-1;
                int tc = 1;
                while(set.contains(curElem)) {
                    ++tc;
                    curElem -= 1;
                }
                maxSeq = Math.max(tc, maxSeq);

            }
        }
        return maxSeq;
    }
}
