class Solution {
    List<List<Integer>> res;

    public void subsetsHelper(List tempList, int[] nums, int idx) {
        if(idx >= nums.length)
            return;
        tempList.add(nums[idx]);

        res.add(new ArrayList<>(tempList));
        subsetsHelper(tempList, nums, idx+1);
        tempList.remove(tempList.size() - 1);
        subsetsHelper(tempList, nums, idx+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> l = new ArrayList<>();
        res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        subsetsHelper(l, nums, 0);
        return res;
    }
}
