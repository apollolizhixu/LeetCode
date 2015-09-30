public class Mergesort {
	public int[] mergeSort(int[] a) {
		if (a == null || a.length == 0) {
			return a;
		}
		int[] tmp = new int[a.length];
		mergeSort(a, tmp, 0, a.length - 1);
		return a;
	}
	public void mergeSort(int[] a, int[] tmp, int left, int rightEnd) {
		int mid = (rightEnd - left) / 2 + left;
		if (left < rightEnd) {
			mergeSort(a, tmp, left, mid);
			mergeSort(a, tmp, mid + 1, rightEnd);
			merge(a, tmp, left, mid + 1, rightEnd);
		}
	}
	public void merge(int[] a, int[] tmp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;
		while (left <= leftEnd && right <= rightEnd) {
			if (a[left] <= a[right]) {
				tmp[k] = a[left];
				left++;
			} else {
				tmp[k] = a[right];
				right++;
			}
			k++;
		}
		while (left <= leftEnd) {
			tmp[k] = a[left];
			k++;
			left++;
		}
		while (right <= rightEnd) {
			tmp[k] = a[right];
			k++;
			right++;
		}
		for (int i = 0; i < num; i++) {
			a[rightEnd - i] = tmp[rightEnd - i];
		}
	}

	public static void main(String[] args) {
		Mergesort m = new Mergesort();
		int[] a = {2, 5, 3, 0, 2, 3, 0, 3};
		m.mergeSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}