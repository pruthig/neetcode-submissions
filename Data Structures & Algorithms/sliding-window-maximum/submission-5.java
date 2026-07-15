class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int rindex = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0;i<nums.length;++i) {
            // remove from back
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i])
                dq.removeLast();
            dq.addLast(i);
            while(!dq.isEmpty() && i-dq.peek()>=k)
                dq.removeFirst();
            if(i>=k-1) {
                res[rindex] = nums[dq.peekFirst()];
                ++rindex;
            }
        }
        return res;
    }
}
