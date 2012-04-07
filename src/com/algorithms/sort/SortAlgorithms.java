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
		startTime = getCurrentTimeInMillisecs();
		int[] sortedArray = sorter.sort(inputArray, length);
		endTime = getCurrentTimeInMillisecs();
	}

	private static int[] getRandonNumberArray(int length)
	{
		return AlgorithmHelper.getRandonNumberArray(length);
	}

	private static long getCurrentTimeInMillisecs(){
		return AlgorithmHelper.getCurrentTimeInMillisecs();
	}	

}
