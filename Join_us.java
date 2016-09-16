package com.example.prayas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Join_us extends Activity {
	
	Button jb1;
	protected void onCreate(Bundle savedInstanceState) {
	
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.join_us);
		jb1=(Button)findViewById(R.id.jb1);
		jb1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent ji1=new Intent("android.intent.action.regmember");
				startActivity(ji1);
				
			}
		});
	}

}
