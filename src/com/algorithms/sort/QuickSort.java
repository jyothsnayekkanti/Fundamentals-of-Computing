package com.algorithms.sort;

public class QuickSort implements ISorter{


	@Override
	public String sortType() {
		return "Quick Sort";
	}

	@Override  
	public int[] sort(int array[], int n)
	{
		return sort(array, 0, n-1);
	}	

	public int[] sort(int array[],int low, int n){
		int lo = low;
		int hi = n;
		if (lo >= n) {
			return array;
		}
		int mid = array[(lo + hi) / 2];
		while (lo < hi) {
			while (lo<hi && array[lo] < mid) {
				lo++;
			}
			while (lo<hi && array[hi] > mid) {
				hi--;
			}
			if (lo < hi) {
				int T = array[lo];
				array[lo] = array[hi];
				array[hi] = T;
			}
		}
		if (hi < lo) {
			int T = hi;
			hi = lo;
			lo = T;
		}
		sort(array, low, lo);
		sort(array, lo == low ? lo+1 : lo, n);
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
		return "O(n2)";
	}	

}
