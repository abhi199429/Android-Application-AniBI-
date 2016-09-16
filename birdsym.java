package com.example.prayas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;

public class birdsym extends Activity{
Button beye,bneck,bwing1,bwing2,bstom,btail,bfoot;
TextView birt1;
public static TextView t1,t2;


public static String s1="Anisocoria";
public static String dname,ddetail;
CheckBox birdc1,birdc2,birdc3;


public static class diseas
{
	String Dis_name;
	String Dis_details;
	
	
}
public static diseas n2=new diseas();
public ArrayList<diseas> n1=new ArrayList<diseas>();


public static String NAMESPACE = "http://tempuri.org/";
public static String  URL = Homepage.ipadd;
public static String SOAP_ACTION = "http://tempuri.org/select_for_diseas";
String METHOD_NAME = "select_for_diseas"; 

@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
setContentView(R.layout.birdsym);
beye=(Button)findViewById(R.id.birdeye);
bneck=(Button)findViewById(R.id.birdneck);
bwing1=(Button)findViewById(R.id.birdwing1);
bwing2=(Button)findViewById(R.id.birdwing2);
bstom=(Button)findViewById(R.id.birdstomach);
btail=(Button)findViewById(R.id.birddtail);
bfoot=(Button)findViewById(R.id.birdfoot);
birt1=(TextView)findViewById(R.id.birdtext);

//birdc1.setVisibility(birdc1.VISIBLE);	
//birdc2.setVisibility(birdc2.INVISIBLE);	
//birdc3.setVisibility(TRIM_MEMORY_UI_HIDDEN);	
	
//birdc1.setText(" ");
//birdc2.setText(" ");
//birdc3.setText(" ");


beye.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		birt1.setText(beye.getText());
		
		
		birdc1=(CheckBox)findViewById(R.id.birdcheckBox1);
		birdc2=(CheckBox)findViewById(R.id.birdcheckBox2);
		birdc3=(CheckBox)findViewById(R.id.birdcheckBox3);
		s1=birdc1.getText().toString();
	//	birdc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		birdc1.setText("Anisocoria in Dogs");
		birdc2.setText("Chronic Lymphocytic Cancer in Dogs");
		birdc3.setText("Chronic Lymphocytic Cancer in Dogs");
		birdc1.setChecked(false);
		birdc2.setChecked(false);
		birdc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		birdc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=birdc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				birdc1.setChecked(true);
				birdc2.setChecked(false);
				birdc3.setChecked(false);
			}
		});
		
		birdc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				birdc2.setChecked(true);
				
				birdc1.setChecked(false);
				birdc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		birdc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				birdc1.setChecked(true);
				
				birdc2.setChecked(false);
				birdc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
	}
});


bneck.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		birt1.setText(bneck.getText());
		
		birdc1=(CheckBox)findViewById(R.id.birdcheckBox1);
		birdc2=(CheckBox)findViewById(R.id.birdcheckBox2);
		birdc3=(CheckBox)findViewById(R.id.birdcheckBox3);
		s1=birdc1.getText().toString();
	//	birdc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		birdc1.setText("Anisocoria in Dogs");
		birdc2.setText("Chronic Lymphocytic Cancer in Dogs");
		birdc3.setText("Chronic Lymphocytic Cancer in Dogs");
		birdc1.setChecked(false);
		birdc2.setChecked(false);
		birdc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		birdc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=birdc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				birdc1.setChecked(true);
				birdc2.setChecked(false);
				birdc3.setChecked(false);
			}
		});
		
		birdc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				birdc2.setChecked(true);
				
				birdc1.setChecked(false);
				birdc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		birdc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				birdc1.setChecked(true);
				
				birdc2.setChecked(false);
				birdc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
		
	}
});

bwing1.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		birt1.setText(bwing1.getText());
		
		birdc1=(CheckBox)findViewById(R.id.birdcheckBox1);
		birdc2=(CheckBox)findViewById(R.id.birdcheckBox2);
		birdc3=(CheckBox)findViewById(R.id.birdcheckBox3);
		s1=birdc1.getText().toString();
	//	birdc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		birdc1.setText("Anisocoria in Dogs");
		birdc2.setText("Chronic Lymphocytic Cancer in Dogs");
		birdc3.setText("Chronic Lymphocytic Cancer in Dogs");
			birdc1.setChecked(false);
		birdc2.setChecked(false);
		birdc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		birdc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=birdc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				birdc1.setChecked(true);
				birdc2.setChecked(false);
				birdc3.setChecked(false);
			}
		});
		
		birdc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				birdc2.setChecked(true);
				
				birdc1.setChecked(false);
				birdc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		birdc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				birdc1.setChecked(true);
				
				birdc2.setChecked(false);
				birdc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
		
	}
});


bwing2.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		birt1.setText(bwing2.getText());
		
		birdc1=(CheckBox)findViewById(R.id.birdcheckBox1);
		birdc2=(CheckBox)findViewById(R.id.birdcheckBox2);
		birdc3=(CheckBox)findViewById(R.id.birdcheckBox3);
		s1=birdc1.getText().toString();
	//	birdc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		birdc1.setText("Anisocoria in Dogs");
		birdc2.setText("Chronic Lymphocytic Cancer in Dogs");
		birdc3.setText("Chronic Lymphocytic Cancer in Dogs");
			birdc1.setChecked(false);
		birdc2.setChecked(false);
		birdc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		birdc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=birdc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				birdc1.setChecked(true);
				birdc2.setChecked(false);
				birdc3.setChecked(false);
			}
		});
		
		birdc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				birdc2.setChecked(true);
				
				birdc1.setChecked(false);
				birdc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		birdc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				birdc1.setChecked(true);
				
				birdc2.setChecked(false);
				birdc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
		
	}
});


