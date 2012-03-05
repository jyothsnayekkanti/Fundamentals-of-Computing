package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends Activity {
	
	WebView webview;	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webviewcomponent);
		
		webview = (WebView) findViewById(R.id.webview);
		webview.setWebViewClient(new CustomWebViewClient());
		webview.getSettings().setJavaScriptEnabled(true);
		webview.loadUrl("http://www.google.com");		

	}	

	private class CustomWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}	


}