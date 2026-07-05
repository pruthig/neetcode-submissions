class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length <= 2)
            return res;
        for(int i=0; i<nums.length-2;++i) {
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            int j = i+1, k = nums.length-1;
            while(j<k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    List<Integer> r = new ArrayList<>();
                    r.add(nums[i]); r.add(nums[j]); r.add(nums[k]);
                    res.add(r);
                    while(j<k && nums[j+1] == nums[j])
                        ++j;
                    while(j<k && nums[k-1] == nums[k])
                        --k;
                    ++j; --k;
                } else if(sum>0) {
                    --k; continue;
                } else {
                    ++j; continue;
                }
            }
        }
        return res;
        
    }
}
