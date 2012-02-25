package com.algorithms.sort;

public class HeapSort implements ISorter{

	@Override  
	public String sortType()
	{
		return "Heap Sort";
	}	

	@Override  
	public int[] sort(int[] arr, int length)
	{
		for(int i=length; i>1; i--){
			sortHeap(arr, i - 1);
		}
		return arr;
	}

	private int[] sortHeap(int array[], int arr_ubound){
		int i, o;
		int lChild, rChild, mChild, root, temp;
		root = (arr_ubound-1)/2;

		for(o = root; o >= 0; o--){
			for(i=root;i>=0;i--){
				lChild = (2*i)+1;
				rChild = (2*i)+2;
				if((lChild <= arr_ubound) && (rChild <= arr_ubound)){
					if(array[rChild] >= array[lChild])
						mChild = rChild;
					else
						mChild = lChild;
				}
				else{
					if(rChild > arr_ubound)
						mChild = lChild;
					else
						mChild = rChild;
				}

				if(array[i] < array[mChild]){
					temp = array[i];
					array[i] = array[mChild];
					array[mChild] = temp;
				}
			}
		}
		temp = array[0];
		array[0] = array[arr_ubound];
		array[arr_ubound] = temp;
		return array;
	}

	@Override
	public String bestComplexity() {
		return "O(n log n)";
	}

	@Override
	public String averageComplexity() {
		return "O(n log n)";
	}

	@Override
	public String worstComplexity() {
		return "O(n log n)";
	}
}
