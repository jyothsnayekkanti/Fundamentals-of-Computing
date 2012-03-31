package com.example;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GalleryView extends MenuActivity {
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
	
	private String gateTypeSelected;
	
	public String getGateTypeSelected() {
		return gateTypeSelected;
	}
	public void setGateTypeSelected(String gateTypeSelected) {
		this.gateTypeSelected = gateTypeSelected;
	}

	private String componentTypeSelected = "sort";
	
	public String getAlgorithmTypeSelected() {
		return componentTypeSelected;
	}
	public void setAlgorithmTypeSelected(String componentTypeSelected) {
		this.componentTypeSelected = componentTypeSelected;
	}	
	
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
	
	Integer[] gatesPics = {
			R.drawable.bubblesort,
			R.drawable.insertionsort
	};		
	
	//String array holding the values
	final String [] sortText=new String[]{"Bubble Sort","Insertion Sort","Heap Sort",
			"Merge Sort","Selection Sort","Quick Sort", "Bidirectional Bubble Sort"};
	final String [] searchText=new String[]{"Binary Search","Sequential Search"};
	final String [] gatesText=new String[]{"OR","AND","NOR","NAND","XOR"};	
	
	ImageView imageView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Context context = this;
		
		componentTypeSelected = getIntent().getStringExtra("componentType");		
		setContentView(R.layout.sortgallery);

		View menuView = (View) findViewById(R.id.menus);
		(menuView.findViewById(R.id.home)).setOnClickListener(toHomeButtonListener);		
		(menuView.findViewById(R.id.converter)).setOnClickListener(toConverterButtonListener);
		(menuView.findViewById(R.id.sorter)).setOnClickListener(toSorterButtonListener);		
		(menuView.findViewById(R.id.searcher)).setOnClickListener(toSearcherButtonListener);
		(menuView.findViewById(R.id.gates)).setOnClickListener(toGatesButtonListener);	       

		gallery = (Gallery)findViewById(R.id.gallery);
		gallery.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent,
					View view, int pos, long id) {
				if(componentTypeSelected.equalsIgnoreCase("sort")){
				setSortTypeSelected(sortText[pos].toString());
				Intent intent = new Intent(context, SorterActivity.class);
				intent.putExtra("sortType", getSortTypeSelected());
				context.startActivity(intent);	
				}
				if(componentTypeSelected.equalsIgnoreCase("search")){
				setSearchTypeSelected(searchText[pos].toString());
				Intent intent = new Intent(context, SearchActivity.class);
				intent.putExtra("searchType", getSearchTypeSelected());
				context.startActivity(intent);	
				}
				if(componentTypeSelected.equalsIgnoreCase("gates")){
				setGateTypeSelected(gatesText[pos].toString());
				Intent intent = new Intent(context, LogicGatesActivity.class);
				intent.putExtra("gateType", getGateTypeSelected());
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
			if(componentTypeSelected.equalsIgnoreCase("sort"))
			return sortPics.length;
			if(componentTypeSelected.equalsIgnoreCase("search"))
				return searchPics.length;
			if(componentTypeSelected.equalsIgnoreCase("gates"))
				return gatesPics.length;			
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
			
			if(componentTypeSelected.equalsIgnoreCase("sort"))
			iv.setImageResource(sortPics[arg0]);
			if(componentTypeSelected.equalsIgnoreCase("search"))
			iv.setImageResource(searchPics[arg0]);
			if(componentTypeSelected.equalsIgnoreCase("gates"))
			iv.setImageResource(gatesPics[arg0]);
			
			iv.setScaleType(ImageView.ScaleType.FIT_XY);
			iv.setLayoutParams(new Gallery.LayoutParams(150,120));
			iv.setBackgroundResource(imageBackground);
			
			if(componentTypeSelected.equalsIgnoreCase("sort"))
			tv.setText(sortText[arg0]);
			if(componentTypeSelected.equalsIgnoreCase("search"))
			tv.setText(searchText[arg0]);
			if(componentTypeSelected.equalsIgnoreCase("gates"))
			tv.setText(gatesText[arg0]);
			
			layout.addView(iv);
	        layout.addView(tv);
	        return layout;			
		}

	}
}