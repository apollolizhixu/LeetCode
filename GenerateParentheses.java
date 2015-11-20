public class Solution {
    public List<String> generateParenthesis(int n) {
        //Time: O(2 ^ （2n - 1)）, Space: O(2n)
        List<String> rst = new ArrayList<String>();
        if (n <= 0) {
            return rst;
        }
        helper(rst, "", n, n);
        return rst;
    }
    public void helper(List<String> rst, String s, int left, int right) {
        if (left > right || left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            rst.add(new String(s));
            return;
        }
        helper(rst, s + "(", left - 1, right);
        helper(rst, s + ")", left, right - 1);
    }
}