class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> dq = new ArrayDeque<>();
        int mx = Integer.MIN_VALUE;

        for(int i=heights.length-1;i>=0;--i) {
            int res_index = i;
            while(!dq.isEmpty() && dq.peek()[1]>=heights[i]) {
                int[] popped = dq.peek(); dq.pop();
                int calc = (popped[0]-i)*popped[1];
                mx = Math.max(mx, calc);
                res_index = popped[0];
            }
            dq.push(new int[]{res_index, heights[i]});
        }
        while(!dq.isEmpty()) {
            int[] popped = dq.peek(); dq.pop();
            int calc = (1+popped[0])*popped[1];
            mx = Math.max(mx, calc);
        }
        return mx;
    }
}
