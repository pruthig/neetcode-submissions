class Solution {

    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int one = 1;
        int two = 1;
        for (int i = 1; i < s.length(); i++) {
            int current = 0;
            if(s.charAt(i) != '0')
                current += one;
            if(s.charAt(i-1) != '0') {
                int num =  10*(s.charAt(i-1) - '0') + s.charAt(i)-'0';
                if(num >= 10 && num <= 26)
                    current += two;
            }
            two = one;
            one = current;
        }
        return one;
    }
}
