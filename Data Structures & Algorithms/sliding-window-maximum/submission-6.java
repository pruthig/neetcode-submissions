class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len-k+1];
        int resIdx = 0;
        for(int i=0;i<nums.length;++i) {
            while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()])
                dq.removeLast();
            dq.addLast(i);
            while(!dq.isEmpty() && dq.peekFirst() <= i-k)
                dq.removeFirst();
            if(i>=k-1) {
                res[resIdx++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
}
