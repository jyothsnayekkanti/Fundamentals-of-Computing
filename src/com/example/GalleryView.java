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
	
	private String searchTypeSelected;
	public String getSearchTypeSelected() {
		return searchTypeSelected;
	}
	public void setSearchTypeSelected(String searchTypeSelected) {
		this.searchTypeSelected = searchTypeSelected;
	}	
	
	private String algorithmTypeSelected = "sort";	
	
	public String getAlgorithmTypeSelected() {
		return algorithmTypeSelected;
	}

	public void setAlgorithmTypeSelected(String algorithmTypeSelected) {
		this.algorithmTypeSelected = algorithmTypeSelected;
	}	
	
	Button button1;
	Integer[] sortPics = {
			R.drawable.bubblesort,
			R.drawable.insertionsort,
			R.drawable.heapsort,
			R.drawable.mergesort,
			R.drawable.selectionsort,
			R.drawable.quicksort,
			R.drawable.bbsort
	};
	
	Integer[] searchPics = {
			R.drawable.bubblesort,
			R.drawable.insertionsort
	};	
	
	//String array holding the values
	final String [] sortText=new String[]{"Bubble Sort","Insertion Sort","Heap Sort",
			"Merge Sort","Selection Sort","Quick Sort", "Bidirectional Bubble Sort"};
	final String [] searchText=new String[]{"Binary Search","Sequential Search"};	
	
	ImageView imageView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Context context = this;
		algorithmTypeSelected = getIntent().getStringExtra("algorithmType");		
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
				if(algorithmTypeSelected.equalsIgnoreCase("sort")){
				setSortTypeSelected(sortText[pos].toString());
				Intent intent = new Intent(context, SorterActivity.class);
				intent.putExtra("sortType", getSortTypeSelected());
				context.startActivity(intent);	
				}
				if(algorithmTypeSelected.equalsIgnoreCase("search")){
				setSortTypeSelected(searchText[pos].toString());
				Intent intent = new Intent(context, SearchActivity.class);
				intent.putExtra("searchType", getSortTypeSelected());
				context.startActivity(intent);	
				}
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
			if(algorithmTypeSelected.equalsIgnoreCase("sort"))
			return sortPics.length;
			if(algorithmTypeSelected.equalsIgnoreCase("search"))
				return searchPics.length;
			return 0;
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
			if(algorithmTypeSelected.equalsIgnoreCase("sort"))
			iv.setImageResource(sortPics[arg0]);
			if(algorithmTypeSelected.equalsIgnoreCase("search"))
			iv.setImageResource(searchPics[arg0]);			
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setLayoutParams(new Gallery.LayoutParams(150,120));
			iv.setBackgroundResource(imageBackground);
			if(algorithmTypeSelected.equalsIgnoreCase("sort"))
			tv.setText(sortText[arg0]);
			if(algorithmTypeSelected.equalsIgnoreCase("search"))
			tv.setText(searchText[arg0]);
			layout.addView(iv);
	        layout.addView(tv);
	        return layout;			
		}

	}
}