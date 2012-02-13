package com.algorithms.sort;

public class BidirectionalBubbleSort implements Sorter {

	@Override
	public String sortType()
	{
		return "Bidirectional Bubble Sort";
	}	

	@Override 
	public int[] sort(int inputArray[], int length){
		int[] sortedArray = inputArray;
		int j;
		int st = -1;
		while (st <  length) {
			st++;
			length--;
			for (j = st; j <  length; j++) {
				if (sortedArray[j] > sortedArray[j + 1]) {
					int T = sortedArray[j];
					sortedArray[j] = sortedArray[j + 1];
					sortedArray[j + 1] = T;
				}
			}
			for (j =  length; --j >= st;) {
				if (sortedArray[j] > sortedArray[j + 1]) {
					int T = sortedArray[j];
					sortedArray[j] = sortedArray[j + 1];
					sortedArray[j + 1] = T;
				}
			}
		}
		return sortedArray;
	}	

}
