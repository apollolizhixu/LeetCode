public class Solution {
    public String countAndSay(int n) {
        //Time: O(n), Space: O(n)
        if (n < 1) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int num;
        while (start < prev.length()) {
            char c = prev.charAt(start);
            num = 0;
            while (start < prev.length() && prev.charAt(start) == c) {
                start++;
                num++;
            }
            sb.append(num);
            sb.append(c);
        }
        return sb.toString();
    }
}