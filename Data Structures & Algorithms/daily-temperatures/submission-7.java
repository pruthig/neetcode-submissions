class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] res = new int[temp.length];
        int[] arr = new int[temp.length];
        int top=0;
        arr[top] = temp.length-1;
        for(int i=temp.length-2;i>=0;--i) {
            while(top >= 0 && temp[arr[top]] <= temp[i])
                --top;
            res[i] = (top == -1)?res[i] = 0:arr[top]-i; 
            arr[++top] = i;
        }
        return res;
}
}
