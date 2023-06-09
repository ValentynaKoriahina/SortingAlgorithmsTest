package testAlgs;

import java.util.Arrays;

/**
 * This class contains the Counting sort algorithm,
 * adopted from https://www.programiz.com/dsa/merge-sort
 */

public class Merge extends Sorter{


	/**
	 * This method splits and merges arrays
	 *
	 * @param arr - original array
	 * @param p - leftmost index
	 * @param r - rightmost index
	 * @param q - array division point
	 */
	
	void merge(int arr[], int p, int q, int r) {

		// Create subarrays.
		int n1 = q - p + 1;
		int n2 = r - q;

		int L[] = new int[n1];
		int M[] = new int[n2];

		for (int i = 0; i < n1; i++)
			L[i] = arr[p + i];
		for (int j = 0; j < n2; j++)
			M[j] = arr[q + 1 + j];

		// Tracking indexes in subarrays. These indexes are incremented
		// after comparing elements of their subarrays.
		int i, j, k;
		i = 0;
		j = 0;
		k = p;

		// Comparing, selecting and placing elements
		// to the appropriate position in the original array.
		while (i < n1 && j < n2) {
			if (L[i] <= M[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = M[j];
				j++;
			}
			k++;
		}

		// This loop places the remaining elements from the longer 
		// subarray into the original array (in case the compared 
		// subarrays are of different lengths).
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		while (j < n2) {
			arr[k] = M[j];
			j++;
			k++;
		}
	}

	/**
	 * This method is the starting point. 
	 * It recursively identifies the points of division of the array
	 * into subarrays, then runs a method that does the dividing itself
	 * and joining the elements of the arrays in a certain order.
	 *
	 * @param arr - the original array
	 * @param l - leftmost index
	 * @param r - rightmost index
	 * @return - sorted out initial array
	 */
	
	@Override
	public int[] orderArr(int[] arr, int l, int r) {
		if (l < r) {

			// Determining the point at which the array will be divided
			// essentially equal to dividing the length of the array by 2.
			int m = (l + r) / 2;

			orderArr(arr, l, m);
			orderArr(arr, m + 1, r);

			// Running the array merge method.
			merge(arr, l, m, r);
		}
		
		return arr;
	}

	public static void main(String args[]) {
		// Test data to test the algorithm, when running from the current class.
		int[] arr = {4, 2, 5, 7, 111, 2, 7, -3};
		Merge testAlg = new Merge();
		
		System.out.println(Arrays.toString(testAlg.orderArr(arr, 0, arr.length - 1)));
	}
}