package com.cooksys.ftd.assignments.control;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * The Fibonacci sequence is simply and recursively defined: the first two elements are `1`, and
 * every other element is equal to the sum of its two preceding elements. For example:
 * <p>
 * [1, 1] =>
 * [1, 1, 1 + 1]  => [1, 1, 2] =>
 * [1, 1, 2, 1 + 2] => [1, 1, 2, 3] =>
 * [1, 1, 2, 3, 2 + 3] => [1, 1, 2, 3, 5] =>
 * ...etc
 */
public class Fibonacci {

    /**
     * Calculates the value in the Fibonacci sequence at a given index. For example,
     * `atIndex(0)` and `atIndex(1)` should return `1`, because the first two elements of the
     * sequence are both `1`.
     *
     * @param i the index of the element to calculate
     * @return the calculated element
     * @throws IllegalArgumentException if the given index is less than zero
     */
    public static int atIndex(int i) throws IllegalArgumentException {
    	
    	int[] finalIndex = new int[1];
        int[] finalSlice= new int [i+1];
    	
    	if(i <0)
        {
        	throw new IllegalArgumentException();
        }
        
        if(i== 0)
        {
        	finalIndex[0] = 1;
        	return finalIndex[0];
        }else{

        	finalSlice= fibonacci(i+1);
        	finalIndex[0] = finalSlice[i];
        	return finalIndex[0];
        }
    }

    /**
     * Calculates a slice of the fibonacci sequence, starting from a given start index (inclusive) and
     * ending at a given end index (exclusive).
     *
     * @param start the starting index of the slice (inclusive)
     * @param end   the ending index of the slice(exclusive)
     * @return the calculated slice as an array of int elements
     * @throws IllegalArgumentException if either the given start or end is negative, or if the
     *                                  given end is less than the given start
     */
    public static int[] slice(int start, int end) throws IllegalArgumentException {
    	
    	if((start <0 || end<0) || (end <start))
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	if(end == 0)
    		return new int[0];
    	
    	int[] fib = fibonacci(end);
    	
    	int[] results = new int[end - start];
    	int counter = 0;
    	for(int i = start; i < end; i++) {
    		results[counter] = fib[i];
    		counter++;
    	}
    	
    	return results;	 	
    }

    /**
     * Calculates the beginning of the fibonacci sequence, up to a given count.
     *
     * @param count the number of elements to calculate
     * @return the beginning of the fibonacci sequence, up to the given count, as an array of int elements
     * @throws IllegalArgumentException if the given count is negative
     */
    
    // Creates the actual fib numbers. 
    public static int[] fibonacci(int count) throws IllegalArgumentException {
        
    	if (count <0)
    	{
    		throw new IllegalArgumentException();
    	}
    	
    	int firstNum = 0;
    	int secondNum = 1; 
    	int firstNumOld =1  ;
    
    	int[] finalNumbersArray = new int [count];
    	
    	for (int i = 0; i < finalNumbersArray.length; i++) 
    	{
			finalNumbersArray[i] = firstNumOld;
			firstNumOld = firstNum+secondNum;
			firstNum = secondNum;
			secondNum = firstNumOld;	
		}
    	
    	
    	return finalNumbersArray;
    }
}
