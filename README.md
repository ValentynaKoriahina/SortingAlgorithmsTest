# SortingAlgorithmsTest
Application  to  benchmark  sorting  algorithms

This application include implementations of the five sorting algorithms, along with a main method 
which tests each of them. 
To benchmark the algorithms, was used arrays of randomly generated integers with ariety of 
different input sizes (100 - 10000). 
The running time (in milliseconds) for each algorithm measuring 10 times.

The implementation of Bubble Sort in the program code was done independently. The optimization
idea (the way to check if the array is sorted and exit the loop) is adopted from
https://www.geeksforgeeks.org/bubble-sort/.
The implementation of Selection Sort and Insertion Sort is done independently based on the lecture
material.
Merge Sort code adopted from https://www.programiz.com/dsa/merge-sort.
Counting Sort code adopted from https://www.programiz.com/dsa/counting-sort.

The program contains 9 classes. The "Main" class starts the whole application. The "TableCreator"
class is the class that implements methods to save the results of measurements, creating and
displaying the table of results in the console. The "MyArrays" class contains a method that
generates an array of a given length, the array is made up of random integers using the
random.nextInt() method. The upper limit for selecting numbers is set to 100. Class "Sorter" - is
the template of the main method of sorting programs. This superclass was used as a way to
implement the principle "Don't Repeat Yourself", in this case, by successive replacement of the
superclass method by subclass methods. The remaining 5 classes are implementations of separate
sorting algorithms.
