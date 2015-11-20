public class Solution {
    public int calculate(String s) {
        //Time: O(n), Space: O(n)
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (Character.isDigit(s.charAt(i))) {
                        int j = i;
                        while (j < s.length() && Character.isDigit(s.charAt(j))) {
                            j++;
                        }
                        String num = s.substring(i, j);
                        if (!stack.isEmpty() && (stack.peek().equals("+") || stack.peek().equals("-") || stack.peek().equals("*") || stack.peek().equals("/"))) {
                            String c2 = stack.pop();
                            String c1 = stack.pop();
                            num = cal(c1, c2, num);
                        } 
                        stack.push(num);
                        i = j - 1;
                } else if (c == ')') {
                    String num = stack.pop();
                    stack.pop();
                    if (!stack.isEmpty()) {
                        String c2 = stack.pop();
                        String c1 = stack.pop();
                        num = cal(c1, c2, num);
                    } 
                    stack.push(num);
                } else {
                    stack.push(String.valueOf(c));
                }
            }
        }
        return Integer.parseInt(stack.pop());
     }
     public String cal(String c1, String c2, String c3) {
         int i1 = Integer.parseInt(c1);
         int i2 = Integer.parseInt(c3);
         if (c2.equals("+")) {
             return "" + (i1 + i2);
         } else if (c2.equals("-")) {
             return "" + (i1 - i2);
         } else if (c2.equals("*")) {
             return "" + (i1 * i2);
         } else {
             return "" + (i1 / i2);
         }
     }
}