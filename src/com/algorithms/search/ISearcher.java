package com.algorithms.search;

public interface ISearcher {

	public String searchType();

	public boolean contains(int[] inputArray, int element);
//	public int contains(int[] inputArray, int element);	
	
	public String bestComplexity();
	public String averageComplexity();
	public String worstComplexity();		

}
