public class Solution {
    public List<String> generatePalindromes(String s) {
        //Time: O(n + 256 ^ m), m is half-length of palindrome, Space: O(n)
        List<String> rst = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return rst;
        }
        int[] letter = new int[256];
        for (int i = 0; i < s.length(); i++) {
            letter[(int)s.charAt(i)]++;
        }
        String mid = "";
        int length = 0;
        for (int i = 0; i < 256; i++) {
            if (letter[i] > 0) {
                if ((letter[i] & 1) == 1) {
                    if (mid != "") {
                        return rst;
                    }
                    mid = mid + (char)i;
                    letter[i]--;
                }
                letter[i] /= 2;
                length += letter[i];
            }
        }
        helper(letter, length, "", mid, rst);
        return rst;
    }
    public void helper(int[] letter, int length, String s, String mid, List<String> rst) {
        if (s.length() == length) {
            rst.add(s + mid + new StringBuilder(s).reverse().toString());
            return;
        }
        for (int i = 0; i < 256; i++) {
            if (letter[i] > 0) {
                letter[i]--;
                helper(letter, length, s + (char)i, mid, rst);
                letter[i]++;
            }
        }
    }
}