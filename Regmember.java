package com.example.prayas;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import com.example.prayas.Reguser.ReDoLogin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regmember extends Activity {


	
	EditText er1,er2,er3,er4,er5,er6,er7,er8;
	Button brur1;
	Spinner spr1,spr2;
	DatePicker dpr1;
	RadioButton rbr1,rbr2;
	TextView tr1,tr2,tr3,tr4,tr5,tr6,tr7,tr8,tr9,tr10;
	int flag=0;
	
	public static String NAMESPACE = "http://tempuri.org/";
	public static String  URL = Homepage.ipadd; 
	public static String SOAP_ACTION = "http://tempuri.org/insert";
	String METHOD_NAME = "insert"; 
	
	public static String NAMESPACE1 = "http://tempuri.org/";
	public static String  URL1 = Homepage.ipadd; 
	public static String SOAP_ACTION1 = "http://tempuri.org/selectusername";
	String METHOD_NAME1 = "selectusername"; 
	

	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regmember);
        er1=(EditText)findViewById(R.id.reg_fullname);
        er2=(EditText)findViewById(R.id.reg1_fullname);
        er3=(EditText)findViewById(R.id.reg_email);
        er4=(EditText)findViewById(R.id.reg_password);
        er5=(EditText)findViewById(R.id.reg_mobileno);
        er6=(EditText)findViewById(R.id.bdate);
        er7=(EditText)findViewById(R.id.adress);
        er8=(EditText)findViewById(R.id.confirmpas);
        
        
       
       
        tr1=(TextView)findViewById(R.id.textView10);
        tr2=(TextView)findViewById(R.id.chatcustomtextView2);
        tr3=(TextView)findViewById(R.id.textView3);
        tr4=(TextView)findViewById(R.id.textView4);
        tr5=(TextView)findViewById(R.id.textView5);
        tr6=(TextView)findViewById(R.id.textView6);
        tr7=(TextView)findViewById(R.id.textView7);
        tr8=(TextView)findViewById(R.id.textView8);
        tr9=(TextView)findViewById(R.id.textView9);
        tr10=(TextView)findViewById(R.id.textView11);
        
        brur1=(Button)findViewById(R.id.btnRegister);
        spr1=(Spinner)findViewById(R.id.spinner1);
        spr2=(Spinner)findViewById(R.id.spinner2);
        
        rbr1=(RadioButton)findViewById(R.id.radioButton1);
        rbr2=(RadioButton)findViewById(R.id.radioButton2);
        
        
        brur1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "half success", Toast.LENGTH_LONG).show();
				
				 String email = er3.getText().toString().trim();
				 String mob=er5.getText().toString().trim();
				 //validate email
			  	 
				 String e=er2.getText().toString().trim();
				 String e11=er1.getText().toString().trim();
				 if(isemp1(e11))
				 { flag=1;
					 er1.setError("Empty Full Name");
				 }
				 
				 if (isemp1(e)) {
					 flag=1;
						er2.setError("Empty field is not allowed");
					}

				 
				 if (!isValidEmail(email)) {
					 flag=1;
						er3.setError("Invalid Email");
					}

		
				 if(isemp1(er4.getText().toString().trim()))
				 { flag=1;
					 er4.setError("Password frield cannot be kept empty");
				 }
			
				 if(!ispass(er4.getText().toString().trim()))
				 { flag=1;
					 er4.setError("Password and confirm password must be same");
					 er8.setError("Password and confirm password must be same");
				 
				 }
			 
				 if (!isValidmobile(mob)) { flag=1;
						er5.setError("Invalid Mobile number");
					}
				 

				 if(isemp1(er6.getText().toString().trim()))
				 { flag=1;
					 er6.setError("BDATE field cannot be kept empty");
				 }
			
				 if(isemp1(er7.getText().toString().trim()))
				 { flag=1;
					 er7.setError("Adress frield cannot be kept empty");
				 }
			
				 
				 
				 if(flag==0)
				 {
			DoLogin obj=new DoLogin();
				obj.execute();
				 }
			}
		});
        
        
        
     }
    
    private boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

    
    

    private boolean ispass(String pass) {
		String pass1 = er8.getText().toString().trim();

		if(pass.equals(pass1) && !pass.equals(null))
		return true;
		else
		return false;
	}
    
    private boolean isemp(String email) {
		String EMAIL_PATTERN = "";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
    
    private boolean isemp1(String email) {
		String EMAIL_PATTERN = "";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}


    private boolean isValidmobile(String email) {
		String EMAIL_PATTERN =  "[0-9]{10}";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}


    
    class DoLogin extends AsyncTask<Void, Void, String>
    {
    	private ProgressDialog pdia;
    	
    	@Override
    	protected String doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		
    		try
    		{
    			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    	        request.addProperty("M_name", er1.getText().toString());
    	        request.addProperty("M_uname", er2.getText().toString());
    	        request.addProperty("M_pwd", er4.getText().toString());
    	        request.addProperty("M_eid", er3.getText().toString());
    	        request.addProperty("M_mobno", er5.getText().toString());
    	        request.addProperty("M_city", 1);
    	        request.addProperty("M_bdate", er6.getText().toString());
    	        request.addProperty("M_address", er7.getText().toString());
    	        request.addProperty("M_gender","male");
    	        
    	            	        
    	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	        envelope.dotNet=true;
    	        envelope.setOutputSoapObject(request);
    	        
    	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
    	        
    	        androidHttpTransport.call(SOAP_ACTION, envelope);
    	        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
    	        
    	        Log.d("message","MEssage : "+resultstr.toString());
    	        return resultstr.toString();
    	        
//    	        Toast.makeText(Reg.this, resultstr.toString(), Toast.LENGTH_SHORT).show();
    		}
    		catch(Exception e)
    		{
    			Log.e("error13", e.toString());
    			return "fail";
    			
    		}
    			
    		
    		
    	}
    	
    	
    	@Override
    	protected void onPreExecute() {
    		// TODO Auto-generated method stub
    		super.onPreExecute();
    		pdia = new ProgressDialog(Regmember.this);
    		pdia.setCanceledOnTouchOutside(false);
            pdia.setMessage("Dhiraj rakh..........");
            pdia.show(); 
    	}
    	
    	
    	@Override
    	protected void onPostExecute(String result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);    	    	
    		
    		
    		pdia.dismiss();
    		Toast.makeText(Regmember.this, result, Toast.LENGTH_LONG).show();
    		
    		
    		Intent i1=new Intent(Regmember.this,Homepage.class);
			startActivity(i1);
		
    	}

    	

    }
    
    
    
    
    
    class ReDoLogin1 extends AsyncTask<Void, Void, String>
    {
    	private ProgressDialog pdia;
    	
    	@Override
    	protected String doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		
    		try
    		{
    			SoapObject request = new SoapObject(NAMESPACE1, METHOD_NAME1);
    	        request.addProperty("M_uname", er2.getText().toString());
    	        
    	            	        
    	        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    	        envelope.dotNet=true;
    	        envelope.setOutputSoapObject(request);
    	        
    	        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL1);
    	        
    	        androidHttpTransport.call(SOAP_ACTION1, envelope);
    	        SoapPrimitive resultstr = (SoapPrimitive)envelope.getResponse();
    	        
    	        Log.d("message","MEssage : "+resultstr.toString());
    	        return resultstr.toString();
    	        
//    	        Toast.makeText(Reg.this, resultstr.toString(), Toast.LENGTH_SHORT).show();
    		}
    		catch(Exception e)
    		{
    			Log.e("error13", e.toString());
    			return "fail";
    			
    		}
    			
    		
    		
    	}
    	
    	
    	/*@Override
    	protected void onPreExecute() {
    		// TODO Auto-generated method stub
    		super.onPreExecute();
    		pdia = new ProgressDialog(Reguser.this);
    		pdia.setCanceledOnTouchOutside(false);
            pdia.setMessage("loading..........");
            pdia.show(); 
    	}*/
    	
    	
    	@Override
    	protected void onPostExecute(String result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);    	    	
    		if(result.equals("ok"))
    		{
    			DoLogin r1=new DoLogin();
        		r1.execute();
        	
    			
    		}
    		
    		else if(result.equals("true"))
    		{
    			Toast.makeText(Regmember.this, "username is already in used", Toast.LENGTH_LONG);
    		}
    	
    		Toast.makeText(Regmember.this,"Username is already in used",Toast.LENGTH_LONG).show();
    			}


    }



}

        

