public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Time: O(n), Space: O(n)
        List<List<String>> rst = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return rst;
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            String anagram = anag(s);
            if (!map.containsKey(anagram)) {
                map.put(anagram, new ArrayList<String>());
            }
            map.get(anagram).add(s);
        }
        for (String s : map.keySet()) {
            Collections.sort(map.get(s));
            rst.add(new ArrayList<String>(map.get(s)));
        }
        return rst;
    }
    public String anag(String s) {
        char[] letter = s.toCharArray();
        Arrays.sort(letter);
        return new String(letter);
    }
}