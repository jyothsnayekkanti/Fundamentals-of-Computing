package com.example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Gallery;

public class SortGalleryActivity extends GalleryView {
	Gallery gallery;
	private String sortTypeSelected;
	public String getSortTypeSelected() {
		return sortTypeSelected;
	}
	public void setSortTypeSelected(String sortTypeSelected) {
		this.sortTypeSelected = sortTypeSelected;
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Context context = this;		
		setContentView(R.layout.sortgallery);
		gallery=(Gallery)findViewById(R.id.gallery);
		//String array holding the values
		final String [] text=new String[]{"Bubble Sort","Heap Sort","Insertion Sort",
				"Merge Sort","Quick Sort","Selection Sort", "Bidirectional Bubble Sort"};
		
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
		
		//Array adapter to display our values in the gallery control		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.sort_array, android.R.layout.simple_gallery_item);
		gallery.setAdapter(adapter);
	}	

}
