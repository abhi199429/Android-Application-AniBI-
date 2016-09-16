package com.example.prayas;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Changeprofile extends Activity
{
	
	EditText cpe1,cpe2,cpe3,cpe4;
	Button cpb1,cpb2;
	TextView cptv1,cptv2,cptv3,cptv4;
	
	
	
	public static String NAMESPACE = "http://tempuri.org/";
	public static String  URL = Homepage.ipadd;
	public static String SOAP_ACTION = "http://tempuri.org/selectchangeprofile";
	String METHOD_NAME = "selectchangeprofile"; 

	
	public static String NAMESPACEr = "http://tempuri.org/";
	public static String  URLr = Homepage.ipadd;
	public static String SOAP_ACTIONr = "http://tempuri.org/updateuser";
	String METHOD_NAMEr = "updateuser"; 

	public static String NAMESPACEr1 = "http://tempuri.org/";
	public static String  URLr1 = Homepage.ipadd;
	public static String SOAP_ACTIONr1 = "http://tempuri.org/updatemember";
	String METHOD_NAMEr1 = "updatemember"; 

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.changeprofile);
		
		cpe1=(EditText)findViewById(R.id.cpet1);
		cpe2=(EditText)findViewById(R.id.cpet2);
		cpe3=(EditText)findViewById(R.id.cpet3);
		cpe4=(EditText)findViewById(R.id.cpet4);
		cpb1=(Button)findViewById(R.id.cpb1);
		cpb2=(Button)findViewById(R.id.cpb2);
		cptv1=(TextView)findViewById(R.id.cptv1);
		cptv2=(TextView)findViewById(R.id.cptv2);
		cptv3=(TextView)findViewById(R.id.cptv3);
		cptv4=(TextView)findViewById(R.id.cptv4);
		
		cptv1.setText("Name");
		cptv2.setText("Password");
		cptv3.setText("Email-id");
		cptv4.setText("Mobile Number");
	
		Changeprofile1 cp1=new Changeprofile1();
		cp1.execute();
		cpb1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Changeprofile2 cp2= new Changeprofile2();
				cp2.execute();
				
				
			}
		});
		
		cpb2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	
	}
	
	
	
	class Changeprofile1 extends AsyncTask<Void, Void, String>
    {
    	private ProgressDialog pdia;
    	
    	@Override
    	protected String doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		
    		try
    		{
    			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    	        request.addProperty("G_uname", loginprayas.uname);

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
    		pdia = new ProgressDialog(Changeprofile.this);
    		pdia.setCanceledOnTouchOutside(false);
            pdia.setMessage("Loading...");
            pdia.show(); 
    	}
    	
    	
    	@Override
    	protected void onPostExecute(String result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);    	    	
    		Log.d("data", result);
    		
    		pdia.dismiss();
    		Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
    		

    		//String pro[]=result.split("'");
    	
    		/*cpe1.setText(pro[0]);
    		cpe2.setText(pro[1]);
    		cpe3.setText(pro[2]);
    		cpe4.setText(pro[3]);*/
    		//Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
    	}
    		
    		
    		
    	
    	}
		
	class Changeprofile2 extends AsyncTask<Void, Void, String>
    {
    	private ProgressDialog pdia;
    	
    	@Override
    	protected String doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		
    		try
    		{
    			
    	        if(loginprayas.type.equalsIgnoreCase("User"))
    	        {
    	        	SoapObject request = new SoapObject(NAMESPACEr, METHOD_NAMEr);
    	        
    	        	request.addProperty("M_uname", loginprayas.uname);
    	        	request.addProperty("M_name", cpe1.getText().toString());
    	        	request.addProperty("M_pwd", cpe2.getText().toString());
    	        	request.addProperty("M_eid", cpe3.getText().toString());
    	        	request.addProperty("M_mobno", cpe4.getText().toString());

    	        //request.addProperty("password", e2.getText().toString());
    	        
    	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	        envelope.dotNet=true;
    	        envelope.setOutputSoapObject(request);
    	        
    	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URLr);
    	        
    	        androidHttpTransport.call(SOAP_ACTIONr, envelope);
    	        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
    	        
    	        Log.d("message","MEssage : "+resultstr.toString());
    	        
    	       
    	        return resultstr.toString();
    	        }
    	        
    	        else if(loginprayas.type.equalsIgnoreCase("Member"))
    	        {
    	        		SoapObject request = new SoapObject(NAMESPACEr1, METHOD_NAMEr1);
        	        
        	        	request.addProperty("M_uname", loginprayas.uname);
        	        	request.addProperty("M_name", cpe1.getText().toString());
        	        	request.addProperty("M_pwd", cpe2.getText().toString());
        	        	request.addProperty("M_eid", cpe3.getText().toString());
        	        	request.addProperty("M_mobno", cpe4.getText().toString());

        	        //request.addProperty("password", e2.getText().toString());
        	        
        	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        	        envelope.dotNet=true;
        	        envelope.setOutputSoapObject(request);
        	        
        	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URLr1);
        	        
        	        androidHttpTransport.call(SOAP_ACTIONr1, envelope);
        	        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
        	        
        	        Log.d("message","MEssage : "+resultstr.toString());
        	        
        	       
        	        return resultstr.toString();

    	        }
    	    
    	        else
    	        {
    	        	return "Late";
    	        }
    	        

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
    		pdia = new ProgressDialog(Changeprofile.this);
    		pdia.setCanceledOnTouchOutside(false);
            pdia.setMessage("Loading...");
            pdia.show(); 
    	}
    	
    	
    	@Override
    	protected void onPostExecute(String result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);    	    	
    		Log.d("data", result);
    		
    		pdia.dismiss();
    		//Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
    		

    		Toast.makeText(getApplicationContext(),"Profile Updated", Toast.LENGTH_LONG).show();
    
    		//showMap(s_lon, s_lat);
    	}
    		
    		
    		
    	
    	}

	
	
}
