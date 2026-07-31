class Solution {
    public int leastInterval(char[] tasks, int n) {
        Deque<int[]> dq = new ArrayDeque<>();
        int cycle = 0;
        int[] charMap = new int[26];
        for(int i=0;i<tasks.length;++i) {
            ++charMap[tasks[i]-'A'];
        }
        // size, index
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for(int i=0;i<26;++i) {
            if(charMap[i] == 0)
                continue;
            pq.add(new int[]{charMap[i], i});
        }
        while(!(pq.size() == 0)) {
            int i=0;
            for(;i<=n;++i) {
                if(pq.size() == 0)
                    break;
                int[] top = pq.peek(); pq.remove();
                if(top[0]-1 != 0) {
                    dq.add(new int[]{top[0]-1, top[1]});
                }
                ++cycle;
            }
            while(!dq.isEmpty()) {
                pq.add(dq.peekFirst());
                dq.removeFirst();
            }
            if(!pq.isEmpty())
                cycle += (n+1-i);
        }
        return cycle;

    }
}
