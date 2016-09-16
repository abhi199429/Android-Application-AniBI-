package com.example.prayas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class symptom extends Activity{
	
	
	TextView t1;
	ImageButton idog,icat,ihorse,ibird,irabit,ireptile;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.symptom);
	
	t1=(TextView)findViewById(R.id.disdetailtv1);
	
	idog=(ImageButton)findViewById(R.id.imagedogsymdis1);
	icat=(ImageButton)findViewById(R.id.imagecatsymdis1);
	ihorse=(ImageButton)findViewById(R.id.imagehorse);
	ibird=(ImageButton)findViewById(R.id.imagebird);
	irabit=(ImageButton)findViewById(R.id.imagerabbit);
	ireptile=(ImageButton)findViewById(R.id.imagereptile);
	
	
	
	idog.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
		//	Toast.makeText(getApplicationContext(), "hdfh", 200).show();
			Intent sy1=new Intent(symptom.this,dogsym.class);
		startActivity(sy1);
		}
	});
	
	
	ibird.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent sy1=new Intent(symptom.this,birdsym.class);
			startActivity(sy1);
				
		}
	});
	
	irabit.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent sy1=new Intent(symptom.this,rabbitsym.class);
			startActivity(sy1);
			
		}
	});
	
	ireptile.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent sy1=new Intent(symptom.this,reptilesym.class);
			startActivity(sy1);
			
		}
	});
	
	
icat.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent sy1=new Intent(symptom.this,catsym.class);
			startActivity(sy1);
			
		}
	});
ihorse.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent sy1=new Intent(symptom.this,horsesym.class);
		startActivity(sy1);
		
	}
});

	}
}
