class Solution {
    public void helper(StringBuilder sb, int ln, int rn, List<String> res) {
        if( ln == 0 && rn == 0) {
            res.add(sb.toString());
        }
        if(ln > 0 && ln <= rn) {
            sb.append("(");
            helper(sb, ln-1, rn, res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(rn > 0 && rn >= ln) {
            sb.append(")");
            helper(sb, ln, rn-1, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(sb, n, n, res);
        return res;
    }
}
