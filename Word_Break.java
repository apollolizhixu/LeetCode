public class Solution{
	public boolean wordBreak(String s, Set<String> dict){
		if (s == null || s.length() == 0 || dict == 0 || dict.size() == 0){
			return false;
		}
		boolean[] check = new boolean[s.length() + 1];
		check[0] = true;
		for (int i = 1; i <= s.length(); i++){
			for (int j = i - 1; j >= 0; j--){
				if (check[j] && dict.contains(s.substring(j, i))){
					check[i] = true;
					break;
				}
			}
		}
		return check[s.length()];
	}
}