package com.example.prayas;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class searchengine extends Activity {
//WebView search;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.searchengine);
	
	
	//search=(WebView)findViewById(R.id.searchwebView1);
	
	
//	search.loadUrl("http://192.168.1.101:55818/searchwebsite.aspx/");
	
	WebView webView = (WebView)this.findViewById(R.id.searchwebView1);
	//webView = (WebView) findViewById(R.id.webView1);
	webView.getSettings().setJavaScriptEnabled(true);
	webView.loadUrl("https://cse.google.com/cse/publicurl?cx=013791278326577841667:qx63utjjrru");
	
		}
}
//https://www.google.co.in/