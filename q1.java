//Brendan Lauterborn
//Programming Assignment 3
//q1


import java.util.Random;

public class q1 {
	public static int numSwaps = 0;

	public static int[] generate_array(int size) {
		Random random = new Random();
		int[] nums = new int[size];
		int max = 50000;
		int min = 0;
		for(int i = 0; i < size; i++) {
			nums[i] = random.nextInt(max - min + 1)+ min;

		}
		return nums;
		
	}
	
	public static int insert(int[] heap, int heapSize, int num) {
//		heapSize++;
		heap[heapSize] = num;
		percUp(heap, heapSize);
		return heapSize + 1;
	}
	
	public static void percUp(int[] heap, int i) {
		while(i > 0 ) {
			int parent = (i-1)/2;
			if(heap[i] < heap[parent]) {
				swap(heap, parent, i);
				i = parent;
				numSwaps++;
			}
			else break;
		}
	}
	
	public static void swap(int[] heap, int parent, int child) {
		int temp = heap[parent];
		heap[parent] = heap[child];
		heap[child] = temp;
		
	}
	
	public static void buildHeap(int[] heap) {
		int size = heap.length;
		for(int i = (size/2) -1;i >= 0; i--) {
			percDown(heap, i, size);
		}
	}
	
	public static void percDown(int[] heap, int i, int size) {
		int smallest = i; 
		int lChild = 2*i + 1;
		int rChild = 2*i + 2;
		
		if(lChild < size && heap[lChild] < heap[smallest]) {
			smallest = lChild;
		}
		if(rChild < size && heap[rChild] < heap[smallest]) {
			smallest = rChild;
		}
		if(smallest != i) {
			swap(heap, i, smallest);
			numSwaps++;
			percDown(heap, smallest, size);
		}
	}
	
	
	public static void main(String[] args) {
		int size = 5000;
		int heapSize = 0;
		int[] randomNums = generate_array(5000);
		int[] heap1 = new int[size];
		long start = System.nanoTime();
		for(int num : randomNums) {
			heapSize = insert(heap1, heapSize, num);
		}
		long end = System.nanoTime();
		System.out.println("First 50 values using nlogn build time\nNumber of swaps: "+ numSwaps);
		System.out.println("Actual runtime is " + (end - start)/1e6 + "ms" );
		for(int i = 0; i < 50; i++) {
			System.out.print(heap1[i] +" ");
		}
		int[] heap2 = new int[size];
		numSwaps = 0;
		System.out.println("\n");
		System.arraycopy(randomNums, 0, heap2, 0, size);
		start = System.nanoTime();
		buildHeap(heap2);
		end = System.nanoTime();
		System.out.println("First 50 values using linear build time\nNumber of swaps:" + numSwaps);
		System.out.println("Actual runtime is " + (end - start)/1e6 + "ms" );
		for(int i = 0; i < 50; i++) {
			System.out.print(heap2[i] +" ");
		}
	}
}
