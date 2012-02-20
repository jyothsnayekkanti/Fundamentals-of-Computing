package com.algorithms.sort;

public class SortFactory {
	
	
	public static ISorter createSorter(String sortType)
	{
		ISorter sorter = null;
		
		if(sortType.equalsIgnoreCase("Bubble Sort"))
		{
			sorter = new BubbleSort();
		}
		else if(sortType.equalsIgnoreCase("Insertion Sort"))
		{
			sorter = new InsertionSort();
		}
		else if(sortType.equalsIgnoreCase("Heap Sort"))
		{
			sorter = new HeapSort();
		}
		else if(sortType.equalsIgnoreCase("Merge Sort"))
		{
			sorter = new MergeSort();
		}
		else if(sortType.equalsIgnoreCase("Selection Sort"))
		{
			sorter = new SelectionSort();
		}
		else if(sortType.equalsIgnoreCase("Quick Sort"))
		{
			sorter = new QuickSort();
		}
		else if(sortType.equalsIgnoreCase("Bidirectional Bubble Sort"))
		{
			sorter = new BidirectionalBubbleSort();
		}
		return sorter;
	}

}
