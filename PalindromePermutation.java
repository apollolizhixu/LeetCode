public class Solution {
    public boolean canPermutePalindrome(String s) {
        //Time: O(n), Space: O(n)
        if (s == null || s.length() == 0) {
            return true;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        boolean single = false;
        for (Integer i : map.values()) {
            if (i % 2 == 1) {
                if (single) {
                    return false;
                }
                single = true;
            }
        }
        return true;
    }
}