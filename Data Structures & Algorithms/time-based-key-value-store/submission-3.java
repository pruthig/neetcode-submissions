class Pair {
    public Pair(int timestamp, String value)
    {
        this.timestamp = timestamp;
        this.value = value;
    }
    public int timestamp;
    public String value;
}

class TimeMap {

    Map<String, List<Pair>> map = null;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<Pair>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        int ans = -1;
        if(map.containsKey(key)) {
            List<Pair> listVal = map.get(key);
            int i=0, j=listVal.size()-1;
            while(i<=j) {
                int mid = i + (j-i)/2;
                Pair p = listVal.get(mid);
                int ts = p.timestamp;
                if(ts == timestamp)
                    return p.value;
                else if(ts < timestamp) {
                    ans = mid;
                    i = mid + 1;
                }
                else
                    j = mid-1;
            }
            return (ans==-1)?"":(listVal.get(ans)).value;
            
        } else
            return "";
    }
}
