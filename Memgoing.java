package com.example.prayas;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.example.prayas.news.News;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Memgoing extends Activity
{
	TextView t1,t2,t3,t4,t5,t6;
	Button b1,b2;
	
	public static String NAMESPACE = "http://tempuri.org/";
	public static String  URL = Homepage.ipadd;
	public static String SOAP_ACTION = "http://tempuri.org/selectgpsprayasdo";
	String METHOD_NAME = "selectgpsprayasdo"; 

	public static String NAMESPACEr = "http://tempuri.org/";
	public static String  URLr = Homepage.ipadd;
	public static String SOAP_ACTIONr = "http://tempuri.org/updategpsprayasdo";
	String METHOD_NAMEr = "updategpsprayasdo"; 

	
	public static double s_lon;
	public static double s_lat;
	
	
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.memgoing);
		
		t1=(TextView)findViewById(R.id.tvmem1);
		t1.setText("Help Needed To:");
		t2=(TextView)findViewById(R.id.tvmem2);
		t3=(TextView)findViewById(R.id.tvmem3);
		t3.setText("Details:");
		t4=(TextView)findViewById(R.id.tvmem4);
		t5=(TextView)findViewById(R.id.tvmem5);
		t6=(TextView)findViewById(R.id.tvmem6);
	
		b1=(Button)findViewById(R.id.btmem1);
		b2=(Button)findViewById(R.id.btmem2);
		
		GoingGps gp= new GoingGps();
		gp.execute();
		
		b1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				GoingGpsreturns gpr = new GoingGpsreturns();
				gpr.execute();
			}
		});
		
		
		b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
			}
		});
	}
	
	
	
	class GoingGps extends AsyncTask<Void, Void, String>
    {
    	private ProgressDialog pdia;
    	
    	@Override
    	protected String doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		
    		try
    		{
    			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    	        request.addProperty("G_uname", "Abhishek");

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
    		pdia = new ProgressDialog(Memgoing.this);
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
    		

    		String pro[]=result.split("'");
    	
    		t2.setText(pro[0]);
    		s_lon=Double.parseDouble(pro[1]);
    		s_lat=Double.parseDouble(pro[2]);
    		t4.setText(pro[3]);
    		t5.setText(pro[4]);
    		t6.setText(pro[5]);
    		Toast.makeText(getApplicationContext(),"ok", Toast.LENGTH_LONG).show();
    	}
    		
    		
    		
    	
    	}
		
	
	
	
	
	class GoingGpsreturns extends AsyncTask<Void, Void, String>
    {
    	private ProgressDialog pdia;
    	
    	@Override
    	protected String doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		
    		try
    		{
    			SoapObject request = new SoapObject(NAMESPACEr, METHOD_NAMEr);
    	        request.addProperty("G_uname", "Abhishek");

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
    		pdia = new ProgressDialog(Memgoing.this);
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
    		

    		Toast.makeText(getApplicationContext(),"Thank you For going", Toast.LENGTH_LONG).show();
    
    		showMap(s_lon, s_lat);
    	}
    		
    		
    		
    	
    	}
	
	
	protected void showMap(double lon,double lat) {

		/*Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=" + ("long, lat")));
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
		
		//double latitude = 40.714728;
		//double longitude = -73.998672;
		String label = "Person's location";
		String uriBegin = "geo:" + lat + "," + lon;
		String query = lat + "," + lon + "(" + label + ")";
		String encodedQuery = Uri.encode(query);
		String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
		Uri uri = Uri.parse(uriString);
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
		startActivity(intent);
	}

    	
			

}
