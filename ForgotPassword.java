package com.example.prayas;

import java.net.PasswordAuthentication;
import java.util.Properties;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.example.prayas.news.News;
import com.example.prayas.pollingprayas.Prayaspolling;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.service.textservice.SpellCheckerService.Session;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword extends Activity
{
	Button b1;
	EditText ee1;
	//GmailSender sender;
	
	
	
	public static String NAMESPACE = "http://tempuri.org/";
	public static String  URL = Homepage.ipadd;
	public static String SOAP_ACTION = "http://tempuri.org/selectemail";
	String METHOD_NAME = "selectemail"; 

	public static String sl1;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgotpassword);
		b1=(Button)findViewById(R.id.fpbutton);
		ee1=(EditText)findViewById(R.id.fpEditText);
        
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 sl1=ee1.getText().toString();
				

			//pd = ProgressDialog.show(context, "", "Sending Mail....",true);
			
			Fp dl=new Fp();
			dl.execute();
			
			
			
			
			}
		});
		
		Toast.makeText(getApplicationContext(),"Check Your Mail", 5000).show();	
		
	}
	
	class Fp extends AsyncTask<Void, Void, String>
	{
		private ProgressDialog pdia;
		
		@Override
		protected String doInBackground(Void... params) {
			// TODO Auto-generated method stub
			
			try
			{
				SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		        request.addProperty("M_eid",ee1.getText().toString());
		        
		        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		        envelope.dotNet=true;
		        envelope.setOutputSoapObject(request);
		        
		        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		        
		        androidHttpTransport.call(SOAP_ACTION, envelope);
		        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
		        
		        Log.d("message","MEssage : "+resultstr.toString()+sl1);
		        return resultstr.toString();
		        
		        
		        

			}
			catch(Exception e)
			{
				Log.e("error15", e.toString());
				return "fail";
				
			}
				
			
		}
		
		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pdia = new ProgressDialog(ForgotPassword.this);
			pdia.setCanceledOnTouchOutside(false);
	        pdia.setMessage("Loading...");
	        pdia.show(); 
		}
		
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);    	    	
			Log.d("M_uname", sl1);		
			
			pdia.dismiss();
			
			String pro[]=result.split("'");
			
			//String email=pro[0];
			//String pass=pro[1];
	
			
						
			
		}
		
		
	}

}