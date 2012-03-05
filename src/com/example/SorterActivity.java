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

public class SorterActivity extends Activity {
	TextView input;
	TextView output;
	Button button1;
	Button button2;
	String sortType = null;
	TextView aboutSortType;
	TextView aboutComplexityBest;
	TextView aboutComplexityAvg;
	TextView aboutComplexityWorst;	
	ISorter sorter;
	
	
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
		setContentView(R.layout.sort);

		aboutSortType = (TextView) findViewById(R.id.aboutSortType);
		input = (TextView) findViewById(R.id.sortInputValues);
		output = (TextView) findViewById(R.id.sortOutputValues);
		aboutComplexityBest = (TextView) findViewById(R.id.complexityLabelBestValue);
		aboutComplexityAvg = (TextView) findViewById(R.id.complexityLabelAverageValue);
		aboutComplexityWorst = (TextView) findViewById(R.id.complexityLabelWorstValue);		
		
		aboutSortType.setText(sortType);
		aboutComplexityBest.setText(sorter.bestComplexity());
		aboutComplexityAvg.setText(sorter.averageComplexity());	
		aboutComplexityWorst.setText(sorter.worstComplexity());	
		
		int[] inputArray = AlgorithmHelper.getRandonNumberArray(10);
		input.setText(AlgorithmHelper.getInputString(inputArray));		
		
//		input.setOnEditorActionListener(new OnEditorActionListener()
//		{
//			@Override
//			public boolean onEditorAction(TextView textView, int arg1, KeyEvent keyEvent) {
//				if(textView.getText().length() != 0){
//                    // set comma separated
//					input.setText(input.getText()+",");
//				}
//				return true;
//			}    
//		});
		
	    Button generateButton = (Button)findViewById(R.id.generateSortButton);
	    generateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int[] inputArray = AlgorithmHelper.getRandonNumberArray(10);
				input.setText(AlgorithmHelper.getInputString(inputArray));
				
			}
		});		
		
	    Button sortButton = (Button)findViewById(R.id.sortButton);
	    sortButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int[] inputArray = getInputArray(input.getText().toString());
				int[] sortedArray = sorter.sort(inputArray, inputArray.length);
				output.setText(getOutputText(sortedArray, sortedArray.length));
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
	    
	    button1 = (Button)findViewById(R.id.SorttoHome);
	    button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, MainActivity.class);
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
	
	private String getOutputText(int[] sortedArray, int length){
		String outputText = ""+sortedArray[0];
		for(int i=1; i<length; i++)
		{
			outputText = outputText + "," +sortedArray[i];
		}
		return outputText;
	}
	
}
