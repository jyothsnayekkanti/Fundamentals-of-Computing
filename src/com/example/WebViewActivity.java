package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import com.common.customlayout.CustomWebView;

public class WebViewActivity extends Activity {
	
	WebView webview;	
	String componentType;
	String type;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webviewcomponent);
		componentType = getIntent().getStringExtra("componentType");
		type = getIntent().getStringExtra("type");
		
		webview = (WebView) findViewById(R.id.webview);
		webview.setWebViewClient(new CustomWebView());
		webview.getSettings().setJavaScriptEnabled(true);
		webview.loadUrl(getUrl(componentType, type));

	}	
	
	private String getUrl(String componentType, String type){
		StringBuffer url = new StringBuffer("http://fundamentalsofcomputing.herokuapp.com");
		
		
		if(componentType.equalsIgnoreCase("sort")){
			if(type.equalsIgnoreCase("Bubble Sort"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}
			else if(type.equalsIgnoreCase("Insertion Sort"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}
			else if(type.equalsIgnoreCase("Heap Sort"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}
			else if(type.equalsIgnoreCase("Merge Sort"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}
			else if(type.equalsIgnoreCase("Selection Sort"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}
			else if(type.equalsIgnoreCase("Quick Sort"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}
			else if(type.equalsIgnoreCase("Bidirectional Bubble Sort"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}
			
		}
		else if(componentType.equalsIgnoreCase("search")){
			if(type.equalsIgnoreCase("Binary Search"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}
			else if(type.equalsIgnoreCase("Sequential Search"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}			
		}
		else if(componentType.equalsIgnoreCase("gates")){
			if(type.equalsIgnoreCase("OR"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}
			else if(type.equalsIgnoreCase("AND"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}
			else if(type.equalsIgnoreCase("NOR"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}
			else if(type.equalsIgnoreCase("NAND"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}
			else if(type.equalsIgnoreCase("XOR"))
			{
				url.append("/");
				url.append("insertion_sort");
				url.append(".html");
			}			
		}
		
		return url.toString();
		
	}


}