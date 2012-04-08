package com.algorithms.search;

public class SequentialSearch implements ISearcher {

	@Override
	public String searchType() {
		return "Sequential Search";
	}

	@Override
	public boolean contains(int[] inputArray, int element) {
		for (int i : inputArray) {
			if (i==element){
				return true;
			}
		}
		return false; 
	}
	
//	@Override
//	public int contains(int[] inputArray, int element) {
//		int j = 1;
//		for (int i : inputArray) {
//			if (i==element){
//				return j;
//			}
//			j++;
//		}
//		return 0; 
//	}	

	@Override
	public String bestComplexity() {
		return "O(1)";
	}

	@Override
	public String averageComplexity() {
		return "O(n)";
	}

	@Override
	public String worstComplexity() {
		return "O(n)";
	}

	@Override
	public String describe() {
		// TODO Auto-generated method stub
		return "Linear searching is a good way to find an element from the array. The array can be of any order, it checks whether a certain element (number , string , etc. ) is in a specified array or not. Basically it is used for small arrays. ";
	}

}
