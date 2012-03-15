package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LogicGatesActivity extends Activity {
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		final Context context = this;
		setContentView(R.layout.gates);	
		
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
}
