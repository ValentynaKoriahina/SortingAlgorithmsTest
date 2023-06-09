package testAlgs;

import java.util.Random;

/**
 * This class contains a method that generates an array.
 */

public class MyArrays {
	
	/**
	 * A method that returns an array of random numbers of a given length
	 *
	 * @param arraySize - the required length of the array
	 * @return array of random numbers of the specified length
	 */
	public static int[] createArray(int arraySize) {
		
		// The upper bound of the random numbers, exclusively
		int upperLimit = 100; 
		
		// Create an array of a specified length.
		int[] array = new int[arraySize]; 
		
		// Create an object to generate random numbers.
		Random random = new Random(); 
		
		for (int i = 0; i < array.length; i++) {
			// Apply a randomly generated number to the current array element.
			array[i] = random.nextInt(upperLimit); 
		}

		return array;
	}
	
}
