public class Solution {
    public String addBinary(String a, String b) {
        //Time: O(m + n), Space: O(m)
        if (a == null || b == null) {
            return "";
        }
        if (a.length() > b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }
        int m = a.length() - 1;
        int n = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (m >= 0) {
            int sum = (int)(a.charAt(m) - '0') + (int)(b.charAt(n) - '0') + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            m--;
            n--;
        }
        while (n >= 0) {
            int sum = (int)(b.charAt(n) - '0') + carry;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            n--;
        }
        if (carry > 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}