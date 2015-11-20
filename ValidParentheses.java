public class Solution {
    public boolean isValid(String s) {
        //Time: O(n), Space: O(n)
        if (s == null || s.length() <= 1) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ("([{".contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c1 = stack.pop();
                if (!(c1 == '(' && c == ')') && !(c1 == '[' && c == ']') && !(c1 == '{' && c == '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}