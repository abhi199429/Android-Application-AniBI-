package com.example.prayas;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class P_Aboutus extends Activity {

	
	ImageView iv1;
	Button pab1,pab2,pab3,pab4,pab5;
	TextView patv1;
	public static int flag=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.p_aboutusdesign);
	    
	    
	    pab1=(Button)findViewById(R.id.jb1);
	    pab2=(Button)findViewById(R.id.repneck);
	    pab3=(Button)findViewById(R.id.repback);
	    pab4=(Button)findViewById(R.id.repleg1);
	    pab5=(Button)findViewById(R.id.repleg2);
	  
	    //final Animation animtranslate1 = AnimationUtils.loadAnimation(P_Aboutus.this, R.anim.translate);
	    //pab1.setAnimation(animtranslate1);
	    //pab2.setAnimation(animtranslate1);
	    //pab3.setAnimation(animtranslate1);
	    //pab4.setAnimation(animtranslate1);
	    //pab5.setAnimation(animtranslate1);
          
	    pab1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				flag=1;
				Intent i1=new Intent("android.intent.action.aboutusinfo");
			     startActivity(i1);	
			
			}
		});
	
	

	
	
	pab2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			flag=2;
			Intent i2=new Intent("android.intent.action.aboutusinfo");
			startActivity(i2);
			
			 	}
	});




pab3.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		flag=3;
		Intent i3=new Intent("android.intent.action.aboutusinfo");
		startActivity(i3);
		
				
		
	}
});

pab4.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		flag=4;
		Intent i4=new Intent("android.intent.action.aboutusinfo");
		startActivity(i4);
				
	}
});


pab5.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		flag=5;
		Intent i5=new Intent("android.intent.action.aboutusinfo");
		startActivity(i5);
				
	}
});
	}

	
	
}
