package com.example.prayas;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class medical extends Activity {

	ImageButton mb1,mb2,mb3,mb4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		 setContentView(R.layout.medical);
		
		 mb1=(ImageButton)findViewById(R.id.imgmedicalbutton1);
		 mb2=(ImageButton)findViewById(R.id.imgmedicalbutton2);
		 mb3=(ImageButton)findViewById(R.id.imgmedicalbutton3);
		 mb4=(ImageButton)findViewById(R.id.imgmedicalbutton4);
		 
		 mb1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getApplicationContext(),"butt1",200).show();
				
			Intent i1=new Intent(medical.this,disease.class);
				startActivity(i1);
			}
		});
		 
		 
		 mb3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i1=new Intent(medical.this,searchengine.class);
				startActivity(i1);
				
			}
		});
		 
		 mb2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent me1=new Intent("android.intent.action.symptom");
				startActivity(me1);
				
				
			}
		});
		 mb4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i4=new Intent(medical.this,gpspage.class);
				startActivity(i4);
			}
		});
		 
	}

	
}
