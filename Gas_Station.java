public class Solution{
	public int canCompleteCircuit(int[] gas, int[] cost){
		int sum = 0;
		int cirSum = 0;
		int index = -1;
		for (int i = 0; i < gas.length; i++){
			sum += gas[i] - cost[i];
			cirSum += gas[i] - cost[i];
			if (cirSum < 0){
				index = i;
				cirSum = 0;
			}
		}
		if (sum < 0){
			return -1;
		}
		return index + 1;//Return 1-based index; Cannot put it in Line10 'cause it may never meet Line9 and return -1;
	}
}