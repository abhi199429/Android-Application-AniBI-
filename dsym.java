package com.example.prayas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
public class dsym extends Activity {
	
	ImageButton bb1;
	ImageButton bb2,bb3,bb4,bb5,bb6,bb7,bb8,bb9;
	LinearLayout l1;
	public static TextView t1,t2;
	public static String s1="Anisocoria";
	public static String dname,ddetail;
	CheckBox c1,c2,c3;
	
	
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
	
		setContentView(R.layout.dsym);
		l1=(LinearLayout)findViewById(R.layout.dsym);
		bb1=(ImageButton)findViewById(R.id.imageButton1);
		bb2=(ImageButton)findViewById(R.id.imageButton22);
		bb3=(ImageButton)findViewById(R.id.imageButton3);
		bb4=(ImageButton)findViewById(R.id.imageButton4);
		bb5=(ImageButton)findViewById(R.id.imageButton5);
		bb6=(ImageButton)findViewById(R.id.imageButton6);
		bb7=(ImageButton)findViewById(R.id.imageButton7);
		bb8=(ImageButton)findViewById(R.id.imageButton8);
		bb9=(ImageButton)findViewById(R.id.imageButton9);
		c1=(CheckBox)findViewById(R.id.rabcheckBox1);
		c2=(CheckBox)findViewById(R.id.rabcheckBox2);
		c3=(CheckBox)findViewById(R.id.rabcheckBox3);
	
	
	c1.setVisibility(TRIM_MEMORY_UI_HIDDEN);	
	c2.setVisibility(TRIM_MEMORY_UI_HIDDEN);	
	c3.setVisibility(TRIM_MEMORY_UI_HIDDEN);	
		
	
	
	
	
	bb6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				c1=(CheckBox)findViewById(R.id.rabcheckBox1);
				c2=(CheckBox)findViewById(R.id.rabcheckBox2);
				c3=(CheckBox)findViewById(R.id.rabcheckBox3);
				s1=c1.getText().toString();
				c1.setVisibility(TRIM_MEMORY_COMPLETE);
				c2.setVisibility(TRIM_MEMORY_COMPLETE);
				c3.setVisibility(TRIM_MEMORY_COMPLETE);
				t1=(TextView)findViewById(R.id.disdetailtv1);
				t2=(TextView)findViewById(R.id.chatcustomtextView2);
				
