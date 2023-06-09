package testAlgs;

import java.util.Arrays;

/**
 * This class contains the Bubble sort algorithm,
 * developed independently based on the lecture material
 */

public class Bubble extends Sorter {
	
    @Override
	public int[] orderArr(int[] arr) {
    	boolean isSorted = false;
		while (isSorted == false) {
			// It will serve as an exit marker for loop
			// if no swap occurs in the current iteration (meaning the array is sorted)
			// https://www.programiz.com/dsa/bubble-sort
			isSorted = true; 
			for (int i = 0; i < arr.length - 1; i++) {
				// A temporary variable for swapping values between places.
				int buff = arr[i];
				// Compare the neighboring elements of the array, if smaller one
				// is find a, swap them in places.
				if (arr[i] > arr[i + 1]) {
					arr[i] = arr[i + 1];
					arr[i + 1] = buff;
					isSorted = false; 
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		// Test data to test the algorithm, when running from the current class.
		int[] arr = {4, 2, 5, 7, 2, 7, -3, 0};
		Bubble testAlg = new Bubble();
		System.out.println(Arrays.toString(testAlg.orderArr(arr)));
	}
}
