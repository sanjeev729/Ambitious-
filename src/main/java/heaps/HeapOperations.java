package heaps;

public class HeapOperations {

	private int heap_size;
	private int capacity;
	private int[] harr;

	public HeapOperations(int cap) {
		heap_size = 0;
		capacity = cap;
		harr = new int[cap];
	}

	int parent(int i) {
		return (i - 1) / 2;
	}

	// Inserts a new key 'k'
	void insertKey(int k) throws Exception {

		if (heap_size == capacity) {
			throw new Exception("Overflow");
		}

		// First insert the new key at the end
		heap_size++;
		int i = heap_size - 1;
		harr[i] = k;

		// Fix the min heap property if it is violated
		while (i != 0 && harr[parent(i)] > harr[i]) {
			swap(harr[i], harr[parent(i)]);
			i = parent(i);
		}
	}

	private void swap(int i, int j) {
		int temp = i;
		i = j;
		j = temp;

	}

	// Decreases value of key at index 'i' to new_val. It is assumed that
	// new_val is smaller than harr[i]

	void decreaseKey(int i, int new_val) {
		harr[i] = new_val;
		while (i != 0 && harr[parent(i)] > harr[i]) {
			swap(harr[i], harr[parent(i)]);
			i = parent(i);
		}
	}

	// Method to remove minimum element (or root) from min heap
	int extractMin() {
		if (heap_size <= 0)
			return Integer.MAX_VALUE;
		if (heap_size == 1) {
			heap_size--;
			return harr[0];
		}

		// Store the minimum value, and remove it from heap
		int root = harr[0];
		harr[0] = harr[heap_size - 1];
		heap_size--;
		MinHeapify(0);

		return root;
	}

	// This function deletes key at index i. It first reduced value to minus
	// infinite, then calls extractMin()
	void deleteKey(int i) {
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}

	// A recursive method to heapify a subtree with root at given index
	// This method assumes that the subtrees are already heapified
	void MinHeapify(int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		int smallest = i;
		if (l < heap_size && harr[l] < harr[smallest])
			smallest = l;
		if (r < heap_size && harr[r] < harr[smallest])
			smallest = r;
		if (smallest != i) {
			swap(harr[i], harr[smallest]);
			MinHeapify(smallest);
		}
	}

	public static void main(String[] args){

		HeapOperations h = new HeapOperations(11);
		try {
			h.insertKey(3);
			h.insertKey(2);
			h.deleteKey(1);
			h.insertKey(15);
			h.insertKey(5);
			h.insertKey(4);
			h.insertKey(45);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());
		System.out.println(h.extractMin());

	}

}
