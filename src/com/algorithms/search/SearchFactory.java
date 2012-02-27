package com.algorithms.search;


public class SearchFactory {
	
	public static ISearcher createSearcher(String searchType)
	{
		ISearcher searcher = null;
		
		if(searchType.equalsIgnoreCase("Binary Search"))
		{
			searcher = new BinarySearch();
		}
		else if(searchType.equalsIgnoreCase("Sequential Search"))
		{
			searcher = new SequentialSearch();
		}
		return searcher;
	}

}
