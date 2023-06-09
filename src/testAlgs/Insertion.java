package testAlgs;

/**
 * This class contains the Insertion sort algorithm,
 * developed independently based on the lecture material
 */


import java.util.Arrays;

public class Insertion extends Sorter{
	
    @Override
	public int[] orderArr(int[] arr) {
    	
    	
    	// The variable 'i' is set to 1, because the first element 
    	// is conditionally considered to be sorted.  	
		int i = 1;
		while (i < arr.length) {
			int j = i;
			while (j > 0 && arr[j-1] > arr[j]) {
				// The loop condition compares two neighboring elements,
				// if the condition is met, a swap of element values is made.
				// It will continue until the element at position j-1 
				// becomes <= to the element at position j.
				int buffer = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = buffer;
				j--;
			}
			i++;
		}
		return arr;
	}
	
	public static void main(String[] args) {
		// Test data to test the algorithm, when running from the current class.
		int[] arr = {4, 2, 5, 7, 2, 7, -3};
		Insertion testAlg = new Insertion();
		System.out.println(Arrays.toString(testAlg.orderArr(arr)));
	}
}

