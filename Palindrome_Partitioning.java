public class Solution{
	public List<List<String>> partition(String s){
		List<List<String>> rst = new ArrayList<List<String>>();
		if (s == null || s.length() == 0){
			return rst;
		}
		List<String> list = new ArrayList<String>();
		helper(rst, list, s, 0);
		return rst;
	}
	public void helper(List<List<String>> rst, List<String> list, String s, int pos){
		if (pos == s.length()){
			rst.add(new ArrayList<String>(list));
		}
		for (int i = pos; i < s.length(); i++){
			String prefix = s.substring(pos, i + 1);
			if (palin(prefix)){
				list.add(prefix);
				helper(rst, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
	public boolean palin(String s){
		int start = 0;
		int end = s.length() - 1;
		while (start < end){
			if (s.charAt(start) != s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}