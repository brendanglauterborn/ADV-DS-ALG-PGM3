//Brendan Lauterborn
//Programming Assignment 3
//q4

import java.util.Random;
import java.util.List;
import java.util.ArrayList;
public class q4 {
	
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
	
	public static void radixSort(int[] nums) {
		int max = nums[0];
		for(int num : nums) {
			if(num > max) {
				max = num;
			}
		}
		int exponent = 1;
		while(max / exponent > 0) {
			List<List<Integer>> buckets = new ArrayList<>();
			for(int i = 0; i < 10; i++) {
				buckets.add(new ArrayList<>());
			}
			
			for(int num : nums) {
				int slot = (num / exponent) % 10;
				buckets.get(slot).add(num);
			}
			int index = 0;
			for(List<Integer> bucket : buckets) {
				for(int num : bucket) {
					nums[index] = num;
					index++;
				}
			}
			exponent *= 10;
		}
	}
	

	public static void main(String[] args) {
		int size = 5000;
		int[] nums = generate_array(size);
		long start = System.nanoTime();
		radixSort(nums);
		long end = System.nanoTime();
		System.out.println("Radix sort. O(d(N+K)). Actual runtime: " + (end - start)/1e6 + "ms\n");
		System.out.println("The first 100 numbers: \n");
		for(int i = 0; i < 100; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println("\n");
		System.out.println("The last 100 numbers: \n");
		for(int i = nums.length - 100 - 1; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
