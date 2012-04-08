package com.algorithms.sort;


public class BubbleSort implements ISorter{

	@Override  
	public String sortType()
	{
		return "Bubble Sort";
	}	

	@Override 
	public int[] sort( int inputArray[], int length ){
		int[] sortedArray = inputArray;
		int i, j,t=0;
		for(i = 0; i < length; i++){
			for(j = 1; j < (length-i); j++){
				if(sortedArray[j-1] > sortedArray[j]){
					t = sortedArray[j-1];
					sortedArray[j-1]=sortedArray[j];
					sortedArray[j]=t;
				}
			}
		}
		return sortedArray;
	}

	@Override
	public String bestComplexity() {
		return "O(n)";
	}

	@Override
	public String averageComplexity() {
		return "O(n^2)";
	}

	@Override
	public String worstComplexity() {
		return "O(n^2)";
	}

	@Override
	public String describe() {
		return "Bubble sort is a simplest sorting algorithm. Bubble sort is also known as exchange sort.  Bubble sorting algorithm compare two values and put the largest value at largest index. The algorithm follow the same steps repeatedly until the values of array is sorted.";
	}
	
	public void animate(int inputArray[])
	{
		int length = inputArray.length;
		int[] sortedArray = inputArray;
		int i, j,t=0;
		for(i = 0; i < length; i++){
			for(j = 1; j < (length-i); j++){
				if(sortedArray[j-1] > sortedArray[j]){
					t = sortedArray[j-1];
					sortedArray[j-1]=sortedArray[j];
					sortedArray[j]=t;
				}
			}
		}		
	}

}
