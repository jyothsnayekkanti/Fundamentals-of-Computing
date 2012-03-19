package com.algorithms.sort;

public class InsertionSort implements ISorter{

	@Override  
	public String sortType()
	{
		return "Insertion Sort";
	}

	@Override  
	public int[] sort(int inputArray[], int length){
		int[] sortedArray = inputArray;
		for (int i = 1; i < length; i++){
			int j = i;
			int B = sortedArray[i];
			while ((j > 0) && (sortedArray[j-1] > B)){
				sortedArray[j] = sortedArray[j-1];
				j--;
			}
			sortedArray[j] = B;
		}
		return sortedArray;
	}

	@Override
	public String bestComplexity() {
		return "O(n)";
	}

	@Override
	public String averageComplexity() {
		return "O(n2)";
	}

	@Override
	public String worstComplexity() {
		return "O(n<sup>2</sup>)";
	}

	@Override
	public String describe() {
		return "Insertion sort is a good choice for small values and for nearly-sorted values.  In insertion sorting algorithm compare the value until  all the prior elements are lesser than compared value is not found. This mean that the all previous values are lesser than compared value. ";
	}	

}
