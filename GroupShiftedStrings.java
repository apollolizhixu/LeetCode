public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        //Time: O(n), Space: O(n)
        List<List<String>> rst = new ArrayList<List<String>>();
        if (strings == null || strings.length == 0) {
            return rst;
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strings) {
            String cal = cal(s);
            if (!map.containsKey(cal)) {
                map.put(cal, new ArrayList<String>());
            }
            map.get(cal).add(s);
        }
        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
            rst.add(new ArrayList<String>(map.get(s)));
        }
        return rst;
    }
    public String cal(String s) {
        if (s.length() == 1) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        sb.append('a');
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            if ((int)(cur - c) < 0) {
                sb.append((char)(((int)(cur - c) + 26) + 'a'));
            } else {
                sb.append((char)((int)(cur - c) + 'a'));
            }
        }
        return sb.toString();
    }
}