package com.example;

import java.util.StringTokenizer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.algorithms.AlgorithmHelper;
import com.algorithms.search.ISearcher;
import com.algorithms.search.SearchFactory;

public class SearchActivity extends Activity {
	TextView input;
	TextView output;
	EditText searchElement;
	String searchType = null;
	TextView aboutSearchType;
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
		searcher = SearchFactory.createSearcher(searchType);
		setContentView(R.layout.search);

		aboutSearchType = (TextView) findViewById(R.id.aboutSearchType);
		input = (TextView) findViewById(R.id.searchInputValues);
		output = (TextView) findViewById(R.id.searchOutputValues);
		searchElement = (EditText) findViewById(R.id.searchInputElement);
		aboutComplexityBest = (TextView) findViewById(R.id.complexityLabelBestValue);
		aboutComplexityAvg = (TextView) findViewById(R.id.complexityLabelAverageValue);
		aboutComplexityWorst = (TextView) findViewById(R.id.complexityLabelWorstValue);		
		
		aboutSearchType.setText(searchType);
		aboutComplexityBest.setText(searcher.bestComplexity());
		aboutComplexityAvg.setText(searcher.averageComplexity());	
		aboutComplexityWorst.setText(searcher.worstComplexity());	
		
		int[] inputArray = AlgorithmHelper.getRandonNumberArray(10);
		input.setText(AlgorithmHelper.getInputString(inputArray));
		searchElement.setText("0");
		
	    Button generateButton = (Button)findViewById(R.id.generateSearchButton);
	    generateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int[] inputArray = AlgorithmHelper.getRandonNumberArray(10);
				input.setText(AlgorithmHelper.getInputString(inputArray));
			}
		});
	    
	    Button searchButton = (Button)findViewById(R.id.searchButton);
	    searchButton.setOnClickListener(new OnClickListener() {
			
	    	@Override
	    	public void onClick(View v) {
	    		int[] inputArray = getInputArray(input.getText().toString());
	    		int element = Integer.parseInt(searchElement.getText().toString());
	    		boolean isEementFound = searcher.contains(inputArray, element);
	    		output.setText(getResultText(isEementFound));
	    	}
	    });	    
	    
	    Button animateButton = (Button)findViewById(R.id.animateButton);
	    animateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				setContentView(R.layout.sortanimate);
				Intent intent = new Intent(context, AnimateSortActivity.class);
				context.startActivity(intent);				
			}
		});
	    
	    Button explainButton = (Button)findViewById(R.id.explainButton);
	    explainButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, WebViewActivity.class);
				context.startActivity(intent);
			}
		});
	    
		Button toHomeButton = (Button)findViewById(R.id.home);
		toHomeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, MainActivity.class);
				context.startActivity(intent);
			}
		});
		
		Button toConverterButton = (Button)findViewById(R.id.converter);
		toConverterButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, ConverterActivity.class);
				context.startActivity(intent);
			}
		});

		Button toSorterButton = (Button)findViewById(R.id.sorter);
		toSorterButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, GalleryView.class);
				intent.putExtra("componentType", "sort");	
				context.startActivity(intent);				
			}
		});

		Button toSearcherButton = (Button)findViewById(R.id.searcher);
		toSearcherButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, GalleryView.class);
				intent.putExtra("componentType", "search");				
				context.startActivity(intent);				
			}
		});	    

		Button toGatesButton = (Button)findViewById(R.id.gates);
		toGatesButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, GalleryView.class);
				intent.putExtra("componentType", "gates");				
				context.startActivity(intent);				
			}
		});	    

	}
	
	private int[] getInputArray(String inputText)
	{
		
		StringTokenizer st = new StringTokenizer(inputText, ",");
		int[] array = new int[st.countTokens()];
		int i = 0;
		while(st.hasMoreElements())
		{
			array[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		return array;
	}
	
	private String getResultText(boolean isEementFound){
		String result = null;
		
		if(!isEementFound)
		{
			result = "Given number does not exist";
		}
		else 
		{
			result = "Given number found";
		}
		return result;
	}
		
	
}
