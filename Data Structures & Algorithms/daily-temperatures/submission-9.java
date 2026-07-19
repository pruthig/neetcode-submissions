class Solution {
    public int[] dailyTemperatures(int[] t) {
        int len = t.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] res = new int[len];
        res[len-1] = 0;
        dq.push(len-1);
        for(int i=len-2;i>=0;--i) {
            while(!dq.isEmpty() && t[dq.peek()] <= t[i])
                dq.pop();
            if(dq.isEmpty())
                res[i] = 0;
            else
                res[i] = (dq.peek()-i);
            dq.push(i);
        }
        return res;
    }
}
