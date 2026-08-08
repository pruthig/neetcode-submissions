class Solution {
    public void helper(List<String> res, StringBuilder sb, int leftC, int rightC) {
        if(leftC == 0 && rightC == 0) {
            res.add(sb.toString());
            return;
        }
        if(rightC == 0)
            return;
        if(leftC > 0 && leftC <= rightC) {
            sb.append("(");
            helper(res, sb, leftC-1, rightC);
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if(rightC > leftC) {
            sb.append(")");
            helper(res, sb, leftC, rightC-1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, sb, n, n);
        return res;
    }
}
