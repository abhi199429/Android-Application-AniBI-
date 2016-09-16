
/*
package com.example.prayas;

import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.google.android.gcm.GCMRegistrar;
import com.example.prayas.home;
import com.example.prayas.rabbitsym.diseas;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Memhome extends Activity
{
	ImageButton ibm1,ibm2,ibm3,ibm4;
	public static String ipadd1="http://192.168.1.108/WebSite3/WebService.asmx";
	public static String ip1="http://192.168.1.108/WebSite3/upload/";
	public static Double lntd;
	public static Double altd;

	public String user=loginprayas.userid;
	private static final String SENDER_ID = "218106780727";

private NotificationManager mgr=null;

public static String NAMESPACE1 = "http://tempuri.org/";
public static String  URL1 = Memhome.ipadd;
public static String SOAP_ACTION1 = "http://tempuri.org/inserttoken";
String METHOD_NAME1 = "inserttoken"; 
 String regId="" ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.Memhome);
		//Toast.makeText(getApplicationContext(),loginprayas.username,1).show();
		
		GCMRegistrar.checkDevice(Memhome.this);
		GCMRegistrar.checkManifest(Memhome.this);
		regId = GCMRegistrar.getRegistrationId(Memhome.this);
		if (regId.equals("")) 
		{
		  GCMRegistrar.register(this, SENDER_ID);
		  Toast.makeText(getApplicationContext(), regId, 1).show();
		  
		} 
		else
		{
		  Log.v("Push", regId);
		  Toast.makeText(getApplicationContext(), regId, 1).show();
			
		  DoLogin2 dhp=new DoLogin2();
		  dhp.execute();
		 
		}
		 
		mgr=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		mgr.cancel(1);
		
		
		//ibm1=(ImageButton)findViewById(R.id.ibm1);
		ibm1=(ImageButton)findViewById(R.id.ibm1);
		
		ibm2=(ImageButton)findViewById(R.id.ibm2);

		ibm3=(ImageButton)findViewById(R.id.ibm3);

		ibm4=(ImageButton)findViewById(R.id.ibm4);
		

		if(!isMyServiceRunning(backgroundservice.class))
		{
			startService(new Intent(Memhome.this,backgroundservice.class));	
		}
	
	
		ibm1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent ibb6=new Intent(Memhome.this,newsdivisionprayas.class);
				startActivity(ibb6);
		
			}
		});
		
		ibm2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in=new Intent(Memhome.this,contribution.class);
			    startActivity(in);
			}
		});

		ibm3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent ib6=new Intent(Memhome.this,chat.class);
				startActivity(ib6);
		
			}
		});

		ibm4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent ib65=new Intent(Memhome.this,piechart.class);
				startActivity(ib65);
		
					}
		});

		
	}
	public boolean isMyServiceRunning(Class<?> serviceClass) {
	    ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
	    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
	        if (serviceClass.getName().equals(service.service.getClassName())) {
	            return true;
	        }
	    }
	    return false;
	}
    

class DoLogin2 extends AsyncTask<Void, Void, String>
{
	private ProgressDialog pdia;
	
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		
		try
		{
			SoapObject request = new SoapObject(NAMESPACE1, METHOD_NAME1);
	        request.addProperty("M_token",regId);
	        request.addProperty("M_uname",loginprayas.uname);
Log.d("M_uname", user);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet=true;
	        envelope.setOutputSoapObject(request);
	        
	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL1);
	        
	        androidHttpTransport.call(SOAP_ACTION1, envelope);
	        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
	        
	        Log.d("message","MEssage : "+resultstr.toString()+user);
	        return resultstr.toString();
	        

		}
		catch(Exception e)
		{
			Log.e("error15", e.toString());
			return "fail,fail";
			
		}
			
		
		
	}
	
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		pdia = new ProgressDialog(Memhome.this);
		pdia.setCanceledOnTouchOutside(false);
        pdia.setMessage("Loading...");
        pdia.show(); 
	}
	
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);    	    	
		Log.d("M_uname", user);		
	//	Toast.makeText(getApplicationContext(),loginprayas.username,1).show();
		
		pdia.dismiss();

		
		//t2.setText(n2.Dis_name);
		//t1.setText(n2.Dis_details);

			//Log.d("data",n2.news_d);
			
		
	}
	
}	
}

*/

package com.example.prayas;

