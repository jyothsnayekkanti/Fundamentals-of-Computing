package com.algorithms.sort;

public interface ISorter {

	public String sortType();

	public int[] sort(int[] inputArray, int length);
	
	public String bestComplexity();
	public String averageComplexity();
	public String worstComplexity();	
	
}
