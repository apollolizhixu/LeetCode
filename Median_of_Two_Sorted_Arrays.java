public class Solution{
	public double findMedianSortedArrays(int A[], int B[]){
		if (A == null || B == null){
			return 0;
		}
		int len = A.length + B.length;
		if (len % 2 == 1){
			return findKth(A, 0, B, 0, len / 2 + 1);
		} else {
			return (findKth(A, 0, B, 0, len / 2 + 1) + findKth(A, 0, B, 0, len / 2)) / 2.0;
		}
	}
	public double findKth(int A[], int A_start, int B[], int B_start, int k){
		if (A_start >= A.length){
			return B[B_start + k - 1];
		}
		if (B_start >= B.length){
			return A[A_start + k - 1];
		}

		if (k == 1){
			return Math.min(A[A_start], B[B_start]);
		}

		int A_key = A_start + k / 2 - 1>= A.length ? 
			Integer.MAX_VALUE : A[A_start + k / 2 - 1];
		int B_key = B_start + k / 2 - 1>= B.length ? 
			Integer.MAX_VALUE : B[B_start + k / 2 - 1];

		if (A_key > B_key){
			return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
		} else {
			return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
		}
	}
}