bstom.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		birt1.setText(bstom.getText());
		
		birdc1=(CheckBox)findViewById(R.id.birdcheckBox1);
		birdc2=(CheckBox)findViewById(R.id.birdcheckBox2);
		birdc3=(CheckBox)findViewById(R.id.birdcheckBox3);
		s1=birdc1.getText().toString();
	//	birdc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		birdc1.setText("Anisocoria in Dogs");
		birdc2.setText("Chronic Lymphocytic Cancer in Dogs");
		birdc3.setText("Chronic Lymphocytic Cancer in Dogs");
		birdc1.setChecked(false);
		birdc2.setChecked(false);
		birdc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		birdc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=birdc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				birdc1.setChecked(true);
				birdc2.setChecked(false);
				birdc3.setChecked(false);
			}
		});
		
		birdc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				birdc2.setChecked(true);
				
				birdc1.setChecked(false);
				birdc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		birdc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				birdc1.setChecked(true);
				
				birdc2.setChecked(false);
				birdc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
		
	}
});



btail.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		birt1.setText(btail.getText());
		
		birdc1=(CheckBox)findViewById(R.id.birdcheckBox1);
		birdc2=(CheckBox)findViewById(R.id.birdcheckBox2);
		birdc3=(CheckBox)findViewById(R.id.birdcheckBox3);
		s1=birdc1.getText().toString();
	//	birdc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		birdc1.setText("Anisocoria in Dogs");
		birdc2.setText("Chronic Lymphocytic Cancer in Dogs");
		birdc3.setText("Chronic Lymphocytic Cancer in Dogs");
		birdc1.setChecked(false);
		birdc2.setChecked(false);
		birdc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		birdc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=birdc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				birdc1.setChecked(true);
				birdc2.setChecked(false);
				birdc3.setChecked(false);
			}
		});
		
		birdc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				birdc2.setChecked(true);
				
				birdc1.setChecked(false);
				birdc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		birdc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				birdc1.setChecked(true);
				
				birdc2.setChecked(false);
				birdc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		
		
	}
});


bfoot.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		birt1.setText(bfoot.getText());
		
		birdc1=(CheckBox)findViewById(R.id.birdcheckBox1);
		birdc2=(CheckBox)findViewById(R.id.birdcheckBox2);
		birdc3=(CheckBox)findViewById(R.id.birdcheckBox3);
		s1=birdc1.getText().toString();
	//	birdc1.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc2.setVisibility(TRIM_MEMORY_COMPLETE);
	//	birdc3.setVisibility(TRIM_MEMORY_COMPLETE);
	//	t1=(TextView)findViewById(R.id.disdetailtv1);
		//t2=(TextView)findViewById(R.id.textView2);
		
		birdc1.setText("Anisocoria in Dogs");
		birdc2.setText("Chronic Lymphocytic Cancer in Dogs");
		birdc3.setText("Chronic Lymphocytic Cancer in Dogs");
			birdc1.setChecked(false);
		birdc2.setChecked(false);
		birdc3.setChecked(false);
		//String str1="Anisocoria in Dogs The pupil is the circular opening in the center of the eye that allows light to pass through. The pupil expands when there is little light present, and contracts when there is a greater amount of light present. Anisocoria refers to an unequal pupil size. This condition causes one of the dog's pupils to be smaller than the other. With the proper detection of the disease's underlying cause, treatment plans are available that should resolve the issue.";
		
		
		birdc1.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				s1=birdc1.getText().toString();
				
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj2=new DoLogin2();
				obj2.execute();
				
				birdc1.setChecked(true);
				birdc2.setChecked(false);
				birdc3.setChecked(false);
			}
		});
		
		birdc2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc2.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj3=new DoLogin2();
				obj3.execute();

				birdc2.setChecked(true);
				
				birdc1.setChecked(false);
				birdc3.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});
		
		birdc3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				s1=birdc3.getText().toString();
				Intent i1=new Intent(getApplicationContext(), dsym1.class);
				startActivity(i1);
			
				DoLogin2 obj4=new DoLogin2();
				obj4.execute();
				birdc1.setChecked(true);
				
				birdc2.setChecked(false);
				birdc1.setChecked(false);
				//t2.setText(n2.Dis_name);
				//t1.setText(n2.Dis_details);
			}
		});

		

		

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
	        request.addProperty("Dis_name",s1);

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
		pdia = new ProgressDialog(birdsym.this);
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
	//	Toast.makeText(getApplicationContext(), pro[0].toString(), Toast.LENGTH_SHORT).show();
	
		n2.Dis_name=pro[0];
		n2.Dis_details=pro[1];
		ddetail=pro[1];
		//Toast.makeText(getApplicationContext(), ddetail, 200).show();
		n1.add(n2);
		dsym1.t3.setText(n2.Dis_name);
		dsym1.t5.setText(ddetail);
		
		//t2.setText(n2.Dis_name);
		//t1.setText(n2.Dis_details);

			//Log.d("data",n2.news_d);
			
		
	}
}
}


