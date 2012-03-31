package com.example;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class SearchTabWidget extends TabActivity {
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    //Resources res = getResources(); // Resource object to get Drawables
	    TabHost tabHost = getTabHost();  // The activity TabHost
	    TabHost.TabSpec spec;  // Resusable TabSpec for each tab
	    Intent intent;  // Reusable Intent for each tab

	    // Create an Intent to launch an Activity for the tab (to be reused)
	    intent = new Intent().setClass(this, SearchActivity.class);

	    // Initialize a TabSpec for each tab and add it to the TabHost
	    spec = tabHost.newTabSpec("binarysearch").setIndicator("Binary Search", null
	                      //res.getDrawable(R.drawable.ictab)
	                      )
	                  .setContent(intent);
        intent.putExtra("searchType", "Binary Search");
	    tabHost.addTab(spec);

	    // Do the same for the other tabs
	    intent = new Intent().setClass(this, SearchActivity.class);
	    spec = tabHost.newTabSpec("sequentialsearch").setIndicator("Sequential Search", null
	                      //res.getDrawable(R.drawable.ictab)
	                      )
	                  .setContent(intent);
        intent.putExtra("searchType", "Sequential Search");
	    tabHost.addTab(spec);

	    tabHost.setCurrentTab(0);
	}	

}
