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

public class Homepage extends Activity
{
	ImageButton ib1,ib2,ib3,ib4,ib5,ib6;
	public static String ipadd="http://192.168.1.102/WebSite3/WebService.asmx";
public static String ip="http://192.168.1.102/WebSite3/upload/";
public static Double lntd;
public static Double altd;

SessionManager session2;
public String user=loginprayas.userid;
private static final String SENDER_ID = "218106780727";

private NotificationManager mgr=null;

public static String NAMESPACE = "http://tempuri.org/";
public static String  URL = Homepage.ipadd;
public static String SOAP_ACTION = "http://tempuri.org/insertusertoken";
String METHOD_NAME = "insertusertoken"; 
 String regId="" ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		//Toast.makeText(getApplicationContext(),loginprayas.username,1).show();
		
		GCMRegistrar.checkDevice(Homepage.this);
		GCMRegistrar.checkManifest(Homepage.this);
		regId = GCMRegistrar.getRegistrationId(Homepage.this);
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
		
		
		ib1=(ImageButton)findViewById(R.id.imageButton1);

		ib2=(ImageButton)findViewById(R.id.imagebutton2);

		ib3=(ImageButton)findViewById(R.id.imgbutton3);

		ib4=(ImageButton)findViewById(R.id.imageButton4);

		ib5=(ImageButton)findViewById(R.id.imageButton5);

		ib6=(ImageButton)findViewById(R.id.imageButton6);
		
		session2.checkLogin();
        
        // get user data from session
        HashMap<String, String> user = session2.getUserDetails();
         
        // name
        String name = user.get(SessionManager.KEY_NAME);
         
        // email
        String email = user.get(SessionManager.KEY_EMAIL);
       
	

		if(!isMyServiceRunning(backgroundservice.class))
		{
			startService(new Intent(Homepage.this,backgroundservice.class));	
		}
	
	
		ib1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent ib6=new Intent(getApplicationContext(),camera.class);
				startActivity(ib6);
		
			}
		});
		
		ib2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			/*	Intent in=new Intent(Homepage.this,newsdivisionprayas.class);
			    startActivity(in);
			*/
				
				/*SharedPreferences sp= getSharedPreferences(loginprayas.MyPreferences, Context.MODE_PRIVATE);
				 SharedPreferences.Editor editor = sp.edit();
				 editor.clear();
				 editor.commit();
				*/
				session2.logoutUser();
			}
		});

		ib3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent ib6=new Intent(getApplicationContext(),medical.class);
				startActivity(ib6);
		
			}
		});

		ib4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent ib6=new Intent(getApplicationContext(),Changeprofile.class);
				startActivity(ib6);
		
					}
		});

		ib5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*SharedPreferences sp= getSharedPreferences(loginprayas.MyPreferences, Context.MODE_PRIVATE);
				 SharedPreferences.Editor editor = sp.edit();
				 editor.clear();
				 editor.commit();
				 */
			
			}
		});

		ib6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i3=new Intent("android.intent.action.join_us");
				startActivity(i3);
		
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
	        request.addProperty("user_token",regId);
	        request.addProperty("U_name",loginprayas.uname);
Log.d("U_name", user);
	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet=true;
	        envelope.setOutputSoapObject(request);
	        
	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        
	        androidHttpTransport.call(SOAP_ACTION, envelope);
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
		pdia = new ProgressDialog(Homepage.this);
		pdia.setCanceledOnTouchOutside(false);
        pdia.setMessage("Loading...");
        pdia.show(); 
	}
	
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);    	    	
		Log.d("U_name", user);		
	//	Toast.makeText(getApplicationContext(),loginprayas.username,1).show();
		
		pdia.dismiss();

		
		//t2.setText(n2.Dis_name);
		//t1.setText(n2.Dis_details);

			//Log.d("data",n2.news_d);
			
		
	}
	
}	
}