import java.util.HashMap;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.google.android.gcm.GCMRegistrar;
import com.example.prayas.home;
import com.example.prayas.rabbitsym.diseas;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Memhome extends Activity
{
	ImageButton ib1,ib2,ib3,ib4,ib5,ib6;
	public static String ipadd="http://192.168.1.102/WebSite3/WebService.asmx";
public static String ip="http://192.168.1.102/WebSite3/upload/";
public static Double lntd;
public static Double altd;

public String user1=loginprayas.userid;
private static final String SENDER_ID1 = "218106780727";

private NotificationManager mgr=null;

SessionManager session1;

public static String NAMESPACE = "http://tempuri.org/";
public static String  URL = Memhome.ipadd;
public static String SOAP_ACTION = "http://tempuri.org/inserttoken";
String METHOD_NAME = "inserttoken"; 
 String regId1="" ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.memhome);
		//Toast.makeText(getApplicationContext(),loginprayas.username,1).show();
		session1 = new SessionManager(getApplicationContext());
		GCMRegistrar.checkDevice(Memhome.this);
		GCMRegistrar.checkManifest(Memhome.this);
		regId1 = GCMRegistrar.getRegistrationId(Memhome.this);
		
		 session1.checkLogin();
         
	        // get user data from session
	        HashMap<String, String> user = session1.getUserDetails();
	         
	        // name
	        String name = user.get(SessionManager.KEY_NAME);
	         
	        // email
	        String email = user.get(SessionManager.KEY_EMAIL);
	       
		
		if (regId1.equals("")) 
		{
		  GCMRegistrar.register(this, SENDER_ID1);
		  Toast.makeText(getApplicationContext(), regId1, 1).show();
		  
		} 
		else
		{
		  Log.v("Push", regId1);
		  Toast.makeText(getApplicationContext(), regId1, 1).show();
			
		  DoLogin2 dhp=new DoLogin2();
		  dhp.execute();
		 
		}
		 
		mgr=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
		mgr.cancel(1);
		
		
		ib1=(ImageButton)findViewById(R.id.ibm1);

		ib2=(ImageButton)findViewById(R.id.ibm2);

		ib3=(ImageButton)findViewById(R.id.ibm3);

		ib4=(ImageButton)findViewById(R.id.ibm4);

		
		if(!isMyServiceRunning(backgroundservice.class))
		{
			startService(new Intent(Memhome.this,backgroundservice.class));	
		}
	
	
		ib1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*Intent ib6=new Intent(getApplicationContext(),newsdivisionprayas.class);
				startActivity(ib6);
		*/
			/*	SharedPreferences sp= getSharedPreferences(loginprayas.MyPreferences, Context.MODE_PRIVATE);
				 SharedPreferences.Editor editor = sp.edit();
				 editor.clear();
				 editor.commit();
		
				*/
				session1.logoutUser();	
				
			}
		});
		
		ib2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in=new Intent(Memhome.this,Changeprofile.class);
			    startActivity(in);
			}
		});

		ib3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			/*	SharedPreferences sp= getSharedPreferences(loginprayas.MyPreferences, Context.MODE_PRIVATE);
				 SharedPreferences.Editor editor = sp.edit();
				 editor.clear();
				 editor.commit();
				*/ 
			}
		});

		ib4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		/*		
				Intent ib6=new Intent(getApplicationContext(),contribution.class);
				startActivity(ib6);
		
			*/
			}
		});

			}
	public boolean isMyServiceRunning(Class<?> serviceClass) {
	    ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
	    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
	        if (serviceClass.getName().equals(service.service.getClassName())) {
	            return true;
	        }
	    }
	    return false;
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
	        request.addProperty("M_token",regId1);
	        request.addProperty("M_uname",loginprayas.uname);
Log.d("U_name", user1);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet=true;
	        envelope.setOutputSoapObject(request);
	        
	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        
	        androidHttpTransport.call(SOAP_ACTION, envelope);
	        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
	        
	        Log.d("message","MEssage : "+resultstr.toString()+user1);
	        return resultstr.toString();
	        

		}
		catch(Exception e)
		{
			Log.e("error15", e.toString());
			return "fail,fail";
			
		}
			
		
		
	}
	
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		pdia = new ProgressDialog(Memhome.this);
		pdia.setCanceledOnTouchOutside(false);
        pdia.setMessage("Loading...");
        pdia.show(); 
	}
	
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);    	    	
		Log.d("U_name", user1);		
	//	Toast.makeText(getApplicationContext(),loginprayas.username,1).show();
		
		pdia.dismiss();

		
		//t2.setText(n2.Dis_name);
		//t1.setText(n2.Dis_details);

			//Log.d("data",n2.news_d);
			
		
	}
	
}	
}