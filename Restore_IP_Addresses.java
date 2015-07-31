public class Solution{
	public List<String> restoreIpAddresses(String s){
		List<String> rst = new ArrayList<String>();
		if (s == null || s.length() == 0){
			return rst;
		}
		List<String> list = new ArrayList<String>();
		helper(rst, list, s, 0);
		return rst;
	}
	public void helper(List<String> rst, List<String> list, String s, int pos){
		if (list.size() == 4){
			if (pos == s.length()){
				StringBuilder sb = new StringBuilder();
				for (String num : list){
					sb.append(num);
					sb.append(".");
				}
				sb.deleteCharAt(sb.length() - 1);
				rst.add(sb.toString());
			}
			return;
		}
		for (int i = pos; i < pos + 3 && i < s.length(); i++){
			String num = s.substring(pos, i + 1);
			if (valid(num)){
				list.add(num);
				helper(rst, list, s, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
	public boolean valid(String s){
		if (s.charAt(0) == '0'){
			return s.equals("0");
		}
		int i = Integer.valueOf(s);
		return i > 0 && i <= 255;
	}
}