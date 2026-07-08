class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<tokens.length;++i) {
            String s = tokens[i];
            try {
                int res = Integer.parseInt(s);
                q.push(res);
            } catch(Exception ex) {
                int first = q.peek();q.pop();
                int second = q.peek();q.pop();
                if(s.equals("+")) {
                    int res = first + second;
                    q.push(res);
                }
                else if(s.equals("-")) q.push(second-first);
                else if(s.equals("*")) q.push(first*second);
                else q.push(second/first);
            }
        }
        return q.peek();
    }
}
