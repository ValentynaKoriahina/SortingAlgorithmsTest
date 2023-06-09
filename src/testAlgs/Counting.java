package testAlgs;

/**
 * This class contains the Counting sort algorithm,
 * adopted from https://www.programiz.com/dsa/counting-sort
 */

import java.util.Arrays;


public class Counting extends Sorter {
	
	@Override
	public int[] orderArr(int[] arr) {
		int size = arr.length;
		
		// Create a new array to save the result.
		int[] output = new int[size + 1];
	
		// Calculates the largest element in array,
		// to determine the required length of the array
		// to store the number of occurrences of unique elements.
		int max = arr[0];
		for (int i = 1; i < size; i++) {
			if (arr[i] > max)
			max = arr[i];
		}
		int[] count = new int[max + 1];
	
		// Creation of an array with zero values
		// for further incrementing.
		for (int i = 0; i < max; ++i) {
			count[i] = 0;
		}
		
		// Counting the number of occurrences of unique elements.
		for (int i = 0; i < size; i++) {
			count[arr[i]]++;
		}
		
		// The product of the cumulative count, which is further
		// used to determine the index of the sorted item.
		for (int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}
		
		// Using the accumulated sum of the number of elements,
		// determine the position of each element in the output array.
		for (int i = size - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		
		// Transfer data from the secondary array to the main one.
		for (int i = 0; i < size; i++) {
			 arr[i] = output[i];
		}
		return arr;
	}

	public static void main(String args[]) {
		// Test data to test the algorithm, when running from the current class.
		int[] data = { 4, 2, 111, 2, 8, 3, 3, 1 };
		Counting testAlg = new Counting();
		testAlg.orderArr(data);
		System.out.println(Arrays.toString(data));
	}
}
