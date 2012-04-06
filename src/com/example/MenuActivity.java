package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MenuActivity extends Activity {
	
	Context context;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		context = this;
		
	}

	OnClickListener toHomeButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(context, MainActivity.class);
			context.startActivity(intent);
		}
	};
	
	OnClickListener toConverterButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(context, ConverterActivity.class);
			context.startActivity(intent);
		}
	};

	OnClickListener toSorterButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(context, GalleryView.class);
			intent.putExtra("componentType", "sort");	
			context.startActivity(intent);				
		}
	};

	OnClickListener toSearcherButtonListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
//			Intent intent = new Intent(context, GalleryView.class);
//			intent.putExtra("componentType", "search");
			
//			Intent intent = new Intent(context, SearchActivity.class);
			
			Intent intent = new Intent(context, SearchTabWidget.class);
			
			context.startActivity(intent);			
		}
	};	
}
