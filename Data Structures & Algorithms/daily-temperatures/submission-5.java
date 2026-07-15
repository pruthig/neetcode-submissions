class Solution {
    public int[] dailyTemperatures(int[] temp) {
        if(temp.length == 0)
            return new int[0];
        int[] res = new int[temp.length];
        res[temp.length-1] = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        dq.push(temp.length-1);
        for(int i=temp.length-2;i>=0;--i) {
            if(dq.isEmpty()) {
                res[i] = 0;
            } else {
                if(temp[dq.peek()] > temp[i]) {
                    res[i] = dq.peek()-i;
                } else {
                    while(!dq.isEmpty() && temp[dq.peek()] <= temp[i])
                        dq.pop();
                    if(dq.isEmpty())
                        res[i] = 0;
                    else
                        res[i] = dq.peek()-i;
                    
                }
            }
            dq.push(i);
        }
        return res;
    }
}
