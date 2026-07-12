class TimeMap {

    Map<String, LinkedList<String>> map = null;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        String cumVal = String.valueOf(timestamp) + "#" + value;
        map.computeIfAbsent(key, k -> new LinkedList<String>()).addLast(cumVal);
    }
    
    public int getTS(String val) {
        // ts # actualval
        return Integer.parseInt(val.substring(0, val.indexOf('#')));

    }
    public String getVal(String value) {
        return value.substring(value.indexOf('#')+1);
    }
    public String get(String key, int timestamp) {
        int ans = -1;
        if(map.containsKey(key)) {
            List<String> listVal = map.get(key);
            int i=0, j=listVal.size()-1;
            while(i<=j) {
                int mid = i + (j-i)/2;
                String value = listVal.get(mid);
                int ts = getTS(value);
                if(ts == timestamp)
                    return getVal(value);
                else if(timestamp > ts) {
                    ans = mid;
                    i = mid + 1;
                }
                else
                    j = mid-1;
            }
            return (ans==-1)?"":getVal(listVal.get(ans));
            
        } else
            return "";
    }
}
