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
