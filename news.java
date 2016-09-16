package com.example.prayas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class news  extends Activity {
	public static int i;
	ListView l1;
	ListAdapter lad; 
	customadapter cd;
	ProgressDialog pDialog;
	Bitmap bitmap;
	ImageView img;

	public String add;
	public static class News {

		String news_d;
		String date;
		String Image;
		String new_t;
		ImageView image;
		
}
	public static ArrayList<News> n1=new ArrayList<News>();
	public static ArrayList<String> ial1=new ArrayList<String>();
    public static News n2=new News(); 

	public static ArrayList<String> itemname;
	public String imgstring[];

	public static String NAMESPACE = "http://tempuri.org/";
	public static String  URL = Homepage.ipadd;
	public static String SOAP_ACTION = "http://tempuri.org/selectnews";
	String METHOD_NAME = "selectnews"; 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.news);
	l1=(ListView)findViewById(R.id.newslistView1);

	
	
		n1.clear();
			DoLogin2 obj2=new DoLogin2();
			obj2.execute();
			//LoadImage li1=new LoadImage();
			//li1.execute("https://www.learn2crack.com/wp-content/uploads/2014/04/node-cover-720x340.png");
								
      registerForContextMenu(l1);
      
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
	    	        request.addProperty("news", "sdnsal");

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
	    		pdia = new ProgressDialog(news.this);
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
	    		//Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_LONG).show();
	    		

	    		String pro[]=result.split(">");
	    		for(int i=0;i<pro.length;i++)
	    		{
	    			String prodata1[]=pro[i].split("`");
	    		
	    			//Toast.makeText(news.class, pro[i],100).show();
	    			News n2=new News();
	    	//	n2.news_d=prodata1[0];
	    		n2.new_t=prodata1[0];	
	    		n2.date=prodata1[1];
	    		n2.Image=prodata1[2];
	    		ial1.add(n2.Image);
	    		n1.add(n2);
	    		
	    			//Log.d("data",n2.news_d);
	    		}
	    
	    					   	    			
	    		cd =new customadapter(news.this, n1);
	    		
	    		l1.setAdapter(cd);    		
	    	
	    		
	    		
	    		
	    	
	    	}
	    	
	    	
    			
	    }
						
			
			
			
			}

