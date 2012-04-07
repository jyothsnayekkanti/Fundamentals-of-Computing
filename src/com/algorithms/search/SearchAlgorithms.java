package com.algorithms.search;

import com.algorithms.AlgorithmHelper;

public class SearchAlgorithms {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int length = 5;
		int element = AlgorithmHelper.getRandomNumber();
		int[] inputArray;

		inputArray = getRandonNumberArray(length);
		search(new SequentialSearch(), inputArray, element);
		inputArray = getRandonNumberArray(length);
		search(new BinarySearch(), inputArray, element);

	}

	public static void search(ISearcher searcher, int[] inputArray, int element){
		long startTime;
		long endTime;
		boolean elementExists = false;
		int elementIndex = 0;
		startTime = getCurrentTimeInMillisecs();
		elementExists = searcher.contains(inputArray, element);
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
