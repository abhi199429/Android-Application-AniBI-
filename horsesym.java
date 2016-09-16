package com.example.prayas;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class horsesym extends Activity
{
	Button hob1,hob2,hob3,hob4,hob5,hob6,hob7,hob8,hob9,hob10;
	TextView tv1;
	CheckBox catc1,catc2,catc3;
	public static TextView t1,t2;


	public static String s1="Anisocoria";
	public static String dname,ddetail;
	

	public static class diseas
	{
		String Dis_name;
		String Dis_details;
		
		
	}
	public static diseas n2=new diseas();
	public ArrayList<diseas> n1=new ArrayList<diseas>();


	public static String NAMESPACE = "http://tempuri.org/";
	public static String  URL = Homepage.ipadd;
	public static String SOAP_ACTION = "http://tempuri.org/select_for_diseas";
	String METHOD_NAME = "select_for_diseas"; 


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.horsesym);
		hob1=(Button)findViewById(R.id.horseeye);
		hob2=(Button)findViewById(R.id.horsemouth);
		hob3=(Button)findViewById(R.id.horseneck);
		hob4=(Button)findViewById(R.id.horseback);
		hob5=(Button)findViewById(R.id.horseabdomen);
		hob6=(Button)findViewById(R.id.horsetail);
		hob7=(Button)findViewById(R.id.horsehips);
		hob8=(Button)findViewById(R.id.horsestomuch);
		hob9=(Button)findViewById(R.id.horsefeet1);
		hob10=(Button)findViewById(R.id.horsefeet2);
		tv1=(TextView)findViewById(R.id.horsetv1);
	
		hob1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tv1.setText(hob1.getText());
			}
		});
		hob2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tv1.setText(hob2.getText());
			}
		});
		hob3.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tv1.setText(hob3.getText());
			}
		});
		hob4.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tv1.setText(hob4.getText());
			}
		});

		hob5.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tv1.setText(hob5.getText());
			}
		});

		hob6.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tv1.setText(hob6.getText());
			}
		});
		hob7.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tv1.setText(hob7.getText());
			}
		});	
		hob8.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tv1.setText(hob8.getText());
			}
		});
		hob9.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tv1.setText(hob9.getText());
			}
		});
		hob10.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				tv1.setText(hob10.getText());
			}	
		});

	}

}
