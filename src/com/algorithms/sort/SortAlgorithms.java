package com.algorithms.sort;

import com.algorithms.AlgorithmHelper;

public class SortAlgorithms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length = 5;
		int[] inputArray;

		inputArray = getRandonNumberArray(length);
		sort(new InsertionSort(), inputArray, length);
		inputArray = getRandonNumberArray(length);
		sort(new SelectionSort(), inputArray, length);
		inputArray = getRandonNumberArray(length);
		sort(new BubbleSort(), inputArray, length);
		inputArray = getRandonNumberArray(length);
		sort(new BidirectionalBubbleSort(), inputArray, length);
		inputArray = getRandonNumberArray(length);
		sort(new MergeSort(), inputArray, length);		
		inputArray = getRandonNumberArray(length);
		sort(new HeapSort(), inputArray, length);	
		inputArray = getRandonNumberArray(length);
		sort(new QuickSort(), inputArray, length);
		//TO DO shell sort
		//TO DO quick3 sort

	}

	public static void sort(ISorter sorter, int[] inputArray, int length){
		long startTime;
		long endTime;
		System.out.println("Input Array : "+inputArray[0] + ","+inputArray[1] + ","+inputArray[2] + ","+inputArray[3] + ","+inputArray[4]);
		startTime = getCurrentTimeInMillisecs();
		System.out.println(startTime);
		int[] sortedArray = sorter.sort(inputArray, length);
		endTime = getCurrentTimeInMillisecs();
		System.out.println(endTime);
		System.out.println("Sorted Array using "+sorter.sortType()+" : "+sortedArray[0] + ","+sortedArray[1] + ","+sortedArray[2] + ","+sortedArray[3] + ","+sortedArray[4]);
		System.out.println("Time taken using "+sorter.sortType()+" : "+ (endTime-startTime));		
	}

	private static int[] getRandonNumberArray(int length)
	{
		return AlgorithmHelper.getRandonNumberArray(length);
	}

	private static long getCurrentTimeInMillisecs(){
		return AlgorithmHelper.getCurrentTimeInMillisecs();
	}	

}
