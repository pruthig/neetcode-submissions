class Solution {
    List<List<Integer>> res;
    public void helper(int[] nums, int idx, List<Integer> lst) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(lst));
            return;
        }
        lst.add(nums[idx]);
        helper(nums, idx+1, lst);
        lst.remove(lst.size()-1);

        helper(nums, idx+1, lst);
    }
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        //res.add(lst);
        helper(nums, 0, lst);
        return res;
    }
}
