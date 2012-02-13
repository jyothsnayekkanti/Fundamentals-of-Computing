package com.algorithms.search;

public class BinarySearch implements Searcher {

	@Override
	public String searchType() {
		return "Binary Search";
	}

	@Override
	public boolean contains(int[] inputArray, int element) {
		if (inputArray.length == 0) {
			return false;
		}
		int low = 0;
		int high = inputArray.length-1;

		while(low <= high ) {
			int middle = (low+high) /2; 
			if (element> inputArray[middle] ){
				low = middle +1;
			} else if (element< inputArray[middle]){
				high = middle -1;
			} else { // The element has been found
				return true; 
			}
		}
		return false;
	}

}
