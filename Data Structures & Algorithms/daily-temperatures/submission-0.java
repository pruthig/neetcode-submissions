class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Deque<int[]> q = new ArrayDeque<>();
        int len = temp.length;
        int[] res = new int[len];
        res[len-1] = 0;
        q.push(new int[]{len-1, temp[len-1]});
        for(int i=len-2;i>=0;--i) {
            while(!q.isEmpty() && temp[i]>=q.peek()[1]) {
                q.pop();
            }
            if(q.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = q.peek()[0] - i;
            }
            q.push(new int[]{i, temp[i]});
        }
        return res;
    }
}
