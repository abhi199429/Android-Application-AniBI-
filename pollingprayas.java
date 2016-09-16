package com.example.prayas;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class pollingprayas extends Activity {

	
	public static ArrayList<String> pal1=new ArrayList<String>();
	public static ListView ppl1;
	public static ArrayAdapter<String> pad1;
	public static String s1;
	public static int count;
	public static String data1;
	//private String[] con;
	private static final String SENDER_ID = "218106780727";
	String regId1="" ;
	customlistviewpolling cd;
	private NotificationManager mgr1=null;
	
	public static class Prayaspolling {

		String Title;
		String date;
		String Time;
		//String new_t;
		//ImageView image;
		
	}

	public static ArrayList<Prayaspolling> n1=new ArrayList<Prayaspolling>();
	//public static ArrayList<String> ial1=new ArrayList<String>();
    public static Prayaspolling n2=new Prayaspolling(); 

	public static ArrayList<String> itemname;

	
	public static String NAMESPACE = "http://tempuri.org/";
	public static String  URL = Homepage.ipadd;
	public static String SOAP_ACTION = "http://tempuri.org/selectpollingdetails";
	String METHOD_NAME = "selectpollingdetails"; 

	
	
	public static String NAMESPACE1 = "http://tempuri.org/";
	public static String SOAP_ACTION1 = "http://tempuri.org/updatecounter";
	
	String METHOD_NAME1 = "updatecounter"; 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.pollingprayas);
	    ppl1=(ListView)findViewById(R.id.pollinglistview1);
	    pal1.clear();
	 //   con=getResources().getStringArray(R.array.city_array);
	
	    
	    if(!isMyServiceRunning(backgroundservice.class))
		{
			startService(new Intent(pollingprayas.this,backgroundservice.class));	
		}
	    n1.clear();
	    
	    
	    DoLogin2 d2=new DoLogin2();
	    d2.execute();
	    
	   
 
	    
	    
	   
	    
	    
	    
	    
	    
	    
	    ppl1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,final int pos,
					long arg3) {
				// TODO Auto-generated method stub
				
		
				 
		//	s1=	n1[pos];
				
				//s1=ppl1.getSelectedItem().toString();
		//		strcpy(s1,ppl1.getSelectedItem());
				  Toast.makeText(pollingprayas.this, Integer.toString(pos), Toast.LENGTH_SHORT).show();
				 
			 
				 AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(pollingprayas.this);


						// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();
						//alertDialog.setTitle(que);
						alertDialog.setMessage(s1);
						
						alertDialog.setButton("Going", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
							count=count+1;	
							DoLogin3 d3=new DoLogin3();
							d3.execute();
							
							}
						});
			
						
						
						alertDialog.setButton2("Not Going", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								
							}
						});
						alertDialog.show();
				
			    	
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
	   	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	   	        envelope.dotNet=true;
	   	        envelope.setOutputSoapObject(request);
	   	        
	   	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	   	        
	   	        androidHttpTransport.call(SOAP_ACTION, envelope);
	            SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
	   	        
	   	        Log.d("message","MEssage : "+resultstr.toString());
	   	       // s4=resultstr.toString();
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
	   		pdia = new ProgressDialog(pollingprayas.this);
	   		pdia.setCanceledOnTouchOutside(false);
	           pdia.setMessage("Loading...");
	           pdia.show(); 
	   	}
	   	
	   	
	   	@Override
	   	protected void onPostExecute(String result) {
	   		// TODO Auto-generated method stub
	   		super.onPostExecute(result);    	    	
	   		//Toast.makeText(pollingprayas.this, result.toString(),Toast.LENGTH_LONG).show();
	   		
	   		pdia.dismiss();
	   		
	   		//Toast.makeText(getApplicationContext(), s4,Toast.LENGTH_LONG ).show();;
		///	String pro[]=result.split(">");
		//	Toast.makeText(getApplicationContext(),result, Toast.LENGTH_LONG).show();
		
			/*int n=0;
			for(int i=0;i<pro.length;i++)
			{  
				String pro1[]=result.split("'");
				{	
					
			for(int j=0;j<pro1.length;j++)
			{
					pal1.add(pro1[j]);
					n=n+1;
			}
			
				}
				
			}	
			pad1=new ArrayAdapter<String>(pollingprayas.this, android.R.layout.simple_list_item_1,pal1);
			ppl1.setAdapter(pad1);
			registerForContextMenu(ppl1);
			  */  	
			String pro1[]=result.split("`");
		//	Toast.makeText(pollingprayas.this, pro1[0],100).show();
		//	String prodata1[]=pro1[0].split("<");
		//	Toast.makeText(pollingprayas.this, prodata1[0],100).show();
			//Toast.makeText(pollingprayas.this, prodata1[1],100).show();
    			
			
			for(int i=0;i<pro1.length;i++)
    		{
    			String prodata1[]=pro1[i].split("<");
    		
    		//	Toast.makeText(pollingprayas.this, prodata1[0],100).show();
    			//Toast.makeText(pollingprayas.this, prodata1[1],100).show();
    		//	Toast.makeText(pollingprayas.this, prodata1[2],100).show();
        		
    			Prayaspolling n2=new Prayaspolling();
    	//	n2.news_d=prodata1[0];
    		n2.Title=prodata1[0];	
    		n2.date=prodata1[1];
    		n2.Time=prodata1[2];
    		//ial1.add(n2.Image);
    		n1.add(n2);
    		
    			//Log.d("data",n2.news_d);
    		}
    
    	    		cd =new customlistviewpolling(pollingprayas.this, n1);
    		
    		ppl1.setAdapter(cd);    		
    	

			
	   	}
	   	
	   }


	class DoLogin3 extends AsyncTask<Void, Void, String>
	   {
	   	private ProgressDialog pdia;
	   	
	   	@Override
	   	protected String doInBackground(Void... params) {
	   		// TODO Auto-generated method stub
	   		
	   		try
	   		{
	   			SoapObject request = new SoapObject(NAMESPACE1, METHOD_NAME1);
	   			request.addProperty("Title",s1);

	   	        request.addProperty("E_count",count);

	   	        //request.addProperty("password", e2.getText().toString());
	   	        
	   	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	   	        envelope.dotNet=true;
	   	        envelope.setOutputSoapObject(request);
	   	        
	   	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	   	        
	   	        androidHttpTransport.call(SOAP_ACTION1, envelope);
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
	   		pdia = new ProgressDialog(pollingprayas.this);
	   		pdia.setCanceledOnTouchOutside(false);
	           pdia.setMessage("Loading...");
	           pdia.show(); 
	   	}
	   	
	   	
	   	@Override
	   	protected void onPostExecute(String result) {
	   		// TODO Auto-generated method stub
	   		super.onPostExecute(result);    	    	
	   		
	   		
	   		pdia.dismiss();
	   		  Toast.makeText(pollingprayas.this, result, Toast.LENGTH_LONG).show();
/*
			String pro[]=result.split("`");
			//Toast.makeText(getApplicationContext(), pro[0].toString(), Toast.LENGTH_SHORT).show();
		int n=0;
			for(int i=0;i<pro.length;i++)
		{  
			pal1.add(pro[i]);
			n=n+1;
		}	
			pad1=new ArrayAdapter<String>(pollingprayas.this, android.R.layout.simple_list_item_1,pal1);
			ppl1.setAdapter(pad1);
			registerForContextMenu(ppl1);
	*/		    	
	   		
	   	}
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
    

}



	


