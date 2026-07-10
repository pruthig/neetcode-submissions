class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            int len = str.length();
            sb.append(len).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        List<String> lst = new ArrayList<>();
        while(i<str.length()) {
            // extract the number
            StringBuilder sb = new StringBuilder();
            while(str.charAt(i) != '#') {
                sb.append(str.charAt(i));
                ++i;
            }
            int len = Integer.parseInt(sb.toString());
            // skip the '#'
            ++i;
            String s = str.substring(i, i+len);
            i = i + len;
            lst.add(s);
        }
        return lst;
    }
}
