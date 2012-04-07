package com.example;

import android.os.Bundle;
import android.view.View;

public class LogicGatesActivity extends MenuActivity {
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gates);	
		
		View menuView = (View) findViewById(R.id.menus);
		(menuView.findViewById(R.id.home)).setOnClickListener(toHomeButtonListener);		
		(menuView.findViewById(R.id.converter)).setOnClickListener(toConverterButtonListener);
		(menuView.findViewById(R.id.sorter)).setOnClickListener(toSorterButtonListener);		
		(menuView.findViewById(R.id.searcher)).setOnClickListener(toSearcherButtonListener);
//		(menuView.findViewById(R.id.gates)).setOnClickListener(toGatesButtonListener);
		(menuView.findViewById(R.id.help)).setOnClickListener(helpButtonListener);			
		
	}
}
