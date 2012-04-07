package com.example;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends MenuActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		final Context context = this;
		setContentView(R.layout.main);
		
//		Button egButton = (Button) findViewById(R.id.eg);
//		egButton.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				setContentView(R.layout.eg);
//			}
//		});
		
		
		((Button)findViewById(R.id.converter)).setOnClickListener(toConverterButtonListener);
		((Button)findViewById(R.id.sorter)).setOnClickListener(toSorterButtonListener);		
		((Button)findViewById(R.id.searcher)).setOnClickListener(toSearcherButtonListener);
//		((Button)findViewById(R.id.gates)).setOnClickListener(toGatesButtonListener);		
	}

}