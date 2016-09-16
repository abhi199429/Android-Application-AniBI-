package com.example.prayas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Goinglistviewpage extends Activity{

	TextView g1,g2;
	Button gb1,gb2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.goinglistview);
	    
	
	    g1=(TextView)findViewById(R.id.goingtextView1);
	    g2=(TextView)findViewById(R.id.goingtextView2);
	    gb1=(Button)findViewById(R.id.going);
	    gb2=(Button)findViewById(R.id.notgoing);

	    gb1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	    
	}

	
}
