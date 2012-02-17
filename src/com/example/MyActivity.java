package com.example;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.*;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView.OnEditorActionListener;

public class MyActivity extends Activity
{
    Spinner spinner;
    TextView binary;
    TextView quaternary;
    TextView octal;
    TextView decimal;
    TextView hexadecimal;
	EditText input;
    
    final static String[] myArray = new String[]{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
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
		binary = (TextView) findViewById(R.id.base2value);
		quaternary = (TextView) findViewById(R.id.base4value);
		octal = (TextView) findViewById(R.id.base8value);
		decimal = (TextView) findViewById(R.id.base10value); 
        hexadecimal = (TextView) findViewById(R.id.base16value);
		input = (EditText) findViewById(R.id.converterInputValue);

		input.setOnEditorActionListener(new OnEditorActionListener()
		{
			@Override
			public boolean onEditorAction(TextView textView, int arg1, KeyEvent keyEvent) {
				if(textView.getText().length() != 0)
                    setValues(""+textView.getText(), getBaseSelected(getPositionSelected()));
				return true;
			}    
		});

		input.setOnKeyListener(new OnKeyListener()
		{
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					if(keyCode != KeyEvent.KEYCODE_ENTER){
						if(keyCode == KeyEvent.KEYCODE_DEL){
							return false; // allow input
						}
						if(isNumberAllowed(keyCode, getBaseSelected(getPositionSelected()))){
							return false; // allow input
						}
						else{
							return true; // doesn't allow input
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
				input.setText("");
				input.requestFocus();
			}

			public void onNothingSelected(AdapterView parent) {
				// Do nothing.
			}        	
		});

	}
	
	public int getBaseSelected(int pos) {
		int baseSelected = 2;// 2,4,8,10,16
		switch(pos)
		{
		case 0:
			baseSelected = 2;
			break;
		case 1:
			baseSelected = 4;
			break;			
		case 2:
			baseSelected = 8;
			break;
		case 3:
			baseSelected = 10;
			break;			
		case 4:
			baseSelected = 16;
			break;			
		}
		return baseSelected;
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

	public boolean isNumberAllowed(int keyCode, int base)
	{
		if((keyCode >=KeyEvent.KEYCODE_0 && keyCode <= KeyEvent.KEYCODE_9) || (keyCode >= KeyEvent.KEYCODE_A && keyCode <= KeyEvent.KEYCODE_F)){
			if(keyCode == KeyEvent.KEYCODE_0 || keyCode == KeyEvent.KEYCODE_1 || base == 16){
				return true;
			}
			else if(base != 16 && ((keyCode-7) < (base))){
				return true;
			}
		}
		else
		{
			return false;
		}
		return false;
	}


	public void setValues(String str, int baseSelected)
	{
		Long decimalValue = 0l;
		decimalValue = Long.parseLong(str, baseSelected);
		
        binary.setText(decimalToAnother(decimalValue, 2));
        quaternary.setText(decimalToAnother(decimalValue, 4));
        octal.setText(decimalToAnother(decimalValue, 8));
        this.decimal.setText(decimalToAnother(decimalValue, 10));
        hexadecimal.setText(decimalToAnother(decimalValue, 16));
	}


	// function decimalToAnother(decimalNumber, radix)
	// 
	// return representation of a number decimalNumber
	// in the system based on radix 
	//
	public String decimalToAnother(Long decimalNumber, int radix)
	{
		StringBuffer convertedNumber = new StringBuffer("");
		while (decimalNumber >= radix)
		{
			int reminder = (int) (decimalNumber % radix);
            decimalNumber =  Long.valueOf((int)Math.floor(decimalNumber/radix));
			convertedNumber.append(myArray[reminder]);
		}

		convertedNumber.append(myArray[Integer.valueOf(String.valueOf(decimalNumber))]);
        return convertedNumber.reverse().toString();
	}

}
