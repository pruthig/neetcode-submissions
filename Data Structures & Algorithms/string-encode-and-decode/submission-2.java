class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> lst = new ArrayList<>();
        int i=0;
        
        while(i<str.length()) {
            StringBuilder sb = new StringBuilder();
            while(str.charAt(i) != '#') {
                sb.append(str.charAt(i));
                ++i;
            }
            ++i; //skip hash
            int len = Integer.parseInt(sb.toString());
            String s = str.substring(i, i+len);
            lst.add(s);
            i += len;
        }
        return lst;
    }
}
