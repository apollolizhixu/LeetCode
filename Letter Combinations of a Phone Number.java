public class Solution{
	public List<String> letterCombinations(String digits){
		List<String> rst = new ArrayList<String>();
		if (digits == null || digits.length() == 0){
			return rst;
		}
		StringBuilder sb = new StringBuilder();
		HashMap<Character, char[]> map = new HashMap<Character, char[]>();
		map.put('1', new char[]{});
		map.put('2', new char[]{'a', 'b', 'c'});
		map.put('3', new char[]{'d', 'e', 'f'});
		map.put('4', new char[]{'g', 'h', 'i'});
		map.put('5', new char[]{'j', 'k', 'l'});
		map.put('6', new char[]{'m', 'n', 'o'});
		map.put('7', new char[]{'p', 'q', 'r', 's'});
		map.put('8', new char[]{'t', 'u', 'v'});
		map.put('9', new char[]{'w', 'x', 'y', 'z'});
		helper(digits, sb, map, rst);
		return rst;
	}
	public void helper(String digits, StringBuilder sb, HashMap<Character, char[]> map, List<String> rst){
		if (sb.length() == digits.length()){
			rst.add(sb.toString());
			return;
		}
		char[] tmp = map.get(digits.charAt(sb.length()));
		for (char c : tmp){
			sb.append(c);
			helper(digits, sb, map, rst);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}