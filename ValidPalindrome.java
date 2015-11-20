public class Solution {
    public boolean isPalindrome(String s) {
        //Time: O(n), Space: O(1)
        if (s == null || s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (start < end && !Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start))) {
                start++;
            }
            while(start < end && !Character.isLetter(s.charAt(end)) && !Character.isDigit(s.charAt(end))) {
                end--;
            }
            char c1 = Character.toLowerCase(s.charAt(start));
            char c2 = Character.toLowerCase(s.charAt(end));
            if (c1 != c2) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}