

package com.example.prayas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class disease extends Activity{
	
	public static String animal="";
	TextView t1;
	ImageButton ii1,ii2,ii3,ii4,ii5,ii6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
	setContentView(R.layout.diseaseoptionanimal);
	
	 t1=(TextView)findViewById(R.id.disdetailtv1);
	 ii1=(ImageButton)findViewById(R.id.imgdog);
	
	 ii2=(ImageButton)findViewById(R.id.imgrabbit);
		
	 ii3=(ImageButton)findViewById(R.id.imgcat);
		
	 ii4=(ImageButton)findViewById(R.id.imgcow);
		
	 ii5=(ImageButton)findViewById(R.id.imgparrot);
		
	 ii6=(ImageButton)findViewById(R.id.imghen);
		
	ii1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			animal="rabbit";
			
		    //Toast.makeText(getApplicationContext(),"1", Toast.LENGTH_LONG).show(); 			
			Intent id2=new Intent(disease.this,dislist.class);
			startActivity(id2);
		}
	});
	 
	 
	 
	 ii2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				animal="rabbit";
				 // Toast.makeText(getApplicationContext(),"2", Toast.LENGTH_LONG).show(); 			
			      	
				Intent id2=new Intent(disease.this,dislist.class);
				startActivity(id2);
			}
		});
		
	 ii3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				animal="cat";
	            //Toast.makeText(getApplicationContext(),"3", Toast.LENGTH_LONG).show(); 			
	        	
				Intent id3=new Intent(disease.this,dislist.class);
				startActivity(id3);
			}
		});
		
	 ii4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				animal="cow";
	            //Toast.makeText(getApplicationContext(),"4", Toast.LENGTH_LONG).show(); 			
	        	
				Intent id4=new Intent(disease.this,dislist.class);
				startActivity(id4);
			}
		});
		
	 ii5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				animal="parrot";
	          //  Toast.makeText(getApplicationContext(),"5", Toast.LENGTH_LONG).show(); 			
	        				
				Intent id5=new Intent(disease.this,dislist.class);
				startActivity(id5);
			}
		});
		
	 ii6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				animal="hen";
	        //    Toast.makeText(getApplicationContext(),", Toast.LENGTH_LONG).show(); 			
				Intent id6=new Intent(disease.this,dislist.class);
				startActivity(id6);
			}
		});
	 
	 
	}
	
}
