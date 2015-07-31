public class Solution{
	public boolean exist(char[][] board, String word){
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++){
				if (board[i][j] == word.charAt(0)){
					if (find(board, i, j, word, 0)){
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean find(char[][] board, int i, int j, String word, int pos){
		if (pos == word.length()){
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(pos)){
			return false;
		}
		board[i][j] = '#';
		boolean rst = find(board, i + 1, j, word, pos + 1) || find(board, i - 1, j, word, pos + 1) || find(board, i, j + 1, word, pos + 1) || find(board, i, j - 1, word, pos + 1);
		board[i][j] = word.charAt(pos);
		return rst;
	}
}