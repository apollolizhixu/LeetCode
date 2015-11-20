public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> rst = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return rst;
        }
        HashMap<Integer, Character[]> map = new HashMap<Integer, Character[]>();
        map.put(2,new Character[]{'a', 'b', 'c'});
        map.put(3,new Character[]{'d', 'e', 'f'});
        map.put(4,new Character[]{'g', 'h', 'i'});
        map.put(5,new Character[]{'j', 'k', 'l'});
        map.put(6,new Character[]{'m', 'n', 'o'});
        map.put(7,new Character[]{'p', 'q', 'r', 's'});
        map.put(8,new Character[]{'t', 'u', 'v'});
        map.put(9,new Character[]{'w', 'x', 'y', 'z'});
        helper(digits, rst, map, new StringBuilder());
        return rst;
    }
    public void helper(String digits, List<String> rst, HashMap<Integer, Character[]> map, StringBuilder sb) {
        int len = sb.length();
        if (len == digits.length()) {
            rst.add(sb.toString());
            return;
        }
        for (Character c : map.get((int)(digits.charAt(len) - '0'))) {
            sb.append(c);
            helper(digits, rst, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}