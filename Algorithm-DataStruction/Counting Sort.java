public class Solution {
		/* Average Time complexity: O(n + k);
		 * Worst Time complexity: O(n + k);
		 * Space complexity: O(n + k);
		*/
	public static int[] countingSort(int[] A, int k) {
		//Time: O(n + k), Space: O(n + k)
		int n = A.length;
		int[] B = new int[n];
		int[] C = new int[k];
		for (int i = 0; i < k; i++) {
			C[i] = 0;
		}
		for (int i = 0; i < n; i++) {
			//算出每个数有多少个
			C[A[i]]++;
		}
		for (int i = 1; i < k; i++) {
			//算出对每个数来说有多少数小于等于它
			C[i] += C[i - 1];
		}
		for (int i = n - 1; i >= 0; i--) {
			//对每一个A[i]来说，C[A[i]]为小于等于它的数的数目，则可以把它放在这些数的最后来排序
			//而且对于O-based，所以要减一，再放入B中作为排序后的顺序
			B[C[A[i]] - 1] = A[i];
			//此时C中未排序的等于小于当前数的数目；
			C[A[i]]--;
		}
		return B;
	}

		public static void main(String[] args) {
			int[] A = { 2, 5, 3, 0, 2, 3, 0, 3 };
			int[] B = countingSort(A, 6);
			for (int b : B) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
}