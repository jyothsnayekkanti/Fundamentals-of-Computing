package com.example;

import java.util.StringTokenizer;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.algorithms.AlgorithmHelper;
import com.algorithms.sort.ISorter;
import com.algorithms.sort.SortFactory;

public class SorterActivity extends MenuActivity {
	TextView input;
	TextView output;
	String sortType = null;
	String sortDescription = null;
	TextView aboutSortType;
	TextView describeSortType;
	TextView aboutComplexityBest;
	TextView aboutComplexityAvg;
	TextView aboutComplexityWorst;	
	ISorter sorter;
	Button sortButton;
	int[] inputArray;
	int[] sortedArray;
	
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
		sortType = getIntent().getStringExtra("sortType");
		sorter = SortFactory.createSorter(sortType);
		sortDescription = sorter.describe();
		setContentView(R.layout.sort);

		aboutSortType = (TextView) findViewById(R.id.aboutSortType);
		describeSortType = (TextView) findViewById(R.id.describeSortType);
		input = (TextView) findViewById(R.id.sortInputValues);
		output = (TextView) findViewById(R.id.sortOutputValues);
		aboutComplexityBest = (TextView) findViewById(R.id.complexityLabelBestValue);
		aboutComplexityAvg = (TextView) findViewById(R.id.complexityLabelAverageValue);
		aboutComplexityWorst = (TextView) findViewById(R.id.complexityLabelWorstValue);		
		
		aboutSortType.setText(sortType);
		describeSortType.setText(sortDescription);
		aboutComplexityBest.setText(sorter.bestComplexity());
		aboutComplexityAvg.setText(sorter.averageComplexity());	
		aboutComplexityWorst.setText(sorter.worstComplexity());	
		
		inputArray = AlgorithmHelper.getRandonNumberArray(10);
//		input.setText(AlgorithmHelper.getInputString(inputArray));
		input.setText("");
		output.setText("");
//		int[] sortedArray = sorter.sort(inputArray, inputArray.length);
//		output.setText(getOutputText(sortedArray, sortedArray.length));		
		
	    Button generateButton = (Button)findViewById(R.id.generateSortButton);
	    generateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				inputArray = AlgorithmHelper.getRandonNumberArray(10);
				input.setText(AlgorithmHelper.getInputString(inputArray," | "));
				output.setText("");
			}
		});		
		
	    sortButton = (Button)findViewById(R.id.sortButton);
	    sortButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int[] inputArray = AlgorithmHelper.getInputArray(input.getText().toString()," | ");
				sortedArray = sorter.sort(inputArray, inputArray.length);
				output.setText(getOutputText(sortedArray, sortedArray.length));
			}
		});
	    
	    Button animateButton = (Button)findViewById(R.id.animateButton);
	    animateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				setContentView(R.layout.sortanimate);
				Intent intent = new Intent(context, AnimateSortActivity.class);
                intent.putExtra("inputArray", inputArray);
                intent.putExtra("inputValue", input.getText().toString());
                intent.putExtra("outputArray", sortedArray);
                intent.putExtra("sortType", sortType);
                intent.putExtra("outputValue", output.getText().toString());				
				context.startActivity(intent);				
			}
		});
	    
	    Button explainButton = (Button)findViewById(R.id.explainButton);
	    explainButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, WebViewActivity.class);
				intent.putExtra("componentType", "sort");
				intent.putExtra("type", sortType);	
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
	}
	
	private String getOutputText(int[] sortedArray, int length){
		String outputText = "";
		if(length != 0){
		outputText = ""+sortedArray[0];
		for(int i=1; i<length; i++)
		{
			outputText = outputText + " | " +sortedArray[i];
		}
		}
		return outputText;
	}
	
}