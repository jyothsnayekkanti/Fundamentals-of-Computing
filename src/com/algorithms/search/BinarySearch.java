package com.algorithms.search;

public class BinarySearch implements ISearcher {

	@Override
	public String searchType() {
		return "Binary Search";
	}

//	@Override
//	public boolean contains(int[] inputArray, int element) {
//		if (inputArray.length == 0) {
//			return false;
//		}
//		int low = 0;
//		int high = inputArray.length-1;
//
//		while(low <= high ) {
//			int middle = (low+high) /2; 
//			if (element> inputArray[middle] ){
//				low = middle +1;
//			} else if (element< inputArray[middle]){
//				high = middle -1;
//			} else { // The element has been found
//				return true; 
//			}
//		}
//		return false;
//	}
	
	@Override
	public int contains(int[] inputArray, int element) {
		int index = 0;
		if (inputArray.length == 0) {
			return 0;
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
				index = middle+1;
				return index; 
			}
		}
		return 0;
	}	

	@Override
	public String bestComplexity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String averageComplexity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String worstComplexity() {
		// TODO Auto-generated method stub
		return null;
	}

}
