package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		final Context context = this;
		setContentView(R.layout.main);
		
	    Button button1 = (Button)findViewById(R.id.converter);
	    button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, ConverterActivity.class);
				context.startActivity(intent);
			}
		});

	    Button button2 = (Button)findViewById(R.id.sorter);
	    button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Intent intent = new Intent(context, MySorter.class);
//				context.startActivity(intent);
				Intent intent = new Intent(context, SortGalleryActivity.class);
				context.startActivity(intent);				
			}
		});
	
	}

}
