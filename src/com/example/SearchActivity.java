package com.example;

import java.util.StringTokenizer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.algorithms.search.ISearcher;
import com.algorithms.search.SearchFactory;

public class SearchActivity extends Activity {
	EditText input;
	TextView output;
	Button button1;
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
		input = (EditText) findViewById(R.id.searchInputValues);
		output = (TextView) findViewById(R.id.searchOutputValues);
		aboutComplexityBest = (TextView) findViewById(R.id.complexityLabelBestValue);
		aboutComplexityAvg = (TextView) findViewById(R.id.complexityLabelAverageValue);
		aboutComplexityWorst = (TextView) findViewById(R.id.complexityLabelWorstValue);		
		
		aboutSearchType.setText(searchType);
		aboutComplexityBest.setText(searcher.bestComplexity());
		aboutComplexityAvg.setText(searcher.averageComplexity());	
		aboutComplexityWorst.setText(searcher.worstComplexity());			
		
		input.setOnEditorActionListener(new OnEditorActionListener()
		{
			@Override
			public boolean onEditorAction(TextView textView, int arg1, KeyEvent keyEvent) {
				if(textView.getText().length() != 0){
                    // set comma separated
					input.setText(input.getText()+",");
				}
				return true;
			}    
		});
		
	    Button button = (Button)findViewById(R.id.searchButton);
	    button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int[] inputArray = getInputArray(input.getText().toString());
				int elementIndex = searcher.contains(inputArray, inputArray.length);
				output.setText(getResult(elementIndex));
				
			}
		});
	    
	    button1 = (Button)findViewById(R.id.SearchtoHome);
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
	
	private String getResult(int index){
		String result = null;
		
		if(index == 0)
		{
			result = "Given number does not exist";
		}
		else 
		{
			result = "Given number exists at "+index;
		}
		return result;
	}
	
}
