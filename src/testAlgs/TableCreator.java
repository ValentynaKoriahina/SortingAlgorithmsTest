package testAlgs;

/**
 * This class contains a method that generates
 * table of measurement results and saves the measurement data.
 */

public class TableCreator {
	
	static String[][] resultTable;
	static int row = 1;
	static int column = 1;
	
	/**
	 * Method creates a table template.
	 */
    public static void createTableSkeleton() {
    	resultTable = new String[6][14];
    	resultTable[0][0] = "Size";
    	resultTable[1][0] = "Bubble";
    	resultTable[2][0] = "Selection";
    	resultTable[3][0] = "Insertion";
    	resultTable[4][0] = "Counting";
    	resultTable[5][0] = "Merge";
    }
    
	/**
	 * Method outputs the filled table to the console.
	 */
    public static void printTable() {
    	for (String[] row : resultTable) {
	        System.out.printf("%-11s %-7s %-7s %-7s %-7s %-7s %-7s"
	        		+ "%-7s %-7s %-7s %-7s %-7s %-7s %-7s\n", 
	        		row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7]
	        				, row[8], row[9], row[10], row[11], row[12], row[13]);	   
	    }
    }
    
	/**
	 * Method adds the obtained measurement results to the table.
	 *
	 * @param arrayLen - length of the array, for which the measurements were taken
	 * @param data - result of measurements
	 * @param column - column for adding data
	 */  
    public static void addDataToTable(int arrayLen, String data, int column) {
    	resultTable[0][column] = "" + arrayLen;
    	resultTable[row][column] = "" + data;
    	
    	// This allows you to calculate whether a row in the table is filled completely 
    	// and move on to the next
    	if (column == 13) {
    		row++;
    	}
   	}
}
