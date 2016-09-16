package com.example.prayas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class chatcustom extends Activity{

	
	TextView chatcustomtv1;
	ListView chatcustomlv1;
	EditText chatedittx1;
	Button chatcustomb1;

    public static String NAMESPACE = "http://tempuri.org/";
    public static String  URL = Homepage.ipadd;
    public static String SOAP_ACTION = "http://tempuri.org/insertchat";
    String METHOD_NAME = "insertchat"; 

    public static String SOAP_ACTION1 = "http"
    		+ "://tempuri.org/selectchat";
    String METHOD_NAME1 = "selectchat"; 

    public static String SOAP_ACTION2 = "http"
    		+ "://tempuri.org/sendmsg";
    String METHOD_NAME2 = "sendmsg"; 
 


    
	public static String  formattedDate,dat,tim,sender,receiver,msg;	
	public static class chatinfo {

	public  String msg;
	public  String time;
	public  String sender;

	public  String reciver;
		
}
	public static ArrayList<chatinfo> n1=new ArrayList<chatinfo>();
	public static customadapterchat cd;
public static ArrayList<String> msglist=new ArrayList<String>();
    public static chatinfo n2=new chatinfo(); 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.chat);
	    chatcustomlv1=(ListView)findViewById(R.id.chatlistView1);
	    chatcustomtv1=(TextView)findViewById(R.id.chattextView1);
	    chatcustomb1=(Button)findViewById(R.id.chatbutton1);
	    chatedittx1=(EditText)findViewById(R.id.chateditText1);    
	    sender=loginprayas.username.toString();
	    chatcustomtv1.setText(chat.selectedlist.toString());
 	    	receiver=chat.selectedlist.toString();
 	    
 	    	
 	    	
 	    	DoLogin3 d3=new DoLogin3();
	    d3.execute();
	
	    
	    Calendar c = Calendar.getInstance();
	     //   System.out.println("Current time => "+c.getTime());
	        
	        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	         formattedDate = df.format(c.getTime()); 	
	      //  Toast.makeText(chat.this, formattedDate, Toast.LENGTH_SHORT).show();
	            
chatcustomb1.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		   sender=loginprayas.username.toString();
	 		receiver=chat.selectedlist.toString();
	 		
		dat=formattedDate.substring(0,10);
		tim=formattedDate.substring(11, 16);
		msg=chatedittx1.getText().toString();
		chatedittx1.setText("");
		
	DoLogin4 d2=new DoLogin4();
	d2.execute();
		
	}
});
//Toast.makeText(chat.this, tim, Toast.LENGTH_SHORT).show();


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
	        request.addProperty("send",sender);
	        request.addProperty("recv",receiver);
	        request.addProperty("time",tim);
	        request.addProperty("date",dat);
	        request.addProperty("msg",msg);
	        Log.d("send", sender);
	        Log.d("recv", receiver);
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
		pdia = new ProgressDialog(chatcustom.this);
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
	//	cha1.add(pro[i].toString());	
		}
	 // chad1=new ArrayAdapter<String>(chat.this,android.R.layout.simple_list_item_1,cha1);      
	   	    			
	 // chl1.setAdapter(chad1);
	 // registerForContextMenu(chl1);
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
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME1);
			request.addProperty("send",loginprayas.username.toString());
	        request.addProperty("recv",chat.selectedlist.toString());
	        Log.d("send", loginprayas.username);
	        Log.d("recv",chat.selectedlist.toString());
	       
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
		pdia = new ProgressDialog(chatcustom.this);
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
			//Toast.makeText(getApplicationContext(),pro[i],1).show();
			
			String prodata1[]=pro[i].split("`");
			n2 = new chatinfo();
				
			n2.time=prodata1[0];
	//		Toast.makeText(getApplicationContext(),n2.time,1).show();
			
			
		n2.msg=prodata1[1];
		n2.sender=prodata1[2];
		n2.reciver=prodata1[3];
	//	Toast.makeText(getApplicationContext(),n2.msg,1).show();
		
		n1.add(n2);
		}

					   	    			
		final customadapterchat cd =new customadapterchat(chatcustom.this, n1);
		

	        //to scroll the list view to bottom on data change
		
		 
		chatcustomlv1.setAdapter(cd);    		
		
		
		
		/*cd.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                chatcustomlv1.setSelection(cd.getCount() - 1);
            }
        });
 
		*/
		
	
	}
	

	
}
	class DoLogin4 extends AsyncTask<Void, Void, String>
{
	private ProgressDialog pdia;
	
	@Override
	protected String doInBackground(Void... params) {
		// TODO Auto-generated method stub
		
		try
		{
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME2);
			request.addProperty("send",loginprayas.username.toString());
	        request.addProperty("recv",chat.selectedlist.toString());
	        request.addProperty("msg",msg);
	        
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	        envelope.dotNet=true;
	        envelope.setOutputSoapObject(request);
	        
	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
	        
	        androidHttpTransport.call(SOAP_ACTION2, envelope);
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
		pdia = new ProgressDialog(chatcustom.this);
		pdia.setCanceledOnTouchOutside(false);
        pdia.setMessage("Loading...");
        pdia.show(); 
	}
	
	/*
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);    	    	
		Log.d("data", result);
		
		pdia.dismiss();
		String pro[]=result.split(">");
		chatinfo c2=new chatinfo();
		for(int i=0;i<5;i++)
		{
			String pro1[]=pro[i].split("`");
		c2.time=pro1[0].toString();		
		c2.msg=pro[1].toString();
		msglist.add(c2);
		}
		
		customadapterchat cd1=new customadapterchat(chatcustom.this,msglist);
		//ArrayAdapter<String> chad1=new ArrayAdapter<String>(chatcustom.this,android.R.layout.simple_list_item_1,msgtime);      
		   
		chatcustomlv1.setAdapter(cd1);
	  //chad1=new ArrayAdapter<String>(chat.this,android.R.layout.simple_list_item_1,cha1);      
	   	    			
	 // chl1.setAdapter(chad1);
	  
	}
	
	
	*/
	
	
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);    	    	
		Log.d("data", result);
		
		pdia.dismiss();
		//Toast.makeText(getApplicationContext(), "hi", Toast.LENGTH_LONG).show();
	
		DoLogin3 d3=new DoLogin3();
		d3.execute();
		
		
	
	}
	

				

}
	
	}



