class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Deque<Integer> q = new ArrayDeque<>();
        int len = temp.length;
        int[] res = new int[len];
        for(int i=len-1;i>=0;--i) {
            while(!q.isEmpty() && temp[i]>=temp[q.peek()]) {
                q.pop();
            }
            if(q.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = q.peek() - i;
            }
            q.push(i);
        }
        return res;
    }
}
