class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int len = temp.length;
        int[] q = new int[len];
        int[] res = new int[len];
        int top = -1;
        for(int i=len-1;i>=0;--i) {
            while(top >= 0 && temp[i]>=temp[q[top]])
                --top;
            if(top == -1) {
                res[i] = 0;
            } else {
                res[i] = q[top] - i;
            }
            q[++top] = i;
        }
        return res;
    }
}
