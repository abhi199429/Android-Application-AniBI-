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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class chat extends Activity {

	ListView chl1;
	Button chb1;
	EditText che1;
	TextView cht1;
	public static ArrayList<String> cha1=new ArrayList<String>();
	public static ArrayAdapter<String> chad1;
	
	 
    public static String NAMESPACE = "http://tempuri.org/";
    public static String  URL = Homepage.ipadd;
    public static String SOAP_ACTION = "http://tempuri.org/selectchatuser";
    String METHOD_NAME = "selectchatuser"; 

    public static String selectedlist;
	
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.chathome);
	chl1=(ListView)findViewById(R.id.chathomelistView1);
chb1=(Button)findViewById(R.id.chatbutton1);
che1=(EditText)findViewById(R.id.chateditText1);
cht1=(TextView)findViewById(R.id.chattextView1);	


	DoLogin2 dl2=new DoLogin2();
	dl2.execute();
	chl1.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position,
				long arg3) {
			// TODO Auto-generated method stub
			
	  selectedlist = (String) (chl1.getItemAtPosition(position));
	
		//	Toast.makeText(chat.this,selectedlist,1).show();
			      // Now we display formattedDate value in TextView
			Intent i1=new Intent(chat.this,chatcustom.class);
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
	        //request.addProperty("news", "sdnsal");

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
		pdia = new ProgressDialog(chat.this);
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
		String pro[]=result.split(">");
		for(int i=0;i<pro.length;i++)
		{
		cha1.add(pro[i].toString());	
		}
	  chad1=new ArrayAdapter<String>(chat.this,android.R.layout.simple_list_item_1,cha1);      
	   	    			
	  chl1.setAdapter(chad1);
	  registerForContextMenu(chl1);
	}
	
	
		
}
				

	
	
	}

