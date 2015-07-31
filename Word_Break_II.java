public class Solution{
	public ArrayList<String> wordBreak(String s, Set<String> dict){
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		return helper(s, dict, map);
	}
	public ArrayList<String> helper(String s, Set<String> dict, HashMap<String, ArrayList<String>> map){
		if (map.containsKey(s)){
			return map.get(s);
		}
		ArrayList<String> rst = new ArrayList<String>();
		int len = s.length();
		if (len == 0){
			return rst;
		}
		for (int i = 1; i <= s.length(); i++){
			String prefix = s.substring(0, i);
			if (dict.contains(prefix)){
				if (i == len){
					rst.add(prefix);
				} else {
					ArrayList<String> tmp = helper(s.substring(i), dict, map);
					for (String word : tmp){
						rst.add(prefix + " " + word);
					}
				}
			}
		}
		map.put(s, rst);
		return rst;
	}
}