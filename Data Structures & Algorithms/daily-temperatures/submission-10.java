class Solution {
    public int[] dailyTemperatures(int[] t) {
        Deque<Integer> dq = new ArrayDeque<>();
        int len = t.length;
        int[] res = new int[len];
        for(int i=len-1;i>=0;--i) {
            while(!dq.isEmpty() && t[dq.peek()] <= t[i])
                dq.pop();
            if(dq.isEmpty())
                res[i] = 0;
            else
                res[i] = dq.peek() - i;
            dq.push(i);
        }
        return res;
    }
}
