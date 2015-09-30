public class Heap {

	private static final int CAPACITY = 10;
	//Size: How many element in this heap
	private int size;
	private int[] heap;
	
	public Heap(){
		size = 0;
		heap = new int[CAPACITY + 1];
	}
	
	public Heap(int[] array){
		size = array.length;
		heap = new int[size + 1];
		//heap[0] is empty;
		
		System.arraycopy(array, 0, heap, 1, array.length);
		buildHeap();
	}
	
	private void buildHeap(){
		for (int k = size / 2; k > 0; k--){
			percolateDown(k);
		}
	}
	
	private void percolateDown(int hole){
		int temp = heap[hole];
		int child;
		
		for (; hole <= size / 2; hole = child){
			child = 2 * hole;
			if (child != size && heap[child] > heap[child + 1]){
				child++;
			}
			if (temp > heap[child]){
				heap[hole] = heap[child];
			} else {
				break;
			}
		}
		heap[hole] = temp;
	}
	
	public void insert(int k){
		//percolate up…œ¬À≤Ÿ◊˜
		if (size == heap.length - 1){
			enlargeArray(heap.length * 2 + 1);
		}
		int hole = ++size;
		for (; hole > 1 && k < heap[hole / 2]; hole /= 2){
			heap[hole] = heap[hole / 2];
		}
		heap[hole] = k;
	}
	
	public void enlargeArray(int newSize){
		int[] newHeap = new int[newSize];
		System.arraycopy(heap, 0, newHeap, 0, heap.length);
		heap = newHeap;
	}
	
	public int deleteMin(){
		if (heap.length == 0){
			return 0;
		}
		int minItem = findMin();
		heap[1] = heap[size--];
		percolateDown(1);
		
		return minItem;
	}
	
	public int findMin(){
		if (isEmpty() == true){
			return Integer.MIN_VALUE;
		}
		return heap[1];
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void printHeap() {
		for (int i = 1; i <= size; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = {2, 5, 3, 0, 2, 3, 0, 3};
		Heap h = new Heap(a);		
		h.printHeap();
		h.insert(4);
		h.printHeap();
		h.deleteMin();
		h.printHeap();
	}
}
