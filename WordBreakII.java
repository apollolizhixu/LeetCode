public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        if (s == null || s.length() == 0 || wordDict.size() == 0) {
            return new ArrayList<String>();
        }
        return helper(s, wordDict, map);
    }
    public List<String> helper(String s, Set<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> rst = new ArrayList<String>();
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (wordDict.contains(prefix)) {
                if (i == s.length()) {
                    rst.add(prefix);
                } else {
                   List<String> list = helper(s.substring(i), wordDict, map);
                    for (String subfix : list) {
                        rst.add(prefix + " " + subfix);
                    } 
                }
            }
        }
        map.put(s, rst);
        return rst;
    }
}