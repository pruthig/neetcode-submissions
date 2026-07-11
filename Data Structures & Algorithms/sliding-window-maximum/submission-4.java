class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length < k) {
            return new int[0];
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int resLen = nums.length - k + 1;
        int[] res = new int[resLen];
        int kindex = 0;
        for(int i=0;i<nums.length && kindex < resLen;++i) {
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i])
                dq.removeLast();
            dq.addLast(i);
            while(!dq.isEmpty() && dq.peekFirst() <= (i-k))
                dq.removeFirst();
            if(i>=k-1) {
                res[kindex++] = nums[dq.peekFirst()];
            }
        }
        return res;

    }
}
