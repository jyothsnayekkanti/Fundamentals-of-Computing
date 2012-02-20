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

}
