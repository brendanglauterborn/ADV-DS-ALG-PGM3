//Brendan Lauterborn
//Programming Assignment 3
//q2


import java.util.Random;

public class q2 {
	
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
	public static int[] insertSort(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			int temp = nums[i];
			int j = i-1;
			while(j >= 0 && nums[j] > temp) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = temp;
		}
		return nums;
		
	}
	
	public static int[] selectionSort(int[] nums) {
		for(int i = 0; i < nums.length - 1; i++) {
			int minIndex = i;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] < nums[minIndex]) {
					minIndex = j;
				}
			}
			int temp = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = temp;
			
		}
		return nums;
	}
	public static int[] bubbleSort(int[] nums) {
		boolean swap;
		for(int i = 0; i < nums.length - 1; i++) {
			swap = false;
			for(int j = 0; j < nums.length - i - 1; j++) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
					swap = true;
				}
			}
			if(!swap) break;
		}
		return nums;
	}
	
	public static void merge(int[] nums, int left, int mid, int right) {
		int sizeLeft = mid - left +1;
		int sizeRight = right - mid;
		int[] tempLeft = new int[sizeLeft];
		int[] tempRight = new int[sizeRight];
		
		for(int i = 0; i < sizeLeft; i++) {
			tempLeft[i] = nums[left + i];
		}
		for(int j = 0; j < sizeRight; j++) {
			tempRight[j] = nums[mid+j+1];
		}
		int i =0, j = 0, k = left;
		while(i < sizeLeft && j < sizeRight) {
			if(tempLeft[i] <= tempRight[j]) {
				nums[k] = tempLeft[i];
				i++;
			}
			else {
				nums[k] = tempRight[j];
				j++;
			}
			k++;
		}
		while(i < sizeLeft) {
			nums[k] = tempLeft[i];
			i++;
			k++;
		}
		while(j < sizeRight) {
			nums[k] = tempRight[j];
			j++;
			k++;
		}
	}
	public static void sort(int[] nums, int left, int right) {
		if(left < right) {
			int mid = (left + right) / 2;
			sort(nums, left, mid);
			sort(nums, mid+1, right);
			merge(nums, left, mid, right);
		}
	}

	public static void main(String[] args) {
		int size = 5000;
		int[] nums = generate_array(size);
		long start = System.nanoTime();
		insertSort(nums);
		long end = System.nanoTime();
		System.out.println("Insert sort: O(n^2).\nActual runtime is " + (end - start)/1e6 + "ms" );
		for(int i = 0; i < 100;i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println("\n");
		int[] nums2 = generate_array(size);
		start = System.nanoTime();
		selectionSort(nums2);
		end = System.nanoTime();
		System.out.println("Selection sort: O(n^2).\nActual runtime is " + (end - start)/1e6 + "ms" );
		for(int i = 0; i < 100;i++) {
			System.out.print(nums2[i]+" ");
		}
		System.out.println("\n");
		int[] nums3 = generate_array(size);
		start = System.nanoTime();
		bubbleSort(nums3);
		end = System.nanoTime();
		System.out.println("Bubble sort: O(n^2).\nActual runtime is " + (end - start)/1e6 + "ms" );
		for(int i = 0; i < 100;i++) {
			System.out.print(nums3[i]+" ");
		}
		System.out.println("\n");
		int[] nums4 = generate_array(size);
		start = System.nanoTime();
		sort(nums4,0, nums4.length-1);
		end = System.nanoTime();
		System.out.println("Merge sort: O(nlogn).\nActual runtime is " + (end - start)/1e6 + "ms" );
		for(int i = 0; i < 100;i++) {
			System.out.print(nums4[i]+" ");
		}
	}

}
