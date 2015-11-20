public class Solution {
    public int myAtoi(String str) {
        //Time: O(n), Space: O(n)
        if (str == null || str.length() == 0) {
            return 0;
        }
        int rst = 0;
        str = str.trim();
        boolean negative = false;
        int i = 0;
        if (str.charAt(0) == '-') {
            negative = true;
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            int num = str.charAt(i) - '0';
            if (rst > Integer.MAX_VALUE / 10 || (rst == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            rst = rst * 10 + num;
            i++;
        }
        return negative ? -rst : rst;
    }
}