public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        //Time: O(n), Space: O(1)
        List<String> rst = new ArrayList<String>();
        if (s == null || s.length() <= 1) {
            return rst;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) == '+') {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i + 2);
                rst.add(s1 + "--" + s2);
            }
        }
        return rst;
    }
}