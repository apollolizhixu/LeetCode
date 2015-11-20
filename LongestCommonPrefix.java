public class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Time: O(mn), Space: O(1)
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }
        String prefix = strs[0].substring(0, minLen);
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            prefix = common(prefix, s);
        }
        return prefix;
    }
    public String common(String s1, String s2) {
        int i = 0;
        for (; i < s1.length() && i < s2.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                break;
            }
        }
        return s1.substring(0, i);
    }
}