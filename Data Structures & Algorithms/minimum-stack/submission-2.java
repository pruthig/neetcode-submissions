class MinStack {

    Deque<Integer> dqMain = new ArrayDeque<>();
    Deque<Integer> dqMin = new ArrayDeque<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        dqMain.push(val);
        if(!(dqMin.isEmpty()) && dqMin.peek()<val)
            dqMin.push(dqMin.peek());
        else
            dqMin.push(val);
    }
    
    public void pop() {
        if(!dqMain.isEmpty()) {
            dqMain.pop();
            dqMin.pop();
        }
    }
    
    public int top() {
        return dqMain.peek();
    }
    
    public int getMin() {
        return dqMin.peek();
    }
}
