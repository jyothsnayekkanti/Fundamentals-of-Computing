package com.example;

import java.util.StringTokenizer;

import org.omg.CORBA.INV_IDENT;

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
	String sortType = null;
	TextView aboutSortType;
	TextView aboutComplexityBest;
	TextView aboutComplexityAvg;
	TextView aboutComplexityWorst;	
	ISorter sorter;
	Button sortButton;
	
	
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
//		input.setText(AlgorithmHelper.getInputString(inputArray));
		input.setText("");
		output.setText("");
//		int[] sortedArray = sorter.sort(inputArray, inputArray.length);
//		output.setText(getOutputText(sortedArray, sortedArray.length));		
		
	    Button generateButton = (Button)findViewById(R.id.generateSortButton);
	    generateButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int[] inputArray = AlgorithmHelper.getRandonNumberArray(10);
				input.setText(AlgorithmHelper.getInputString(inputArray));
				output.setText("");
			}
		});		
		
	    sortButton = (Button)findViewById(R.id.sortButton);
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
				intent.putExtra("componentType", "sort");
				intent.putExtra("type", sortType);	
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
	
	private String getOutputText(int[] sortedArray, int length){
		String outputText = "";
		if(length != 0){
		outputText = ""+sortedArray[0];
		for(int i=1; i<length; i++)
		{
			outputText = outputText + "," +sortedArray[i];
		}
		}
		return outputText;
	}
	
}