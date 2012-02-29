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
		System.out.println("Input Array : "+inputArray[0] + ","+inputArray[1] + ","+inputArray[2] + ","+inputArray[3] + ","+inputArray[4]);
		System.out.println("Element to search : "+element);
		startTime = getCurrentTimeInMillisecs();
		System.out.println(startTime);
		elementExists = searcher.contains(inputArray, element);
//		elementIndex = searcher.contains(inputArray, element);
		endTime = getCurrentTimeInMillisecs();
		System.out.println(endTime);
		System.out.println("isElementExist : "+elementExists);
//		System.out.println("ElementExists at : "+elementIndex);
		System.out.println("Time taken to search using "+searcher.searchType()+" : "+ (endTime-startTime));		
	}

	private static int[] getRandonNumberArray(int length)
	{
		return AlgorithmHelper.getRandonNumberArray(length);
	}

	private static long getCurrentTimeInMillisecs(){
		return AlgorithmHelper.getCurrentTimeInMillisecs();
	}	

}
