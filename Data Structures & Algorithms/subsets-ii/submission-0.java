class Solution {
    Set<List<Integer>>  res;
    public void helper(int[] nums, int idx, List<Integer> list) {
        if(idx == nums.length){
            return;
        }
        for(int i=idx;i<nums.length;++i) {
            list.add(nums[i]);
            List<Integer> t = new ArrayList<>(list);
            Collections.sort(t);
            res.add(new ArrayList<>(t));
            helper(nums, i+1, list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        res.add(list);
        helper(nums, 0, list);
        return new ArrayList<List<Integer>>(res);
    }
}
