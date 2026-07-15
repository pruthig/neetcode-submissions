class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] res = new int[temp.length];
        int[] arr = new int[temp.length];
        int top=0;
        arr[top] = temp.length-1;
        for(int i=temp.length-2;i>=0;--i) {
            if(temp[arr[top]] > temp[i]) {
                res[i] = arr[top]-i;
            } else {
                while(top >= 0 && temp[arr[top]] <= temp[i])
                    --top;
                if(top == -1)
                    res[i] = 0;
                else
                    res[i] = arr[top]-i; 
            }
            arr[++top] = i;
        }
        return res;
}
}
