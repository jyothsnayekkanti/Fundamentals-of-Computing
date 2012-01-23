package com.example;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class MyActivity extends Activity
{
	Spinner spinner;
	TextView textView1;
	TextView textView2;
	TextView textView3;
	TextView textView4;
	TextView textView5;
	TextView textView6;
	TextView textView7;
	TextView textView8;
	TextView textView9;
	TextView textView10;
	EditText input;

	private int positionSelected = 0;
	private String inputTextValue = null;


	public String getInputTextValue() {
		return inputTextValue;
	}

	public void setInputTextValue(String inputTextValue) {
		this.inputTextValue = inputTextValue;
	}

	public int getPositionSelected() {
		return positionSelected;
	}

	public void setPositionSelected(int positionSelected) {
		this.positionSelected = positionSelected;
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		spinner = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.numbersystem_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		textView1 = (TextView) findViewById(R.id.base1value);
		textView2 = (TextView) findViewById(R.id.base2value);
		textView3 = (TextView) findViewById(R.id.base3value);
		textView4 = (TextView) findViewById(R.id.base4value);
		textView5 = (TextView) findViewById(R.id.base5value);
		textView6 = (TextView) findViewById(R.id.base6value);
		textView7 = (TextView) findViewById(R.id.base7value);
		textView8 = (TextView) findViewById(R.id.base8value);
		textView9 = (TextView) findViewById(R.id.base9value);
		textView10 = (TextView) findViewById(R.id.base10value);       
		input = (EditText) findViewById(R.id.inputValue);

		// on drop down selected set focus to input text
		// on text input 

		//
		input.setOnEditorActionListener(new OnEditorActionListener()
		{
			@Override
			public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
				setValues(""+arg0.getText(), getPositionSelected());
				return true;
			}    
		});

		input.setOnKeyListener(new OnKeyListener()
		{
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if(keyCode != KeyEvent.KEYCODE_ENTER){
						if(keyCode == KeyEvent.KEYCODE_BACK){
							return false; 
						}
						if(isNumberAllowed(keyCode, getPositionSelected())){
							System.out.println("number allowed");
							return false;
						}
						else{
							System.out.println("number not allowed");
							return true;
						}
					}
				}
				return false;
			}
		});



		spinner.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parent,
					View view, int pos, long id) {
				setPositionSelected(pos);
			}

			public void onNothingSelected(AdapterView parent) {
				// Do nothing.
			}        	
		});

	}

	public List base10AllowedNumberList(){
		return null;
	}
	// 0 - 9 : 7 -16
	// binary pos 0 - <=1 : 8
	// 3 pos 1 - <= 2 : 9
	// 4 pos 2 - <= 3 : 10
	// 5 pos 3 - <= 4 : 11
	// 6 pos 4 - <= 5 : 12
	// 9 pos 7 - <= 8 : 15
	// decimal pos 8 - <=9 : 16
	// Hexadecimal pos 9 : 7 - 16, 29 - 34 

	public boolean isNumberAllowed(int keyCode, int pos)
	{
		if((keyCode >=KeyEvent.KEYCODE_0 && keyCode <= KeyEvent.KEYCODE_9) || (keyCode >= KeyEvent.KEYCODE_A && keyCode <= KeyEvent.KEYCODE_F)){
			if(keyCode == KeyEvent.KEYCODE_0 || keyCode == KeyEvent.KEYCODE_1 || pos == 9){
				return true;
			}
			else if(pos != 9 && ((keyCode-7) < (pos+2))){
				return true;
			}
		}
		else
		{
			return false;
		}
		return false;
	}


	public void setValues(String str, int pos)
	{
		//str = "10";
		int dec = 0;
		switch(pos)
		{
		case 0:
			dec = Integer.parseInt(str, 2);         		
			break;
		case 1:
			dec = Integer.parseInt(str, 3);
			break;
		case 2:
			dec = Integer.parseInt(str, 4);
			break;
		case 3:
			dec = Integer.parseInt(str, 5);
			break;
		case 4:
			dec = Integer.parseInt(str, 6);            		
			break;
		case 5:
			dec = Integer.parseInt(str, 7);            		
			break;
		case 6:
			dec = Integer.parseInt(str, 8);            		
			break;
		case 7:
			dec = Integer.parseInt(str, 9);            		
			break;
		case 8:
			dec = Integer.parseInt(str, 10);
			break;
		case 9:
			dec = Integer.parseInt(str, 16);            		
			break;     		
		}
		textView1.setText(DecimaltoAnother(dec, 2)); 
		textView2.setText(DecimaltoAnother(dec, 3)); 
		textView3.setText(DecimaltoAnother(dec, 4));  
		textView4.setText(DecimaltoAnother(dec, 5)); 
		textView5.setText(DecimaltoAnother(dec, 6));  
		textView6.setText(DecimaltoAnother(dec, 7));  
		textView7.setText(DecimaltoAnother(dec, 8));  
		textView8.setText(DecimaltoAnother(dec, 9)); 
		textView9.setText(""+dec);            		
		textView10.setText(DecimaltoAnother(dec, 16));     	
	}

	final static String[] myArray = new String[]{"0","1","2","3","4","5","6","7","8","9",
		"A","B","C","D","E",
		"F","G","H","I","J",
		"K","L","M","N","O",
		"P","Q","R","S","T",
		"U","V","W","X","Y","Z"};	


	// function DecimaltoAnother(N, radix)
	// 
	// return representation of a number N
	// in the system based on radix 
	//
	public String DecimaltoAnother(int N, int radix)
	{


		String s = "";

		int A = N;
		while (A >= radix)
		{
			int B = A % radix;
			A = (int) Math.floor(A/radix);
			s += myArray[(int) (B)];
		}

		s += myArray[(int) (A)];
		return Transpose(s);
	}

	// function Transpose(s)
	//
	// return a string written from right to left
	//
	public String Transpose( String s)
	{
		int N = s.length();

		String  t = "";

		for (int i = 0; i < N; i++)
			t = t + s.substring(N-i-1, N-i);

		s = t;
		return s;
	}    


}
