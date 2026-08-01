public class Pair {
    public int size;
    public int index;
    public Pair(int s, int i) {
        size = s;
        index = i;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b)-> (b.size - a.size));
        Deque<Pair> dq = new ArrayDeque<>();
        int cycle = 0;
        int[] freq = new int[26];
        for(int i=0;i<tasks.length;++i) {
            freq[tasks[i]-'A']++;
        }
        for(int i=0;i<26;++i) {
            if(freq[i] == 0)
                continue;
            Pair p = new Pair(freq[i], i);
            pq.add(p);
        }
        while(!pq.isEmpty()) {
            int i=0;
            for(;i<=n;++i) {
                if(pq.isEmpty())
                    break;
                ++cycle;
                Pair p = pq.peek();
                pq.poll();
                if(p.size == 1)
                    continue;
                dq.add(new Pair(p.size-1, p.index));
            }
            while(!dq.isEmpty())
                pq.add(dq.removeFirst());
            if(!pq.isEmpty())
                cycle += (n+1)-i;
        }
        return cycle;
    }
}
