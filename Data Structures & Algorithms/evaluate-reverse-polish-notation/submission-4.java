class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(String str : tokens) {
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int f = dq.pop();
                int s = dq.pop();
                System.out.println(" f and s: " + f + " " + s);
                if(str.equals("+")) {
                    dq.push(f+s);
                } else if(str.equals("-")) {
                    dq.push(s-f);
                } else if(str.equals("*")) {
                    dq.push(f*s);
                } else {
                    dq.push(s/f);
                }
            } else {
                int i = Integer.parseInt(str);
                System.out.println("i is: " + i);
                dq.push(Integer.parseInt(str));
            }
        }
        return dq.peek();
    }
}
