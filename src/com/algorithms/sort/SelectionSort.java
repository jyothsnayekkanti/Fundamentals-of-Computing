package com.algorithms.sort;

public class SelectionSort implements ISorter{

	@Override  
	public String sortType()
	{
		return "Selection Sort";
	}	

	@Override  
	public int[] sort(int inputArray[], int length){
		int[] sortedArray = inputArray;
		for(int x=0; x<length; x++){
			int index_of_min = x;
			for(int y=x; y<length; y++){
				if(sortedArray[index_of_min]<sortedArray[y]){
					index_of_min = y;
				}
			}
			int temp = sortedArray[x];
			sortedArray[x] = sortedArray[index_of_min];
			sortedArray[index_of_min] = temp;
		}
		return sortedArray;
	}

	@Override
	public String bestComplexity() {
		return "O(n2)";
	}

	@Override
	public String averageComplexity() {
		return "O(n2)";
	}

	@Override
	public String worstComplexity() {
		return "O(n2)";
	}	

}
