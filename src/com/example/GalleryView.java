package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GalleryView extends Activity {
	Gallery gallery;
	private String sortTypeSelected;
	public String getSortTypeSelected() {
		return sortTypeSelected;
	}
	public void setSortTypeSelected(String sortTypeSelected) {
		this.sortTypeSelected = sortTypeSelected;
	}	
	Button button1;
	Integer[] pics = {
			R.drawable.bubblesort,
			R.drawable.insertionsort,
			R.drawable.heapsort,
			R.drawable.mergesort,
			R.drawable.selectionsort,
			R.drawable.quicksort,
			R.drawable.bbsort
	};
	
	//String array holding the values
	final String [] text=new String[]{"Bubble Sort","Insertion Sort","Heap Sort",
			"Merge Sort","Selection Sort","Quick Sort", "Bidirectional Bubble Sort"};
	
	ImageView imageView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Context context = this;
		setContentView(R.layout.sortgallery);

		button1 = (Button)findViewById(R.id.gallerytoHome);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context, MainActivity.class);
				context.startActivity(intent);
			}
		});	        

		gallery = (Gallery)findViewById(R.id.gallery);



		gallery.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent,
					View view, int pos, long id) {	
				setSortTypeSelected(text[pos].toString());
				Intent intent = new Intent(context, SorterActivity.class);
				intent.putExtra("sortType", getSortTypeSelected());
				context.startActivity(intent);	
			}			
		}); 
		gallery.setAdapter(new ImageAdapter(this));
	}


	public class ImageAdapter extends BaseAdapter {

		private Context ctx;
		int imageBackground;

		public ImageAdapter(Context c) {
			ctx = c;
			TypedArray ta = obtainStyledAttributes(R.styleable.Gallery1);
			imageBackground = ta.getResourceId(R.styleable.Gallery1_android_galleryItemBackground, 1);
			ta.recycle();
		}

		@Override
		public int getCount() {

			return pics.length;
		}

		@Override
		public Object getItem(int arg0) {

			return arg0;
		}

		@Override
		public long getItemId(int arg0) {

			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
	        LinearLayout layout = new LinearLayout(getApplicationContext());
	        layout.setOrientation(LinearLayout.VERTICAL);			
			ImageView iv = new ImageView(ctx);
			TextView tv = new TextView(ctx);
			iv.setImageResource(pics[arg0]);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setLayoutParams(new Gallery.LayoutParams(150,120));
			iv.setBackgroundResource(imageBackground);
			tv.setText(text[arg0]);
	        layout.addView(iv);
	        layout.addView(tv);
	        return layout;			
		}

	}
}