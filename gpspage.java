package com.example.prayas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class gpspage extends Activity {
	TextView tv1;
	ImageView iv1;
	Button gpsb1,gpsb2;
	EditText ge1; 
	
	
	private static final int CAMERA_REQUEST = 1888;
	public static String formattedDate;
	public static String localTime ;
	public static String selectedPath;
	public static String filename;
	 	public static String NAMESPACE = "http://tempuri.org/";
		public static String  URL = Homepage.ipadd;
		public static String SOAP_ACTION = "http://tempuri.org/insertgps";
		String METHOD_NAME = "insertgps"; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.gpspage);
	gpsb2=(Button)findViewById(R.id.gpsbutton2);
	
	gpsb1=(Button)findViewById(R.id.gpsbutton1);
	iv1=(ImageView)findViewById(R.id.imageView1);
	tv1=(TextView)findViewById(R.id.textView11111);
	ge1=(EditText)findViewById(R.id.gpseditText1);
	ge1.setText("");
	
	Calendar c = Calendar.getInstance();
	System.out.println("Current time => " + c.getTime());

	SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	formattedDate = df.format(c.getTime());
	
	
	Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
	Date currentLocalTime = cal.getTime();
	DateFormat date = new SimpleDateFormat("HH:mm a"); 
	// you can get seconds by adding  "...:ss" to it
	date.setTimeZone(TimeZone.getTimeZone("GMT+5:30")); 

	localTime = date.format(currentLocalTime); 
	
	gpsb1.setOnClickListener(new View.OnClickListener() {
			
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			  Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);  
              startActivityForResult(cameraIntent, CAMERA_REQUEST);  
              //tv1.setText(Homepage.lntd.toString()+""+Homepage.altd.toString()+"abc");
  			
              gpsb2.setVisibility(0);     
  			   
		}
	});

    gpsb2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//Toast.makeText(gpspage.this, Homepage.lntd.toString()+""+Homepage.altd.toString()+"abc", Toast.LENGTH_LONG).show();
			tv1.setText(backgroundservice.lntd+""+backgroundservice.latd +" !!");
			DoLogin2 gp=new DoLogin2();
			gp.execute();
		}
	});
	}
	public String getRealPathFromURI(Uri contentUri) {
        String[] proj = { MediaStore.Video.Media.DATA };
        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
 
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
	      if (requestCode == CAMERA_REQUEST) {  
	       Bitmap photo = (Bitmap) data.getExtras().get("data");  
	       
	       Uri imageUri = data.getData();
           selectedPath=getRealPathFromURI(imageUri);
           File f1 = new File(selectedPath);
           filename=f1.getName();

          
	       
	       iv1.setImageBitmap(photo);  
	      }
	      
}
	   	

	
	
	class DoLogin2 extends AsyncTask<Void, Void, String>
    {
    	ProgressDialog uploading;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            uploading = ProgressDialog.show(gpspage.this, "Uploading File", "Please wait...", false, false);
        }


        
    	@Override
    	protected String doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		
    		try
    		{
    			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    	        request.addProperty("G_uname", loginprayas.username);
    	        request.addProperty("G_longitude",backgroundservice.lntd+"" );
    	        request.addProperty("G_latitude", backgroundservice.latd+"");
    	        request.addProperty("G_img", filename);
    	        request.addProperty("G_details", ge1.getText().toString());
    	        request.addProperty("G_date", formattedDate);
    	        request.addProperty("G_time", localTime);
    	        request.addProperty("G_status", "yes");
    	        
    	        
    	        //request.addProperty("password", e2.getText().toString());
    	        
    	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	        envelope.dotNet=true;
    	        envelope.setOutputSoapObject(request);
    	        
    	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
    	        
    	        androidHttpTransport.call(SOAP_ACTION, envelope);
    	        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
    	        
    	        Log.d("message","MEssage : "+resultstr.toString());
                Log.d("start", "start");
                Calendar c1 = Calendar.getInstance();
    	        
    	           Log.d("uploadpath",selectedPath);/**/
                   Upload u = new Upload();
                   String msg = u.uploadVideo(selectedPath);

                           ArrayList<NameValuePair> data = new ArrayList<NameValuePair>();
                           data.add(new BasicNameValuePair("videoname",filename));
                           data.add(new BasicNameValuePair("userid","1"));
                           data.add(new BasicNameValuePair("datetime1",c1.getTime().toString()));

                    //       JSONObject obj = makeHttpRequest2(MainActivity.address + "addvideo.php", "POST", data);

                      //     Log.d("response",obj.getString("value"));

                        //   return obj.getString("value");
                                         
                  
                  
    	       
    	        return resultstr.toString();
    	    
    	        
    	        

    		}
    		catch(Exception e)
    		{
    			Log.e("error13", e.toString());
    			return "fail,fail";
    			
    		}
    			
    		
    		
    	}
    	
    	
    	
    	
    	@Override
    	protected void onPostExecute(String result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);    	    	
    	    uploading.dismiss();
           // Toast.makeText(getApplicationContext(), Html.fromHtml("<b>Uploaded at <a href='" + s + "'>" + s + "</a></b>"),Toast.LENGTH_LONG).show();
   //Log.d("response",Html.fromHtml("<b>Uploaded at <a href='" + s + "'>" + s + "</a></b>").toString());
           Toast.makeText(gpspage.this, "uploaded", Toast.LENGTH_SHORT).show();
    		Log.d("data", result);
    		
        	
    	        
		   	    			
    		
    		
    		
    	
    	}
    	
    	
    }
	
}