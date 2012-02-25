package com.algorithms.sort;

public class MergeSort implements ISorter{

	@Override  
	public String sortType()
	{
		return "Merge Sort";
	}

	@Override  
	public int[] sort(int array[], int n)
	{
		return sort(array, 0, n-1);
	}

	private int[] sort(int array[],int lo, int n){
		int low = lo;
		int high = n;
		if (low >= high) {
			return array;
		}

		int middle = (low + high) / 2;
		sort(array, low, middle);
		sort(array, middle + 1, high);
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