				c1.setText("Anisocoria");
				c2.setText("Corneal and Scleral Lacerations");
				c3.setText("Ulcerative Keratitis");
				c1.setChecked(false);
				c2.setChecked(false);
				c3.setChecked(false);
				//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
				
				
				c1.setOnClickListener(new View.OnClickListener() {
					
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=c1.getText().toString();
						
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						
						c1.setChecked(true);
						c2.setChecked(false);
						c3.setChecked(false);
					}
				});
				
				c2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=c2.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj3=new DoLogin2();
						obj3.execute();

						c2.setChecked(true);
						
						c1.setChecked(false);
						c3.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
				
				c3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=c3.getText().toString();
						Intent i1=new Intent(getApplicationContext(), dsym1.class);
						startActivity(i1);
					
						DoLogin2 obj4=new DoLogin2();
						obj4.execute();
						c1.setChecked(true);
						
						c2.setChecked(false);
						c1.setChecked(false);
						//t2.setText(n2.Dis_name);
						//t1.setText(n2.Dis_details);
					}
				});
		
				
				
			}
		});

		
		bb2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
			//	c1=(CheckBox)findViewById(R.id.checkBox1);
				//c2=(CheckBox)findViewById(R.id.checkBox2);
				//c3=(CheckBox)findViewById(R.id.checkBox3);
				
				
				
				c1.setText("HEARING LOSS");
				c2.setText("PAIN");
				c3.setText("ITCHING/SCRATCHING");
				c1.setChecked(false);
				c2.setChecked(false);
				c3.setChecked(false);
				
				c1.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=c1.getText().toString();
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						c1.setChecked(true);
						
						
						c2.setChecked(false);
						c3.setChecked(false);
						t2.setText(n2.Dis_name);
						t1.setText(n2.Dis_details);
							}
				});
				
				c2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=c2.getText().toString();
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						c2.setChecked(true);
						
						c1.setChecked(false);
						c3.setChecked(false);
						t2.setText(n2.Dis_name);
						t1.setText(n2.Dis_details);
					}
				});
				
				c3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=c3.getText().toString();
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						c3.setChecked(true);
						
						
						c2.setChecked(false);
						c1.setChecked(false);
						t2.setText(n2.Dis_name);
						t1.setText(n2.Dis_details);
					}
				});
		
				
				
			}
		});
		bb9.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				c1=(CheckBox)findViewById(R.id.rabcheckBox1);
				c2=(CheckBox)findViewById(R.id.rabcheckBox2);
				c3=(CheckBox)findViewById(R.id.rabcheckBox3);
				
				
				c1.setText("Deafness");
				c2.setText("Cholesteatoma");
				c3.setText("Otitis Media");
				c1.setChecked(false);
				c2.setChecked(false);
				c3.setChecked(false);
				
				c1.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=c1.getText().toString();
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						c1.setChecked(true);
						
						
						c2.setChecked(false);
						c3.setChecked(false);
						//t2.setText("Cysticercosis");
						//t1.setText("Cysticercosis is a rare disease caused by the larvae Taenia crassiceps, a type of tapeworm. Once the eggs (which is suspected to be found in the feces of infected foxes) are ingested by rabbits or other rodents, it develops in the abdominal and subcutaneous tissues, and eventually forms large masses of cysticerci (larval form) in the abdominal cavity, lungs, muscles, and in the tissues under the skin. Even worse, the cysticercus is capable of undergoing asexual reproduction and multiplying a high rate.Cysticerci masses may found under the skin or in other organs.");
					}
				});
				
				c2.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						
						s1=c2.getText().toString();
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						c2.setChecked(true);
						
						c3.setChecked(false);
						c1.setChecked(false);
						//t2.setText("Aggression");
						//t1.setText("Aggression in a dog is frightening. Not only for the person who is the apparent target, but also for the pet owner. The possibility that one might be the owner of a pet that has inflicted serious harm on another person is a nightmare. More than a million people are bitten by every year, and this is probably a very low number when you take into account all the bites that are not reported. Most bite wounds are minor, but dog bites account for one percent of all emergency room admissions. Half of the victims are also children, usually under 10 years of age.");
					}
				});
				
				c3.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						s1=c3.getText().toString();
						DoLogin2 obj2=new DoLogin2();
						obj2.execute();
						c3.setChecked(true);
						
						
						c2.setChecked(false);
						c1.setChecked(false);
						//t2.setText("Ulcerative Keratitis");
						//t1.setText("The cornea -- the transparent part of the eye --forms a cover over the iris and pupil. It also admits light to the inside of the eye. A corneal ulcer occurs when deeper layers of the cornea are lost; these ulcers are classified as superficial or deep. If your dog's eyes are tearing excessively, or it is squinting, there is a possibility of a corneal ulcer.Symptoms are red painful eye and watery eye.");
					}
				});
		
				
				
			}
		});


		
	}

 class DoLogin2 extends AsyncTask<Void, Void, String>
    {
    	private ProgressDialog pdia;
    	
    	@Override
    	protected String doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		
    		try
    		{
    			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    	        request.addProperty("Dis_name",s1);

    	        //request.addProperty("password", e2.getText().toString());
    	        
    	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	        envelope.dotNet=true;
    	        envelope.setOutputSoapObject(request);
    	        
    	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
    	        
    	        androidHttpTransport.call(SOAP_ACTION, envelope);
    	        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
    	        
    	        Log.d("message","MEssage : "+resultstr.toString());
    	        return resultstr.toString();
    	        

    		}
    		catch(Exception e)
    		{
    			Log.e("error13", e.toString());
    			return "fail,fail";
    			
    		}
    			
    		
    		
    	}
    	
    	
    	@Override
    	protected void onPreExecute() {
    		// TODO Auto-generated method stub
    		super.onPreExecute();
    		pdia = new ProgressDialog(dsym.this);
    		pdia.setCanceledOnTouchOutside(false);
            pdia.setMessage("Loading...");
            pdia.show(); 
    	}
    	
    	
    	@Override
    	protected void onPostExecute(String result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);    	    	
    		
    		
    		pdia.dismiss();

    		String pro[]=result.split("`");
    		//Toast.makeText(getApplicationContext(), pro[0].toString(), Toast.LENGTH_SHORT).show();
    	
    		n2.Dis_name=pro[0];
    		n2.Dis_details=pro[1];
    		ddetail=pro[1];
    	//	Toast.makeText(getApplicationContext(), ddetail, 200).show();
    		n1.add(n2);
    		dsym1.t3.setText(n2.Dis_name);
    		dsym1.t5.setText(ddetail);
    		
    		//t2.setText(n2.Dis_name);
			//t1.setText(n2.Dis_details);
	
    			//Log.d("data",n2.news_d);
    			
    		
    	}
    }
		}


	
	
	


	

	
	