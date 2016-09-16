package com.example.prayas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class home extends Activity {

	
	TextView th1;
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
	
        
        th1=(TextView)findViewById(R.id.texthome);
	}
    
}
