package com.example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class ConverterActivity extends MenuActivity
{
	Spinner spinner;
	Button binary;
	Button quaternary;
	Button octal;
	Button decimal;
	Button hexadecimal;
	
	Button binaryLabel;
	Button quaternaryLabel;
	Button octalLabel;
	Button decimalLabel;
	Button hexadecimalLabel;	
	
	EditText input;

    public int getInputBase() {
        return inputBase;
    }

    public void setInputBase(int inputBase) {
        this.inputBase = inputBase;
    }

    int inputBase = 2;
	TextView explain;
	
	
	String explainBinary = "The Binary Number System is the most basic number system that most machines (and electrical devices) use to communicate. The binary number system is also known as the base-2 number system, because each position in the number represents an incremental number with a base of 2. \n \n Since the number system is represented in “twos”, there are only 2 numbers that can be a value in each position of the base-2 number. Each position can only contain a 0 or a 1";
	String explainQuaternary = "Quaternary is the base-4 numeral system. It uses the digits 0, 1, 2 and 3 to represent any real number. Quaternary numbers are used in the representation of 2D Hilbert curves. \n Here a real number between 0 and 1 is converted into the quaternary system. Every single digit now indicates in which of the respective 4 sub-quadrants the number will be projected. \n \n Quaternary line codes have been used for transmission, from the invention of the telegraph to the 2B1Q code used in modern ISDN circuits.";
	String explainOctal = "The Octal Numeral System, or oct for short, is the base-8 number system, and uses the digits 0 to 7. \n \n Octal is sometimes used in computing instead of hexadecimal, most often in modern times in conjunction with file permissions under Unix systems. It has the advantage of not requiring any extra symbols as digits. The way we count in the hexadecimal number system is 0,1,2,3,4,5,6,7 and then 10. It is also used for digital displays.";
	String explainDecimal = "From the very beginning, people have used their fingures to count. \n \n It's no coincidence that the word digit can refer to fingures or toes as well as numbers or that the words five and fist have similar roots. So in that sense, using a base-ten, or decimal (from the Latin for ten), number system is completely arbitrary. \n \n There is no special symbol for ten. The way we count in the decimal number system is 0,1,2,3,4,5,6,7,8,9 and then 10.";	
	String explainHexadecimal = "The Hexadecimal Number System is used as an intermediary system in computers, such as a representation of memory addresses or a representation of colors. The hexadecimal number system is also known as the base-16 number system, because each position in the number represents an incremental number with a base of 16. \n \n Since the number system is represented in “sixteens”, there are only 10 numbers and 5 letters that can be a value in each position of the base-16 number. The way we count in the hexadecimal number system is 0,1,2,3,4,5,6,7,8,9,10,A,B,C,D,E,F and then 10,11..18,19,1A so on.";
	
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
		final Context context = this;		
		setContentView(R.layout.convert);	
		
		View menuView = (View) findViewById(R.id.menus);
		(menuView.findViewById(R.id.home)).setOnClickListener(toHomeButtonListener);		
		(menuView.findViewById(R.id.converter)).setOnClickListener(toConverterButtonListener);
		(menuView.findViewById(R.id.sorter)).setOnClickListener(toSorterButtonListener);		
		(menuView.findViewById(R.id.searcher)).setOnClickListener(toSearcherButtonListener);
		
		
		spinner = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbersystem_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		binary = (Button) findViewById(R.id.base2value);
		quaternary = (Button) findViewById(R.id.base4value);
		octal = (Button) findViewById(R.id.base8value);
		decimal = (Button) findViewById(R.id.base10value); 
		hexadecimal = (Button) findViewById(R.id.base16value);
		input = (EditText) findViewById(R.id.converterInputValue);
		
		binaryLabel = (Button) findViewById(R.id.base2);
		quaternaryLabel = (Button) findViewById(R.id.base4);
		octalLabel = (Button) findViewById(R.id.base8);
		decimalLabel = (Button) findViewById(R.id.base10); 
		hexadecimalLabel = (Button) findViewById(R.id.base16);
		
		explain = (TextView) findViewById(R.id.explainNumberSystem);
		
		explain.setText(explainBinary);
		binary.setEnabled(false);
		quaternary.setEnabled(true);
		octal.setEnabled(true);
		decimal.setEnabled(true);
		hexadecimal.setEnabled(true);
		
		binary.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, AnimateConverterActivity.class);


                intent.putExtra("inputType", getInputBase());
                intent.putExtra("inputValue", input.getText().toString());
                intent.putExtra("outputType", 2);
                intent.putExtra("decimalValue", Integer.parseInt(decimal.getText().toString()));
                intent.putExtra("outputValue", binary.getText().toString());
				context.startActivity(intent);			
				
			}
		});
		
		quaternary.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, AnimateConverterActivity.class);
                intent.putExtra("inputType", getInputBase());
                intent.putExtra("inputValue", input.getText().toString());
                intent.putExtra("outputType", 4);
                intent.putExtra("decimalValue", Integer.parseInt(decimal.getText().toString()));
                intent.putExtra("outputValue", quaternary.getText().toString());
				context.startActivity(intent);			
				
			}
		});
		
		octal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, AnimateConverterActivity.class);
                intent.putExtra("inputType", getInputBase());
                intent.putExtra("inputValue", input.getText().toString());
                intent.putExtra("outputType", 8);
                intent.putExtra("decimalValue", Integer.parseInt(decimal.getText().toString()));
                intent.putExtra("outputValue", octal.getText().toString());
				context.startActivity(intent);			
				
			}
		});
		
		decimal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, AnimateConverterActivity.class);
                intent.putExtra("inputType", getInputBase());
                intent.putExtra("inputValue", input.getText().toString());
                intent.putExtra("outputType", 10);
                intent.putExtra("decimalValue", Integer.parseInt(decimal.getText().toString()));
                intent.putExtra("outputValue", decimal.getText().toString());
				context.startActivity(intent);			
				
			}
		});
		
		hexadecimal.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, AnimateConverterActivity.class);
                intent.putExtra("inputType", getInputBase());
                intent.putExtra("inputValue", input.getText().toString());
                intent.putExtra("outputType", 16);
                intent.putExtra("decimalValue", Integer.parseInt(decimal.getText().toString()));
                intent.putExtra("outputValue", hexadecimal.getText().toString());
				context.startActivity(intent);			
				
			}
		});
		
		
		binaryLabel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, WebViewActivity.class);
				intent.putExtra("componentType", "convert");
				intent.putExtra("type", "Binary");					
				context.startActivity(intent);		
			}
		});
		
		quaternaryLabel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, WebViewActivity.class);
				intent.putExtra("componentType", "convert");
				intent.putExtra("type", "Quaternary");					
				context.startActivity(intent);		
			}
		});
		
		octalLabel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, WebViewActivity.class);
				intent.putExtra("componentType", "convert");
				intent.putExtra("type", "Octal");					
				context.startActivity(intent);		
			}
		});
		
		decimalLabel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, WebViewActivity.class);
				intent.putExtra("componentType", "convert");
				intent.putExtra("type", "Decimal");					
				context.startActivity(intent);		
			}
		});
		
		hexadecimalLabel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, WebViewActivity.class);
				intent.putExtra("componentType", "convert");
				intent.putExtra("type", "Hexadecimal");					
				context.startActivity(intent);		
			}
		});			

		spinner.setOnItemSelectedListener(new OnItemSelectedListener()
		{
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) 
			{
				setPositionSelected(pos);
                setInputBase(getBaseSelected(getPositionSelected()));
				if(pos == 4)
				{
					input.setInputType(1);
					InputFilter[] filters = new InputFilter[1];
					filters[0] = new InputFilter() {
						public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
							if (end > start) {
								String destTxt = dest.toString();
								String resultingTxt = destTxt.substring(0, dstart) + source.subSequence(start, end) + destTxt.substring(dend);
								if (!resultingTxt.matches("[a-f0-9]*")) {
									if (source instanceof Spanned) {
										SpannableString sp = new SpannableString("");
										return sp;
									} else {
										return "";
									}
								}
							}
							return null;
						}
					};
					input.setFilters(filters);	
					
					explain.setText(explainHexadecimal);
					binary.setEnabled(true);
					quaternary.setEnabled(true);
					octal.setEnabled(true);
					decimal.setEnabled(true);
					hexadecimal.setEnabled(false);
				}
				else
				{
					if(pos == 0)
					{
						InputFilter[] filters = new InputFilter[1];
						filters[0] = new InputFilter() {
							public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
								if (end > start) {
									String destTxt = dest.toString();
									String resultingTxt = destTxt.substring(0, dstart) + source.subSequence(start, end) + destTxt.substring(dend);
									if (!resultingTxt.matches("[0-1]*")) {
										if (source instanceof Spanned) {
											SpannableString sp = new SpannableString("");
											return sp;
										} else {
											return "";
										}
									}
								}
								return null;
							}
						};
						input.setFilters(filters);
						
						explain.setText(explainBinary);
						binary.setEnabled(false);
						quaternary.setEnabled(true);
						octal.setEnabled(true);
						decimal.setEnabled(true);
						hexadecimal.setEnabled(true);						
					}
					if(pos == 1)
					{
						InputFilter[] filters = new InputFilter[1];
						filters[0] = new InputFilter() {
							public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
								if (end > start) {
									String destTxt = dest.toString();
									String resultingTxt = destTxt.substring(0, dstart) + source.subSequence(start, end) + destTxt.substring(dend);
									//if (!resultingTxt.matches("[0123456789]*[\\:]?[0123456789]*[,.]?[0123456789]*")) {
									if (!resultingTxt.matches("[0-3]*")) {
										if (source instanceof Spanned) {
											SpannableString sp = new SpannableString("");
											return sp;
										} else {
											return "";
										}
									}
								}
								return null;
							}
						};
						input.setFilters(filters);	
					
						explain.setText(explainQuaternary);
						binary.setEnabled(true);
						quaternary.setEnabled(false);
						octal.setEnabled(true);
						decimal.setEnabled(true);
						hexadecimal.setEnabled(true);						
					}
					if(pos == 2)
					{
						InputFilter[] filters = new InputFilter[1];
						filters[0] = new InputFilter() {
							public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
								if (end > start) {
									String destTxt = dest.toString();
									String resultingTxt = destTxt.substring(0, dstart) + source.subSequence(start, end) + destTxt.substring(dend);
									if (!resultingTxt.matches("[0-7]*")) {
										if (source instanceof Spanned) {
											SpannableString sp = new SpannableString("");
											return sp;
										} else {
											return "";
										}
									}
								}
								return null;
							}
						};
						input.setFilters(filters);
						
						explain.setText(explainOctal);
						binary.setEnabled(true);
						quaternary.setEnabled(true);
						octal.setEnabled(false);
						decimal.setEnabled(true);
						hexadecimal.setEnabled(true);
					}
					if(pos == 3)
					{
						InputFilter[] filters = new InputFilter[1];
						filters[0] = new InputFilter() {
							public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
								if (end > start) {
									String destTxt = dest.toString();
									String resultingTxt = destTxt.substring(0, dstart) + source.subSequence(start, end) + destTxt.substring(dend);

									if (!resultingTxt.matches("[0-9]*")) {
										if (source instanceof Spanned) {
											SpannableString sp = new SpannableString("");
											return sp;
										} else {
											return "";
										}
									}
								}
								return null;
							}
						};
						input.setFilters(filters);

						explain.setText(explainDecimal);
						binary.setEnabled(true);
						quaternary.setEnabled(true);
						octal.setEnabled(true);
						decimal.setEnabled(false);
						hexadecimal.setEnabled(true);
					}
					input.setInputType(2);
				}
				input.setText("");
				
				binary.setText("");
				quaternary.setText("");
				octal.setText("");
				decimal.setText("");
				hexadecimal.setText("");
				
				input.requestFocus();
			}

			public void onNothingSelected(@SuppressWarnings("rawtypes") AdapterView parent) {
				// Do nothing.
			}        	
		});

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
						if(keyCode == KeyEvent.KEYCODE_BACK){
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
        setInputBase(baseSelected);
		return baseSelected;
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
		int decimalValue = 0;
		try {
			decimalValue = Integer.parseInt(str, baseSelected);
		} catch (NumberFormatException e) {
			// Create a piece of toast.
			Toast pieceToast = Toast.makeText(getApplicationContext(), "Enter a valid integer value. Input value is out if range.", Toast.LENGTH_SHORT);

			// Show the toast.
			pieceToast.show();	    						
		}

		String binaryValue = decimalToAnother(decimalValue, 2);
		if(binaryValue.length() > 25)
		{
			binary.setTextSize(12);
		}
		else
		{
			binary.setTextSize(15);
		}
		binary.setText(binaryValue);
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
	public String decimalToAnother(int decimalNumber, int radix)
	{
		StringBuffer convertedNumber = new StringBuffer("");
		while (decimalNumber >= radix)
		{
			int reminder = (int) (decimalNumber % radix);
			decimalNumber =  (int)Math.floor(decimalNumber/radix);
			convertedNumber.append(myArray[reminder]);
		}

		convertedNumber.append(myArray[Integer.valueOf(String.valueOf(decimalNumber))]);
		return convertedNumber.reverse().toString();
	}

}