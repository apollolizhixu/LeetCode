public class Solution {
    public String convertToTitle(int n) {
        //Time: O(n), Space: O(1)
        if (n <= 0) {
            return "";
        }
        StringBuilder sb= new StringBuilder();
        while (n > 0) {
            int rem = n % 26;
            n /= 26;
            if (rem == 0) {
                sb.append('Z');
                n--;
            } else {
                sb.append((char)('A' + rem - 1));
            }
        }
        return sb.reverse().toString();
    }
}