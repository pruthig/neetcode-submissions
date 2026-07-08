class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<int[]> q = new LinkedList<>();
        if(nums.length<k)
            return new int[0];
        int[] res = new int[nums.length-k+1];
        int resIdx = 0;

        for(int i=0;i<nums.length;++i) {
            int curSize = nums[i];
            while(q.size() != 0 && q.peekLast()[1]<curSize)
                q.removeLast();
            q.addLast(new int[]{i, nums[i]});
            while(q.size() != 0 && q.peekFirst()[0] <= i-k) {
                q.pollFirst();
            }
            if(i>=k-1) {
               res[resIdx] = q.peek()[1]; 
               resIdx++;
            }
            
        }
        return res;
        
    }
}
