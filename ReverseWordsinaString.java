public class Solution {
    public String reverseWords(String s) {
        //Time: O(n), Space: O(n)
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverseWords1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
              sb.append(words[i]);
                if (i != 0) {
                    sb.append(" ");
                }  
            }
        }
        return sb.toString();
    }

    public String reverseWords2(String s) {
        //One pass Solution
        if (s == null || s.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else {
                if (i == 0 || s.charAt(i - 1) == ' ') {
                    if (sb.length() != 0) {
                        sb.append(" ");
                    }
                    sb.append(s.substring(i, j));
                    
                }
            }
        }
        return sb.toString();
    }
}