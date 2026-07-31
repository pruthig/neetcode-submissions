class Pair {
    public double size;
    public int index;
        Pair(double size, int index) {
        this.size = size;
        this.index = index;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // maxHeap
        PriorityQueue<Pair> pq = new PriorityQueue<>(
    (a, b) -> Double.compare(b.size, a.size)
);
        int[][] res = new int[k][2];
        
        for(int i=0;i<points.length;++i) {
            int[] point = points[i];
            double distance = (double)Math.sqrt(point[0]*point[0] + point[1]*point[1]);
            if(i<k) {
                Pair p = new Pair(distance, i);
                pq.add(p);
            } else {
                Pair topper = pq.peek();
                if(topper.size >= distance) {
                    pq.add(new Pair(distance, i));
                    pq.poll();
                }
            }
        }
        int i=0;
        while(pq.size() != 0) {
            Pair p = pq.poll();
            // c[1] is index
            res[i] = points[p.index];
            ++i;
        }
        return res;

    }
}
