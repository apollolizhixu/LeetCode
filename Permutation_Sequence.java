public class Solution{
    public String getPermutation(int n, int k){
    	if (n <= 0 || k <= 0){
    		return "";
    	}
    	boolean[] num = new boolean[n];
    	StringBuilder sb = new StringBuilder();
    	int factor = 1;
    	for (int i = 1; i <= n; i++){
    		factor *= i;
    	}
    	k--;
    	for (int i = 0; i < n; i++){
    	    factor /= n - i;//Put it first, make sure factor never equals to n;
    		int index = k / factor;
    		k %= factor;
    		
    		for (int j = 0; j < n; j++){
    			
    			if (!num[j]){
    				if (index == 0){
    				sb.append(j + 1);
    				num[j] = true;
    				break;
    			}
    				index--;
    			}
    		}
    		
    	}
    	return sb.toString();
    }   
}