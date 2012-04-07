package com.example;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.algorithms.AlgorithmHelper;
import com.algorithms.search.ISearcher;
import com.algorithms.search.SearchFactory;

public class SearchActivity extends MenuActivity {
	Spinner spinner;	
	TextView input;
//	TextView output;
	EditText searchElement;
	String searchType = null;
	String searchDescription = null;
//	TextView aboutSearchType;
	TextView describeSearchType;	
	TextView aboutComplexityBest;
	TextView aboutComplexityAvg;
	TextView aboutComplexityWorst;	
	ISearcher searcher;
	
	private String inputTextValue = null;

	public String getInputTextValue() {
		return inputTextValue;
	}

	public void setInputTextValue(String inputTextValue) {
		this.inputTextValue = inputTextValue;
	}	
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		final Context context = this;
		searchType = getIntent().getStringExtra("searchType");
		//searchType = "Binary Search";
		searcher = SearchFactory.createSearcher(searchType);
		searchDescription = searcher.describe();
		setContentView(R.layout.searchtabs);

//		aboutSearchType = (TextView) findViewById(R.id.aboutSearchType);
		describeSearchType = (TextView) findViewById(R.id.describeSearchType);
		input = (TextView) findViewById(R.id.searchInputValues);
//		output = (TextView) findViewById(R.id.searchOutputValues);
		searchElement = (EditText) findViewById(R.id.searchInputElement);
		aboutComplexityBest = (TextView) findViewById(R.id.complexityLabelBestValue);
		aboutComplexityAvg = (TextView) findViewById(R.id.complexityLabelAverageValue);
		aboutComplexityWorst = (TextView) findViewById(R.id.complexityLabelWorstValue);		
		
//		aboutSearchType.setText(searchType);
		describeSearchType.setText(searchDescription);
		aboutComplexityBest.setText(searcher.bestComplexity());
		aboutComplexityAvg.setText(searcher.averageComplexity());	
		aboutComplexityWorst.setText(searcher.worstComplexity());	
		
		int[] inputArray = AlgorithmHelper.getRandonNumberArray(10);
		input.setText(AlgorithmHelper.getInputString(inputArray," | "));
		searchElement.setText("0");
		
	    Button generateButton = (Button)findViewById(R.id.generateSearchButton);
	    generateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int[] inputArray = AlgorithmHelper.getRandonNumberArray(10);
				input.setText(AlgorithmHelper.getInputString(inputArray," | "));
			}
		});
	    
	    Button searchButton = (Button)findViewById(R.id.searchButton);
	    searchButton.setOnClickListener(new OnClickListener() {
			
	    	@Override
	    	public void onClick(View v) {
	    		int[] inputArray = AlgorithmHelper.getInputArray(input.getText().toString()," | ");
	    		int element;
	    		if(null != searchElement.getText() && !searchElement.getText().toString().equals("")){
	    		element = Integer.parseInt(searchElement.getText().toString());
	    		boolean isEementFound = false;
	    		isEementFound = searcher.contains(inputArray, element);
	    		getResultText(isEementFound);
	    		//output.setText(getResultText(isEementFound));
	    		}
	    		else
	    		{
	    			// Create a piece of toast.
	    			Toast pieceToast = Toast.makeText(getApplicationContext(), "Enter number to Search", Toast.LENGTH_SHORT);

	    			// Show the toast.
	    			pieceToast.show();	    			
	    		}
	    	}
	    });	    
	    
	    Button animateButton = (Button)findViewById(R.id.animateButton);
	    animateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				setContentView(R.layout.sortanimate);
				Intent intent = new Intent(context, AnimateSearchActivity.class);
				context.startActivity(intent);				
			}
		});
	    
	    Button explainButton = (Button)findViewById(R.id.explainButton);
	    explainButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, WebViewActivity.class);
				intent.putExtra("componentType", "search");
				intent.putExtra("type", searchType);					
				context.startActivity(intent);
			}
		});
	    
		View menuView = (View) findViewById(R.id.menus);
		(menuView.findViewById(R.id.home)).setOnClickListener(toHomeButtonListener);		
		(menuView.findViewById(R.id.converter)).setOnClickListener(toConverterButtonListener);
		(menuView.findViewById(R.id.sorter)).setOnClickListener(toSorterButtonListener);		
		(menuView.findViewById(R.id.searcher)).setOnClickListener(toSearcherButtonListener);
//		(menuView.findViewById(R.id.gates)).setOnClickListener(toGatesButtonListener);
		(menuView.findViewById(R.id.help)).setOnClickListener(helpButtonListener);		

//		spinner = (Spinner) findViewById(R.id.spinner);
//		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.search_array, android.R.layout.simple_spinner_item);
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//		spinner.setAdapter(adapter);
//		
//		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
//			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) 
//			{
//				if(pos == 0){
//				searchType = "Binary Search";
//				}
//				else{
//					searchType = "Sequential Search";
//				}
//				searcher = SearchFactory.createSearcher(searchType);
//				searchDescription = searcher.describe();
//				//setContentView(R.layout.search);
//
////				aboutSearchType = (TextView) findViewById(R.id.aboutSearchType);
//				describeSearchType = (TextView) findViewById(R.id.describeSearchType);
//				input = (TextView) findViewById(R.id.searchInputValues);
////				output = (TextView) findViewById(R.id.searchOutputValues);
//				searchElement = (EditText) findViewById(R.id.searchInputElement);
//				aboutComplexityBest = (TextView) findViewById(R.id.complexityLabelBestValue);
//				aboutComplexityAvg = (TextView) findViewById(R.id.complexityLabelAverageValue);
//				aboutComplexityWorst = (TextView) findViewById(R.id.complexityLabelWorstValue);		
//				
////				aboutSearchType.setText(searchType);
//				describeSearchType.setText(searchDescription);
//				aboutComplexityBest.setText(searcher.bestComplexity());
//				aboutComplexityAvg.setText(searcher.averageComplexity());	
//				aboutComplexityWorst.setText(searcher.worstComplexity());	
//				
////				int[] inputArray = AlgorithmHelper.getRandonNumberArray(10);
////				input.setText(AlgorithmHelper.getInputString(inputArray));
//				searchElement.setText("0");				
//			}
//			
//			public void onNothingSelected(@SuppressWarnings("rawtypes") AdapterView parent) {
//				// Do nothing.
//			} 			
//		});
		
	}
	
	private String getResultText(boolean isEementFound){
		String result = null;
		
		if(!isEementFound)
		{
//			result = "Given number does not exist";
			// Create a piece of toast.
			Toast pieceToast = Toast.makeText(getApplicationContext(), "Given number does not exist", Toast.LENGTH_SHORT);

			// Show the toast.
			pieceToast.show();	   
		}
		else 
		{
//			result = "Given number found";
			// Create a piece of toast.
			Toast pieceToast = Toast.makeText(getApplicationContext(), "Given number found", Toast.LENGTH_SHORT);

			// Show the toast.
			pieceToast.show();	   			
		}
		return result;
	}
		
	
}
