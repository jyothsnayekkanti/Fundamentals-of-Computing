package com.algorithms.search;

import com.algorithms.sort.BubbleSort;

public class BinarySearch implements ISearcher {

	@Override
	public String searchType() {
		return "Binary Search";
	}

	@Override
	public boolean contains(int[] inputArray, int element) {
		int[] sortedArray = new BubbleSort().sort(inputArray, inputArray.length);
		if (inputArray.length == 0) {
			return false;
		}
		int low = 0;
		int high = sortedArray.length-1;

		while(low <= high ) {
			int middle = (low+high) /2; 
			if (element> sortedArray[middle] ){
				low = middle +1;
			} else if (element< sortedArray[middle]){
				high = middle -1;
			} else { // The element has been found
				return true; 
			}
		}
		return false;
	}
	
//	@Override
//	public int contains(int[] inputArray, int element) {
//		int[] sortedArray = new BubbleSort().sort(inputArray, inputArray.length);
//		int index = 0;
//		if (sortedArray.length == 0) {
//			return 0;
//		}
//		int low = 0;
//		int high = sortedArray.length-1;
//
//		while(low <= high ) {
//			int middle = (low+high) /2; 
//			if (element> sortedArray[middle] ){
//				low = middle +1;
//			} else if (element< sortedArray[middle]){
//				high = middle -1;
//			} else { // The element has been found
//				return middle +1;
//			}
//		}
//		return 0;
//	}	

	@Override
	public String bestComplexity() {
		return "O(1)";
	}

	@Override
	public String averageComplexity() {
		return "O(log n)";
	}

	@Override
	public String worstComplexity() {
		return "O(log n)";
	}

	@Override
	public String describe() {
		// TODO Auto-generated method stub
		return "The advantage of a binary search over a linear search is astounding for large numbers. It can be done either recursively or iteratively.\n";
	}

}
