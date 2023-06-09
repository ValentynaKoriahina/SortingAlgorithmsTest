package testAlgs;

import java.text.DecimalFormat;

/**
 * The main class of the program, 
 * which runs all the necessary methods and functions.
 */

public class Main {
	
	// Method starts all basic procedures.
	public static void timepiece(Sorter sortingMethod, String marker) {
		
		int[] arrayLengthSample = {100, 250, 500, 750, 1000, 1250, 2500 
				, 3750, 5000, 6250, 7500, 8750, 10000};
		int arrayLength;
		double elapsedTimeSum;
		int tableColumn;
		
		// Get the length of the array.
		for (int i = 0; i < arrayLengthSample.length; i++) {
			arrayLength = arrayLengthSample[i];
			
			// Use the iteration number of the loop to calculate
			// the column to enter the results in the table
			tableColumn = i + 1;

			// Set the value of the variable for counting time to 0.
			elapsedTimeSum = 0;
		
			//  Initiate a 10x repetition of the sorting.
			for (int j = 0; j < 10; j++) {
				
				// Create an array of a given length.
				int[] array = MyArrays.createArray(arrayLength);
				
				// Enable time measurement. 
				// https://java-lessons.ru/date-time/measure-elapsed-time
				long start = System.nanoTime();
				
				// Performing the sorting itself.
				if (marker != "Merge") {
					sortingMethod.orderArr(array);
				} else {
					sortingMethod.orderArr(array, 0, array.length - 1);
				}
				
				
				// Record the end time of the measurement.
				// https://java-lessons.ru/date-time/measure-elapsed-time
				long finish = System.nanoTime();
				
				// Сalculate the time taken.
				// Translate nanoseconds into milliseconds, so as not to lose
				// the fractional part, divide by 1000000.0
				double elapsed = (finish - start) / 1000000.0;
				
				// Save the result for the current measurement.
				elapsedTimeSum += elapsed;
			}
			

		    // Find the average time for the obtained 10 measurements.
			double elapsedTimeAVG = elapsedTimeSum / 10.0;
			
			// Round the value to three decimal places.
			DecimalFormat d = new DecimalFormat("0.000");
			String formattedElapsedTimeAVG = d.format(elapsedTimeAVG);
			
			// Save the result to a common table.
			// Arguments: array length, measurement result, column number.
			TableCreator.addDataToTable(arrayLength, formattedElapsedTimeAVG, tableColumn);
		}
		
	}
	

	public static void main(String[] args) {
		// Create a table for saving and displaying results
		// The data will be entered into a common variable of the TableCreator class
		TableCreator.createTableSkeleton();
		
		// Сonsecutively pass each method of sorting
		// to the class method that measures the algorithm's speed
		System.out.println("Bubble sorting started");
		timepiece(new Bubble(), "Bubble");
		System.out.println("Selection sorting started");
		timepiece(new Selection(), "Selection");
		System.out.println("Insertion sorting started");
		timepiece(new Insertion(), "Insertion");
		System.out.println("Counting sorting started");
		timepiece(new Counting(), "Counting");
		System.out.println("Merge sorting started");
		timepiece(new Merge(), "Merge");
		
		System.out.println();
		
		// Output the table of results to the console.
		TableCreator.printTable();
	}
}
