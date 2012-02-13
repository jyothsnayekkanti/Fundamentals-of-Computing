package com.algorithms.search;

public class SequentialSearch implements Searcher {

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

}
