package com.example.prayas;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.example.prayas.Regmember.DoLogin;
import com.google.android.gcm.GCMRegistrar;

import android.R.string;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




import com.example.prayas.SessionManager;
;public class loginprayas extends Activity{

	
	TextView tl1,tl2,tl3;
	EditText el1,el2;
	Button b1,b2,b3,b4,b5;
	public static String username,pass;
	public static String uname;
	public static String type;
	
	//public static final String MyPreferences= "MyPrefs";
	//public static final String UserName="unamekey";
	//public static final String Password="passkey";
	//public static final String email="emailkey";
	//SharedPreferences sp;

private static final String SENDER_ID = "218106780727";

private NotificationManager mgr=null;

	
	   public static String NAMESPACE = "http://tempuri.org/";
		public static String  URL = Homepage.ipadd; 
		public static String SOAP_ACTION = "http://tempuri.org/select";
		String METHOD_NAME = "select"; 
		public static String userid="";
		SessionManager session11;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	   setContentView(R.layout.loginxmlprayas);
	   el1=(EditText)findViewById(R.id.eT1);
	   el2=(EditText)findViewById(R.id.eT2);
	   
	   //el1.setText("jenil");
	   //el2.setText("jenil");
	   //el1=(EditText)findViewById(R.id.email_id);
	   //el2=(EditText)findViewById(R.id.pass_id);
	   b1=(Button)findViewById(R.id.btnLogin);
	   //b2=(Button)findViewById(R.id.btnmemberLogin);
	   b3=(Button)findViewById(R.id.btnuserLogin);
	   b4=(Button)findViewById(R.id.btnmemberLogin);
	   b5=(Button)findViewById(R.id.fpbut);
	   tl1=(TextView)findViewById(R.id.emailtext);
	   tl2=(TextView)findViewById(R.id.passtext);
	   tl3=(TextView)findViewById(R.id.link_to_register);
	   //el1.setText("admin");
	   //el2.setText("hiral");
	   //username=el1.getText().toString();
	   
	   
	   //sp = getSharedPreferences(MyPreferences,Context.MODE_PRIVATE);

	   
	   
	   //manager = new SessionManager(); 
	   b1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			uname=el1.getText().toString();
			pass=el2.getText().toString();
			
			
			
			if(uname.equalsIgnoreCase("") || pass.equalsIgnoreCase(""))
			{
				Toast.makeText(getApplicationContext(), "User name or Password can not be empty",Toast.LENGTH_LONG).show();
			}
			else
			{
				DoLogin1 obj=new DoLogin1();
				obj.execute();
				
				//session11.createLoginSession(uname, pass);
							
			}
				
			
			}
	});
		   b3.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i2=new Intent("android.intent.action.reguser");
		    startActivity(i2);
		}
	});
	b4.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i4=new Intent("android.intent.action.regmember");
			startActivity(i4);
		}
	});
	
	b5.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent ifp=new Intent(loginprayas.this,ForgotPassword.class);
			startActivity(ifp);
			
		}
	});
	}
	

    class DoLogin1 extends AsyncTask<Void, Void, String>
    {
    	private ProgressDialog pdia;
    	
    	@Override
    	protected String doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		
    		try
    		{
    			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    	        request.addProperty("M_uname", el1.getText().toString());
    	        request.addProperty("M_pwd", el2.getText().toString());
    	            	        
    	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	        envelope.dotNet=true;
    	        envelope.setOutputSoapObject(request);
    	        
    	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
    	        
    	        androidHttpTransport.call(SOAP_ACTION, envelope);
    	        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
    	        
    	        Log.d("message","MEssage : "+resultstr.toString());
    	        return resultstr.toString();
    	        
//    	        Toast.makeText(Reg.this, resultstr.toString(), Toast.LENGTH_SHORT).show();
    		}
    		catch(Exception e)
    		{
    			Log.e("error13", e.toString());
    			return "fail";
    			
    		}
    			
    		
    		
    	}
    	
    	
    	@Override
    	protected void onPreExecute() {
    		// TODO Auto-generated method stub
    		super.onPreExecute();
    		pdia = new ProgressDialog(loginprayas.this);
    		pdia.setCanceledOnTouchOutside(false);
            pdia.setMessage("LOGIN ONGOING");
            
            pdia.show(); 
    	}
    	
    	
    	@Override
    	protected void onPostExecute(String result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);    	    	
    		
    		
    		pdia.dismiss();
    	//Toast.makeText(loginprayas.this, result, 2000).show();
    		
    		if(result.equals("User"))
    		{
    			//session.createLoginSession("Android Hive", "anroidhive@gmail.com");
    			//session.cre
    			type="User";
       			Toast.makeText(getApplicationContext(), uname + "(User)" , 10).show();
    			Intent i3=new Intent(loginprayas.this,Homepage.class);
    			startActivity(i3);
    			
    			
    		}
    		
    		else if(result.equals("Member"))
    		{
    			type="Member";
    			Toast.makeText(getApplicationContext(), uname+"(Member)" , 10).show();
    			Intent ii3=new Intent(loginprayas.this,Memhome.class);
    			startActivity(ii3);
    			
    			
    		}
    		else if(result.equals(""))
    		{
    			Toast.makeText(loginprayas.this,"error", 2000).show();
    			
    		}
    	}

    	

    }

}
