public class Solution {
    //Time: O(n), Space: O(1)
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int rst = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            rst = rst * 26 + (int)(c - 'A') + 1;
        }
        return rst;
    }
}