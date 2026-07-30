class KthLargest {
    PriorityQueue<Integer> pq;
    int mx = 0;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        mx = k;
        for(int i=0;i<nums.length;++i) {
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        while (pq.size() > mx)
            pq.poll();

        return pq.peek();
    }
    
    
}
