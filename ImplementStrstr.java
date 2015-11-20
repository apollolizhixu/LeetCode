public class Solution {
    public int strStr(String haystack, String needle) {
    //Time: O(mn), Space: O(1)
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        int m = haystack.length();
        int n = needle.length();
        long tar = 0;
        long sea = 0;
        for (int i = 0; i < n; i++) {
            tar += (long)(Character.toLowerCase(needle.charAt(i)) - 'a');
            sea += (long)(Character.toLowerCase(haystack.charAt(i)) - 'a');
        }
        for (int i = 0; i <= m - n; i++) {
            if (tar == sea) {
                int j = 0;
                for (; j < n; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == n) {
                    return i;
                }
            }
            if (i == m - n) {
                return -1;
            }
            sea -= (long)(Character.toLowerCase(haystack.charAt(i)) - 'a');
            sea += (long)(Character.toLowerCase(haystack.charAt(i + n)) - 'a');
        }
        return -1;
    }
}