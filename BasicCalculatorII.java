public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        LinkedList<String> list = new LinkedList<String>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (Character.isDigit(c)) {
                    int j = i;
                    while (j < s.length() && Character.isDigit(s.charAt(j))) {
                        j++;
                    }
                    String num = s.substring(i, j);
                    if (!list.isEmpty() && (list.peekLast().equals("*") 
                    || list.peekLast().equals("/"))) {
                        String op = list.pollLast();
                        String num1 = list.pollLast();
                        num = op(num1, op, num);
                    }
                    list.addLast(num);
                    i = j - 1;
                } else {
                    list.addLast(Character.toString(c));
                }
            }
        }
        String num = list.pollFirst();
        while (!list.isEmpty()) {
            String op = list.pollFirst();
            String num1 = list.pollFirst();
            num = op(num, op, num1);
        }
        return Integer.parseInt(num);
    }
    public String op(String n1, String op, String n2) {
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        if (op.equals("+")) {
            return "" + (num1 + num2);
        } else if (op.equals("-")) {
            return "" + (num1 - num2);
        } else if (op.equals("*")) {
            return "" + (num1 * num2);
        } else {
            return "" + (num1 / num2);
        }
    }
}