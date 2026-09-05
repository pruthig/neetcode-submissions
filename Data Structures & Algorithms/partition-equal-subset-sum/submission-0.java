class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for(int i=0;i<nums.length;++i) {
             s+=nums[i];
        }
        if(s%2==1) return false;
        Set<Integer> set = new HashSet<>();
                set.add(0);

        for(int i=0;i<nums.length;++i) {
            Set<Integer> toAdd = new HashSet<>();
            for(Integer in : set) {
                int res = in+nums[i];
                if(res == s/2)
                    return true;
                toAdd.add(res);
                
            }
            set.addAll(toAdd);
        }
        return false;
    }
}
