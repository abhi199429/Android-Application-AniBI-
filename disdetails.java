package com.example.prayas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class disdetails extends Activity {

   public static TextView dtv1,dtv2,dtv3,dtv4;
	
    public static class diseasdetail
	{
		String D_detail;
		String D_symptoms;
		String D_fa;
		String D_cause;
		
	}
    
    
    
	public static diseasdetail d1=new diseasdetail();
	public ArrayList<diseasdetail> dl1=new ArrayList<diseasdetail>();
    
    
    public static String NAMESPACE = "http://tempuri.org/";
    public static String  URL = Homepage.ipadd;
    public static String SOAP_ACTION = "http://tempuri.org/selectdislistdetails";
    String METHOD_NAME = "selectdislistdetails"; 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
        setContentView(R.layout.disdetails);
     
        dtv1=(TextView)findViewById(R.id.disdetailtextView2);
        dtv2=(TextView)findViewById(R.id.disdetailtextView4);
        dtv3=(TextView)findViewById(R.id.disdetailtextView6);
        dtv4=(TextView)findViewById(R.id.disdeatiltextView8);
	
        
        //Toast.makeText(getApplicationContext(), dislist.disname, Toast.LENGTH_LONG).show();
        DoLogin2 d3=new DoLogin2();
        d3.execute();
        
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
    	        request.addProperty("D_name",dislist.disname);

    	        //request.addProperty("password", e2.getText().toString());
    	        
    	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	        envelope.dotNet=true;
    	        envelope.setOutputSoapObject(request);
    	        
    	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
    	        
    	        androidHttpTransport.call(SOAP_ACTION, envelope);
    	        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
    	        
    	        //SoapObject resultstr = (SoapObject)envelope.getResponse();
    	        
    	        
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
    		pdia = new ProgressDialog(disdetails.this);
    		pdia.setCanceledOnTouchOutside(false);
            pdia.setMessage("Loading...");
            pdia.show(); 
    	}
    	
    	
    	@Override
    	protected void onPostExecute(String result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);    	    	
    		
    		
    		pdia.dismiss();
    		Toast.makeText(disdetails.this, result, Toast.LENGTH_LONG).show();
    		String pro[]=result.split("`");
    		//Toast.makeText(getApplicationContext(), pro[0].toString(), Toast.LENGTH_SHORT).show();
    
    		d1.D_detail=pro[0];
    		
    		
    		d1.D_symptoms=pro[1];
    		d1.D_fa=pro[2];
    		d1.D_cause=pro[3];
    	
    		
    		//	Toast.makeText(getApplicationContext(), ddetail, 200).show();
    		dl1.add(d1);
    		disdetails.dtv1.setText(d1.D_detail);
    		disdetails.dtv2.setText(d1.D_symptoms);
    		disdetails.dtv3.setText(d1.D_fa);
    		disdetails.dtv4.setText(d1.D_cause);
    		
    		//t2.setText(n2.Dis_name);
			//t1.setText(n2.Dis_details);
	
    			//Log.d("data",n2.news_d);
    		
  		
    	}
    }

	
}
