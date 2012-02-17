package com.example;

import android.app.Activity;

public class SortActivity extends Activity {
	
	public void sortDemo(){
		int[] array  = generateRandomArray();
		int length = array.length;
		insertion_sort(array, length);
		selection_sort(array, length);
		bubble_sort(array, length);
		//mergeSort
		//shell sort
		//Heap Sort
		//Quick sort
		
	}  
	
	public int[] generateRandomArray()
	  {
		  return null;
	  }
	
	  public int[] insertion_sort(int array[],int length){
		  int[] sortedArray = array;	
		  
		  long startTime = System.currentTimeMillis();
		  for (int i = 1; i < length; i++){
		  int j = i;
		  int B = array[i];
		  while ((j > 0) && (array[j-1] > B)){
		  array[j] = array[j-1];
		  j--;
		  }
		  array[j] = B;
		  }
		  long endTime = System.currentTimeMillis();
		  System.out.println("Total elapsed time in execution sort is :"+ (endTime-startTime));
		  return sortedArray;
		  }
	  
	  
	  public int[] selection_sort(int array[], int length){

		  int[] sortedArray = array;	
		  long startTime = System.currentTimeMillis();
		  
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
		  
		  long endTime = System.currentTimeMillis();
		  System.out.println("Total elapsed time in execution sort is :"+ (endTime-startTime));	
		  return sortedArray;		  
		  }
	  
	  
	  public int[] bubble_sort( int array[], int length ){
		  int[] sortedArray = array;
		  long startTime = System.currentTimeMillis();
		  
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
		  long endTime = System.currentTimeMillis();
		  System.out.println("Total elapsed time in execution sort is :"+ (endTime-startTime));
		  return sortedArray;		  
		  }	
	  
	  public static void mergeSort_sort(int array[],int lo, int n){
		  int low = lo;
		  int high = n;
		  if (low >= high) {
		  return;
		  }

		  int middle = (low + high) / 2;
		  mergeSort_sort(array, low, middle);
		  mergeSort_sort(array, middle + 1, high);
		  int end_low = middle;
		  int start_high = middle + 1;
		  while ((lo <= end_low) && (start_high <= high)) {
		  if (array[low] < array[start_high]) {
		  low++;
		  } else {
		  int Temp = array[start_high];
		  for (int k = start_high- 1; k >= low; k--) {
		  array[k+1] = array[k];
		  }
		  array[low] = Temp;
		  low++;
		  end_low++;
		  start_high++;
		  }
		  }
		  } 	  

}