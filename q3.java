//Brendan Lauterborn
//Programming Assignment 3
//q3

import java.util.Random;

public class q3 {
	
	public static int[] generate_array(int size) {
		Random random = new Random();
		int[] nums = new int[size];
		int max = 500;
		int min = 0;
		for(int i = 0; i < size; i++) {
			nums[i] = random.nextInt(max - min + 1)+ min;

		}
		return nums;
		
	}
	
	public static int[] countingSort(int[] nums) {
		int max = nums[0];
		for(int num : nums) {
			if(num > max) {
				max = num;
			}
		}
		int[] counts = new int[max+1];
		
		for(int num : nums) {
			counts[num]++;
		}
		int index = 0;
		for(int i = 0; i < counts.length; i++) {
			while(counts[i] > 0) {
				nums[index] = i;
				index++;
				counts[i]--;
			}
		}
		return nums;
		
	}
	public static void main(String[] args) {
		int size = 5000;
		int[] nums = generate_array(size);
		long start = System.nanoTime();
		countingSort(nums);
		long end = System.nanoTime();
		System.out.println("Counting sort: O(n+k).\nActual runtime is " + (end - start)/1e6 + "ms" );
		for(int i = 99; i < nums.length; i += 100) {
				System.out.print(nums[i] + " ");
			
		}

	}

}
