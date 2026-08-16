class Solution {
    Map<Character, String> map = new HashMap<>();

    public void helper(String s, int idx, List<String> lst, StringBuilder sb) {
        if(idx == s.length()) {
            lst.add(sb.toString());
            return;
        }
        String smap = map.get(s.charAt(idx));
        for(int i=0; i<smap.length();++i) {   
            sb.append(smap.charAt(i));
            helper(s, idx+1, lst, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> lst = new ArrayList<>();
        if(digits == null || digits.length() == 0)
            return lst;
        StringBuilder sb = new StringBuilder();
        helper(digits, 0, lst, sb);
        return lst;
    }
}
