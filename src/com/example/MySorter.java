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

import com.algorithms.sort.BubbleSort;

public class MySorter extends Activity {
	EditText input;
	TextView output;
	Button button1;
	
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
		setContentView(R.layout.sort);

		input = (EditText) findViewById(R.id.sortInputValues);
		output = (TextView) findViewById(R.id.sortOutputValues);
		
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
		
	    Button button = (Button)findViewById(R.id.sortButton);
	    button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int[] inputArray = getInputArray(input.getText().toString());
				int[] sortedArray = new BubbleSort().sort(inputArray, inputArray.length);
				output.setText(getOutputText(sortedArray, sortedArray.length));
			}
		});
	    
	    button1 = (Button)findViewById(R.id.SorttoHome);
	    button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, MyHome.class);
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
