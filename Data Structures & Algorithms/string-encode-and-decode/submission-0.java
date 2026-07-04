class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> lst = new ArrayList<>();
        int i=0;
        while(i<str.length()) {
            StringBuilder intBuilder = new StringBuilder();
            while(i<str.length() && str.charAt(i) != '#') {
                intBuilder.append(str.charAt(i));
                ++i;
            }
            int len = Integer.parseInt(intBuilder.toString());
            ++i;
            // come to first character
            String captured = str.substring(i, i + len);
            lst.add(captured);
            i += len;

        }
        return lst;
    }
}
