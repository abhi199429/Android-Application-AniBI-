package com.example.prayas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class newsdivisionprayas extends Activity{

	Button nb1,nb2,nb3;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.newsdivisionprayas);
	
	nb1=(Button)findViewById(R.id.pollingbutton1);
	nb2=(Button)findViewById(R.id.newsbutton1);
	nb3=(Button)findViewById(R.id.statisticbutton1);
	
	
	nb1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			
			Intent ip1=new Intent(newsdivisionprayas.this,pollingprayas.class);
			startActivity(ip1);
			
		}
	});
	
   nb2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			
			Intent ip2=new Intent(newsdivisionprayas.this,news.class);
			startActivity(ip2);
			
		}
	});
	
	nb3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i1=new Intent(newsdivisionprayas.this,piechart.class);
			startActivity(i1);
		}
	});
	    
	}
}
