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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reguser extends Activity {

	
	EditText e1,e2,e3,e4,e5,e6,e7;
	Button bru1;
	Spinner sp1,sp2;
	DatePicker dp1;
	RadioButton rb1,rb2;
	TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
	int flag=0;
	
	
	public static String NAMESPACE = "http://tempuri.org/";
	public static String  URL = Homepage.ipadd; 
	public static String SOAP_ACTION = "http://tempuri.org/insertreg";
	String METHOD_NAME = "insertreg"; 

	public static String NAMESPACE1 = "http://tempuri.org/";
	public static String  URL1 = Homepage.ipadd; 
	public static String SOAP_ACTION1 = "http://tempuri.org/selectusername";
	String METHOD_NAME1 = "selectusername"; 
				
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reguser);
        e1=(EditText)findViewById(R.id.reg_fullname);
        e2=(EditText)findViewById(R.id.reg1_fullname);
        e3=(EditText)findViewById(R.id.reg_email);
        e4=(EditText)findViewById(R.id.reg_password);
        e5=(EditText)findViewById(R.id.reg_mobileno);
        e6=(EditText)findViewById(R.id.bdate);
        e7=(EditText)findViewById(R.id.confirm);
        
        
       
        String email = e3.getText().toString().trim();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        // onClick of button perform this simplest code.
        if (email.matches(emailPattern))
        {
        //Toast.makeText(getApplicationContext(),"valid email address",Toast.LENGTH_SHORT).show();
        }
        else 
        {
        //Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
        }
        t1=(TextView)findViewById(R.id.textView10);
        t2=(TextView)findViewById(R.id.chatcustomtextView2);
        t3=(TextView)findViewById(R.id.textView3);
        t4=(TextView)findViewById(R.id.textView4);
        t5=(TextView)findViewById(R.id.textView5);
        t6=(TextView)findViewById(R.id.textView6);
        t7=(TextView)findViewById(R.id.textView7);
        t8=(TextView)findViewById(R.id.textView8);
        t9=(TextView)findViewById(R.id.textView9);
        t10=(TextView)findViewById(R.id.textView10);
        
        bru1=(Button)findViewById(R.id.btnRegister);
        sp1=(Spinner)findViewById(R.id.spinner1);
        sp2=(Spinner)findViewById(R.id.spinner2);
        
        rb1=(RadioButton)findViewById(R.id.radioButton1);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        
        
        bru1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Intent i1=new Intent("android.intent.action.regmember");
				//startActivity(i1);
				//Toast.makeText(getApplicationContext(), "half success", Toast.LENGTH_LONG).show();
				String email = e3.getText().toString().trim();
				 String mob=e5.getText().toString().trim();
					
				 if (!isValidEmail(email)) {
					 flag=1;
						e3.setError("Invalid Email");
					}
				 if (!isValidmobile(mob)) {
					 flag=1;
						e5.setError("Invalid Mobile number");
					}

				 

				 if(isemp(e1.getText().toString().trim()))
				 { flag=1;
					 e1.setError("Full name field cannot be kept empty");
				 }
			
			
				 if(isemp(e2.getText().toString().trim()))
				 { flag=1;
					 e2.setError("USER name field cannot be kept empty");
				 }
			
				 if(isemp(e4.getText().toString().trim()))
				 { flag=1;
					 e4.setError("PASSWORD field cannot be kept empty");
				 }

				 if(!ispass(e4.getText().toString().trim()))
				 { flag=1;
					e4.setError("Password and confirm password must be same");
					e7.setError("Password and confirm password must be same");
					
				 }
						
			
				 if(isemp(e6.getText().toString().trim()))
				 { flag=1;
					 e6.setError("Bdate frield cannot be kept empty");
				 }
			
				 if(flag==0)
				{
				ReDoLogin1 obj1=new ReDoLogin1();
					obj1.execute();			
				}
			}
		});


        
     }

    private boolean isValidmobile(String email) {
		String EMAIL_PATTERN =  "[0-9]{10}";
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}


    private boolean ispass(String pass) {
		String pass1 = e7.getText().toString().trim();

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
    


    
    private boolean isValidEmail(String email) {
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}


    class ReDoLogin extends AsyncTask<Void, Void, String>
    {
    	private ProgressDialog pdia;
    	
    	@Override
    	protected String doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		
    		try
    		{
    			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
    	        request.addProperty("M_name", e1.getText().toString());
    	        request.addProperty("M_uname", e2.getText().toString());
    	        request.addProperty("M_pwd", e4.getText().toString());
    	        request.addProperty("M_eid", e3.getText().toString());
    	        request.addProperty("M_mobno", e5.getText().toString());
    	        request.addProperty("M_city", 1);
    	        request.addProperty("M_bdate", e6.getText().toString());
    	       // request.addProperty("M_address", e7.getText().toString());
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
    			return "failfail";
    			
    		}
    			
    		
    		
    	}
    	
    	
    	@Override
    	protected void onPreExecute() {
    		// TODO Auto-generated method stub
    		super.onPreExecute();
    		pdia = new ProgressDialog(Reguser.this);
    		pdia.setCanceledOnTouchOutside(false);
            pdia.setMessage("loading..........");
            pdia.show(); 
    	}
    	
    	
    	@Override
    	protected void onPostExecute(String result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);    	    	
    		
    		
    		pdia.dismiss();
    		Toast.makeText(Reguser.this, result, Toast.LENGTH_LONG).show();
    		
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
    	        request.addProperty("M_uname", e2.getText().toString());
    	        
    	            	        
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
    			ReDoLogin r1=new ReDoLogin();
        		r1.execute();
        	
    			Intent i1=new Intent(Reguser.this,Memhome.class);
    			startActivity(i1);
    		
    		}
    		
    		/*else if(result.equals("true"))
    		{
    			Toast.makeText(Reguser.this, "username is already in used", Toast.LENGTH_LONG);
    		}
    	*/
    		Toast.makeText(Reguser.this, "Username Already Exists", Toast.LENGTH_LONG).show();
    			}


    }
    
}
