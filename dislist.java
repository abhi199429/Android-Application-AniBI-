package com.example.prayas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;



public class dislist extends Activity {
ListView l1;
ArrayList<String> al1=new ArrayList<String>();
public static String s1="";
public String[] sa={"hir","ash"};
public int i,n;
public static String disname="";


public static String NAMESPACE = "http://tempuri.org/";
public static String  URL = Homepage.ipadd;
public static String SOAP_ACTION = "http://tempuri.org/selectdislist";
String METHOD_NAME = "selectdislist"; 

	

ArrayAdapter<String> ad1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dislist);
		
        l1=(ListView)findViewById(R.id.newslistView1);
		    s1=disease.animal;
		    DoLogin2 obj=new DoLogin2();
		    obj.execute();
		    
		 l1.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				// TODO Auto-generated method stub
               disname=l1.getItemAtPosition(pos).toString();			
				//Toast.makeText(getApplicationContext(),l1.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
				Intent i1=new Intent(dislist.this,disdetails.class);
				startActivity(i1);
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
   	        request.addProperty("D_categ",s1);

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
   		pdia = new ProgressDialog(dislist.this);
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
	n=0;
		for(i=0;i<pro.length;i++)
	{  
		al1.add(pro[i]);
		n++;
	}	
		ad1=new ArrayAdapter<String>(dislist.this, android.R.layout.simple_list_item_1,al1);
		   l1.setAdapter(ad1);
		   registerForContextMenu(l1);
		    	
   		
   	}
   }
		}


	
	
	


	

	
