public class Solution{
	public int maxProfit(int[] prices){
		if (prices.length <= 1 || prices == null){
			return 0;
		}
		int m = prices.length;
		int[] f = new int[m];
		int[] b = new int[m];
		int tmp = prices[0];
		f[0] = 0;
		for (int i = 1; i < m; i++){
		    tmp = Math.min(tmp, prices[i]);
			f[i] = Math.max(prices[i] - tmp, f[i - 1]);
		}
		tmp = prices[m - 1];
		b[m - 1] = 0;
		for (int i = m - 2; i >= 0; i--){
		    tmp = Math.max(tmp, prices[i]);
			b[i] = Math.max(b[i + 1], tmp - prices[i]);
		}
		int rst = 0;
		for (int i = 0; i < m; i++){
			rst = Math.max(rst, f[i] + b[i]);
		}
		return rst;
	}
}