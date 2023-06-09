package testAlgs;

/**
 * This class contains the Selection sort algorithm,
 * developed independently based on the lecture material
 */

import java.util.Arrays;

public class Selection extends Sorter {
	
	@Override
	public int[] orderArr(int[] arr) {
		int n = arr.length;
		
		// These loops go through the elements of the original array and 
		// find the element with the minimum value. Initially, the element 
		// with the minimum value is conditionally the first element of the array.
		for (int i = 0; i < n-1; i++) {
			int minIndex = i;
			for (int j = i+1; j < n; j++) {
		        if (arr[j] < arr[minIndex]) {
		        	minIndex = j;
		        }
			}
			
			// Swap the first element of the unsorted part with the found minimum 
			// element, using the temporary variable 'buffer'.
			int buffer = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = buffer;
		}
		return arr;	
	}

	public static void main(String[] args) {
		// Test data to test the algorithm, when running from the current class.
		int[] arr = {4, 2, 5, 7, 2, 7, -3, 0};
		Selection testAlg = new Selection();
		System.out.println(Arrays.toString(testAlg.orderArr(arr)));
	}
}
