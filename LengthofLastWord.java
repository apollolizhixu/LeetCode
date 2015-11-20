public class Solution {
    public int lengthOfLastWord(String s) {
        //Time: O(n), Space: O(1)
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int i = s.length() - 1;
        boolean exit = false;
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                i--;
                exit = true;
            } else {
                break;
            }
        }
        if (!exit) {
            return 0;
        }
        return s.length() - 1 - i;
    }
}