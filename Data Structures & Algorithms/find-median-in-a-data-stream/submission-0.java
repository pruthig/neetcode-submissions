class MedianFinder {
    //max for lower half and min for upper half
    PriorityQueue<Integer> pqMin, pqMax;
    public MedianFinder() {
        pqMin = new PriorityQueue<>();
        pqMax = new PriorityQueue<>(Collections.reverseOrder());

    }
    
    public void addNum(int num) {
        if(!pqMin.isEmpty() && pqMin.peek() <= num)
            pqMin.add(num);
        else 
            pqMax.add(num);
        if(pqMax.size() - pqMin.size() > 1) {
            while(!pqMax.isEmpty() && pqMax.size() - pqMin.size() > 1) {
                pqMin.add(pqMax.poll());
            }
        } else if(pqMin.size() - pqMax.size() > 1) {
            while(!pqMin.isEmpty() && pqMin.size() - pqMax.size() > 1) {
                pqMax.add(pqMin.poll());
            }
        }
    }
    
    public double findMedian() {
        if(pqMin.size() == pqMax.size()) {
            return (pqMin.peek() + pqMax.peek())/2.0;
        } else if(pqMin.size() > pqMax.size()) {
            return pqMin.peek();
        } else {
            return pqMax.peek();
        }
    }
}
