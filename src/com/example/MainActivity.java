package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{
	
	private String algorithmTypeSelected;	
	
	public String getAlgorithmTypeSelected() {
		return algorithmTypeSelected;
	}

	public void setAlgorithmTypeSelected(String algorithmTypeSelected) {
		this.algorithmTypeSelected = algorithmTypeSelected;
	}

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
				Intent intent = new Intent(context, GalleryView.class);
				setAlgorithmTypeSelected("sort");
				intent.putExtra("algorithmType", getAlgorithmTypeSelected());	
				context.startActivity(intent);				
			}
		});
	    
	    Button button3 = (Button)findViewById(R.id.searcher);
	    button3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, GalleryView.class);
				setAlgorithmTypeSelected("search");
				intent.putExtra("algorithmType", getAlgorithmTypeSelected());				
				context.startActivity(intent);				
			}
		});	    
	
	}
	
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        //Handle the back button
//        if(keyCode == KeyEvent.KEYCODE_BACK) {
//            //Ask the user if they want to quit
//            new AlertDialog.Builder(this)
//            .setIcon(android.R.drawable.ic_dialog_alert)
//            .setTitle(R.string.quit)
//            .setMessage(R.string.really_quit)
//            .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
//
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//
//                    //Stop the activity
//                    MainActivity.this.finish(); 
//                }
//
//            })
//            .setNegativeButton(R.string.no, null)
//            .show();
//
//            return true;
//        }
//        else {
//            return super.onKeyDown(keyCode, event);
//        }
//
//    }	

}
