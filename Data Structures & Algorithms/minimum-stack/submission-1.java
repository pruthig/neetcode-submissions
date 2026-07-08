class MinStack {

    Deque<Integer> qbase = null, qmin = null;
    int curMin = 0;
    public MinStack() {
        qbase = new ArrayDeque<>();
        qmin = new ArrayDeque<>();
        curMin = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<curMin)
            curMin=val;
        qbase.push(val);
        qmin.push(curMin);
    }
    
    public void pop() {
        qbase.pop();
        qmin.pop();
        if(qbase.isEmpty())
            curMin = Integer.MAX_VALUE;
        else
            curMin = qmin.peek();
    }
    
    public int top() {
        return qbase.peek();
    }
    
    public int getMin() {
        return qmin.peek();
    }
}
