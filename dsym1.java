package com.example.prayas;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class dsym1 extends Activity {

	public static TextView t1,t2,t3,t4,t5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dsym1);
		
		t1=(TextView)findViewById(R.id.disdetailtv1);
		t2=(TextView)findViewById(R.id.chatcustomtextView2);
		t3=(TextView)findViewById(R.id.textView3);
		t4=(TextView)findViewById(R.id.textView4);
		t5=(TextView)findViewById(R.id.textView5);
		
		//dsym.DoLogin2() d1= new dsym.DoLogin2();
		
		
		//Toast.makeText(getApplicationContext(), dsym.n2.Dis_details, 200).show();
		//t3.setText(dsym.dname);
		//t5.setText(dsym.n2.Dis_details);
	}
	
	
}
