package com.example;

import java.util.List;

import android.app.Activity;
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
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.common.customlayout.CustomWebView;

public class ConverterActivity extends Activity
{
    Spinner spinner;
    TextView binary;
    TextView quaternary;
    TextView octal;
    TextView decimal;
    TextView hexadecimal;
	EditText input;
	Button button1;
	
	WebView webview;		
    
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
		
		webview = (WebView) findViewById(R.id.webview);
		webview.setWebViewClient(new CustomWebView());
		webview.getSettings().setJavaScriptEnabled(true);
		webview.loadUrl("http://www.google.com");			
		
	    button1 = (Button)findViewById(R.id.ConverttoHome);
	    button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, MainActivity.class);
				context.startActivity(intent);
			}
		});			

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
				System.out.println(keyCode);
				if(keyCode == KeyEvent.FLAG_SOFT_KEYBOARD){
					System.out.println(event);
				}
				if (event.getAction() == KeyEvent.ACTION_DOWN) {
					System.out.println(event);
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



		spinner.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> parent,
					View view, int pos, long id) {
				String allowedRegex = "[a-f0-9]";
				setPositionSelected(pos);
				if(pos == 4){
					input.setInputType(1);
					allowedRegex = "[a-f0-9]";
				    InputFilter[] filters = new InputFilter[1];

				    filters[0] = new InputFilter() {

				        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
				        if (end > start) {
				            String destTxt = dest.toString();
				            String resultingTxt = destTxt.substring(0, dstart) + source.subSequence(start, end) + destTxt.substring(dend);

//				            if (!resultingTxt.matches("[0123456789]*[\\:]?[0123456789]*[,.]?[0123456789]*")) {
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
				}
				else{
					if(pos == 0){allowedRegex = "[0-1]";
					
				    InputFilter[] filters = new InputFilter[1];

				    filters[0] = new InputFilter() {

				        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
				        if (end > start) {
				            String destTxt = dest.toString();
				            String resultingTxt = destTxt.substring(0, dstart) + source.subSequence(start, end) + destTxt.substring(dend);

//				            if (!resultingTxt.matches("[0123456789]*[\\:]?[0123456789]*[,.]?[0123456789]*")) {
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
					
					}
					if(pos == 1){allowedRegex = "[0-3]";
					
				    InputFilter[] filters = new InputFilter[1];

				    filters[0] = new InputFilter() {

				        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
				        if (end > start) {
				            String destTxt = dest.toString();
				            String resultingTxt = destTxt.substring(0, dstart) + source.subSequence(start, end) + destTxt.substring(dend);

//				            if (!resultingTxt.matches("[0123456789]*[\\:]?[0123456789]*[,.]?[0123456789]*")) {
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
					
					}
					if(pos == 2){allowedRegex = "[0-7]";
					
				    InputFilter[] filters = new InputFilter[1];

				    filters[0] = new InputFilter() {

				        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
				        if (end > start) {
				            String destTxt = dest.toString();
				            String resultingTxt = destTxt.substring(0, dstart) + source.subSequence(start, end) + destTxt.substring(dend);

//				            if (!resultingTxt.matches("[0123456789]*[\\:]?[0123456789]*[,.]?[0123456789]*")) {
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
					
					}
					if(pos == 3){allowedRegex = "[0-9]";
					
				    InputFilter[] filters = new InputFilter[1];

				    filters[0] = new InputFilter() {

				        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
				        if (end > start) {
				            String destTxt = dest.toString();
				            String resultingTxt = destTxt.substring(0, dstart) + source.subSequence(start, end) + destTxt.substring(dend);

//				            if (!resultingTxt.matches("[0123456789]*[\\:]?[0123456789]*[,.]?[0123456789]*")) {
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
					
					}
					input.setInputType(2);
				}
				
					
				
				input.setText("");
				input.requestFocus();
			}

			public void onNothingSelected(@SuppressWarnings("rawtypes") AdapterView parent) {
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

	@SuppressWarnings("rawtypes")
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
