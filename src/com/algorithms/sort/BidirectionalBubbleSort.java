package com.algorithms.sort;

public class BidirectionalBubbleSort implements ISorter {

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

	@Override
	public String describe() {
		return "Bi-directional bubble sort is a alternative of bubble sort. In this at least one elements is moved forward or backward to its place in the array with each pass.  It compares each adjacent pair of elements in an array. The values will be swap if necessary. The values passes from the beginning to the end and also from the end to the beginning. It stops when there is no any element to swap.";
	}	

}
