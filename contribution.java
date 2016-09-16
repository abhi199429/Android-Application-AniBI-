package com.example.prayas;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.Calendar;

public class contribution extends Activity{
	
	EditText ce1,ce2,ce3,ce4,ce5,ce6,ce7;
	TextView tc1,tc2,tc3,tc4,tc5;
	Button cb1;
	RadioButton crr1,crr2;
	RadioGroup rgc;
    public static String c1,c2,c3,c4,c5,conrad1="CASH";
	
	public static String NAMESPACE = "http://tempuri.org/";
	public static String  URL = Homepage.ipadd;
	public static String SOAP_ACTION = "http://tempuri.org/insertdon";
	String METHOD_NAME = "insertdon"; 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contribution);
		//rgc=(RadioGroup)findViewById(R.id.radioGroupcon1);
		ce1=(EditText)findViewById(R.id.editTextcon1);
		ce2=(EditText)findViewById(R.id.editTextcon2);
		ce3=(EditText)findViewById(R.id.editTextcon3);
		ce4=(EditText)findViewById(R.id.editTextcon4);
		//ce5=(EditText)findViewById(R.id.editTextcon5);
		tc1=(TextView)findViewById(R.id.textViewcon1);
		tc2=(TextView)findViewById(R.id.textViewcon2);
		tc3=(TextView)findViewById(R.id.textViewcon3);
		tc4=(TextView)findViewById(R.id.textViewcon4);
		tc5=(TextView)findViewById(R.id.textViewcon5);

		ce6=(EditText)findViewById(R.id.conaddress1);
		ce7=(EditText)findViewById(R.id.conmobno);
				
		cb1=(Button)findViewById(R.id.consubmit);
		crr1=(RadioButton)findViewById(R.id.conradio1);
		crr2=(RadioButton)findViewById(R.id.conradio2);
		
		c1=ce1.getText().toString();
		c2=ce2.getText().toString();
		c4=ce4.getText().toString();
	//c5=ce5.getText().toString();
		
		ce3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			
				
				public void onClick(View v) {
		            // TODO Auto-generated method stub
		            //To show current date in the datepicker
		            Calendar mcurrentDate=Calendar.getInstance();
		           final int mYear = mcurrentDate.get(Calendar.YEAR);
		           final int mMonth = mcurrentDate.get(Calendar.MONTH);
		            final int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

		            DatePickerDialog mDatePicker=new DatePickerDialog(contribution.this, new OnDateSetListener() {                  
		                public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
		                    // TODO Auto-generated method stub
		                	int a=selectedmonth+1;
		                	ce3.setText(selectedday+"/"+a+"/"+selectedyear);
        /*      Your code   to get date and time    */
		                }
		            },mYear, mMonth, mDay);
		            mDatePicker.setTitle("Select date");                
		            mDatePicker.show();
		            
			}
				
			
		});
		
		
		c3=ce3.getText().toString();
		
		crr1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				conrad1=crr1.getText().toString();
				
				
			}
		});
		
		crr2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				conrad1=crr2.getText().toString();
						
			}
		});		
		
		
		cb1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				DoLogincon cont=new DoLogincon();
				cont.execute();
		        Toast.makeText(contribution.this, "thanks", Toast.LENGTH_LONG).show();       				
			}
		});
		
		
	}
	
	
	class DoLogincon extends AsyncTask<Void, Void, String>
	   {
	   	private ProgressDialog pdia;
	   	
	   	@Override
	   	protected String doInBackground(Void... params) {
	   		// TODO Auto-generated method stub
	   		
	   		try
	   		{
	   			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	   	        request.addProperty("Do_name",ce1.getText().toString());
	   	        request.addProperty("Amount",ce2.getText().toString());

	   	        request.addProperty("D_date",ce3.getText().toString());
	         	request.addProperty("D_time",ce4.getText().toString());
	   	        request.addProperty("D_type",conrad1);
	   	        
	   	        request.addProperty("D_conaddress",ce6.getText().toString());
	   	        request.addProperty("D_conmobno",ce7.getText().toString());

	   	        request.addProperty("D_conmobno",conrad1);

	   	        
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
	   		pdia = new ProgressDialog(contribution.this);
	   		pdia.setCanceledOnTouchOutside(false);
	           pdia.setMessage("Loading...");
	           pdia.show(); 
	   	}
	   	
	   	
	   	@Override
	   	protected void onPostExecute(String result) {
	   		// TODO Auto-generated method stub
	   		super.onPostExecute(result);    	    	
	   		
	   		
	   		pdia.dismiss();
	   		

			   		
	   	}
	   }


}
